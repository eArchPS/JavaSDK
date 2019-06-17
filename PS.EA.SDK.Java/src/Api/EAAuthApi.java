/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import Helpers.CertificateSecurityHelper;
import Model.Token;
import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/**
 *
 * @author zemljics
 */
public class EAAuthApi
{    
    private String _apiAdress;
    private String _certificatePath;
    private String _certificatePassword;    
    
    public EAAuthApi(String aApiAddress, String aCertificatePath, String aCertificatePassword)
    {
        if (aApiAddress == null || aApiAddress.isEmpty())
        {
            throw new NullPointerException("Argument 'aApiAddress' is null or empty.");
        }
        if (aCertificatePath == null || aCertificatePath.isEmpty())
        {
            throw new NullPointerException("Argument 'aCertificatePath' is null or empty.");
        }
        if (aCertificatePassword == null || aCertificatePassword.isEmpty())
        {
            throw new NullPointerException("Argument 'aCertificatePassword' is null or empty.");
        }
        
        _apiAdress = aApiAddress;
        _certificatePath = aCertificatePath;
        _certificatePassword = aCertificatePassword;
    }
    
    public String GetBearerToken() throws Exception
    {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        URL url = null; 
        
        url = new URL(_apiAdress);
        connection = (HttpURLConnection) url.openConnection(); 
        
        if (connection instanceof HttpsURLConnection)
        {
            // Take care of server certificate does match hostname
            
            // TODO: add debug flas checking
            ((HttpsURLConnection) connection).setHostnameVerifier(CertificateSecurityHelper.GetHostnameVerifier()); 
       

            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(new FileInputStream(new File(_certificatePath)), _certificatePassword.toCharArray());

            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, _certificatePassword.toCharArray());

            // Set socket context and setup socket factory
            
            // TODO: add debug flas checking
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(kmf.getKeyManagers(), new TrustManager[]{ CertificateSecurityHelper.GetX509TrustManager() }, null); 

            SSLSocketFactory sockFactory = context.getSocketFactory();
            ((HttpsURLConnection) connection).setSSLSocketFactory(sockFactory);
        } 
        else
        {
            throw new Exception("Established connection is not instance of HttpsURLConnection.");
        }

        connection.setAllowUserInteraction(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        
        connection.setRequestMethod("GET");
        connection.connect(); 

        inputStream = new BufferedInputStream(connection.getInputStream());

        byte[] buff = new byte[1024];

        int bytesRead = 0;
        String tokenJson = "";
        
        while((bytesRead = inputStream.read(buff)) != -1)
        { 
            tokenJson += new String(buff, 0, bytesRead);              
        }
        
        Gson gson = new Gson();
        
        Token t = gson.fromJson(tokenJson, Token.class);
        
        return t.getToken();
    }
}
