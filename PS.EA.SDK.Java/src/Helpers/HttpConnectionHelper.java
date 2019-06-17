/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import PS.EA.SDK.Java.HttpMethod;
import com.google.gson.Gson;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingClientConnectionManager;

/**
 *
 * @author zemljics
 */
public final class HttpConnectionHelper
{
    private static String _certificatePath = null;
    private static String _certificatePassword = null;
    private static String _apiUrl = null;
    
    private HttpConnectionHelper() {}
    
    private static HostnameVerifier GetHostnameVerifier()
    {
        return new HostnameVerifier()
        {
            public boolean verify(String hostname, SSLSession session) { return true; }
            public boolean verify(String hostname, String temp) { return true; }
        };
    }
    
    private static TrustManager[] GetTrustManagers()
    {
        return new TrustManager[]
        {
            new X509TrustManager()
            {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() { return null; }
                public void checkClientTrusted(X509Certificate[] certs, String authType) { }
                public void checkServerTrusted(X509Certificate[] certs, String authType) { }
            }
        };
    }
    
    private static void CheckProperties()
    {
        if (_certificatePath == null || _certificatePath.isEmpty())
        {
            throw new NullPointerException("HttpConnectionHelper certificate path is not defined");
        }        
        if (_certificatePassword == null || _certificatePassword.isEmpty())
        {
            throw new NullPointerException("HttpConnectionHelper certificate password is not defined");
        }
        if (_apiUrl == null || _apiUrl.isEmpty())
        {
            throw new NullPointerException("HttpConnectionHelper api url is not defined");
        }
    }
    
    public static void Initialize(String aApiUrl) throws Exception
    {
        if (aApiUrl == null || aApiUrl.isEmpty())
        {
            throw new NullPointerException("Argument 'aApiUrl' is not supplied or does not have value.");
        }
        
        _apiUrl = aApiUrl;
    }
    
    public static void Initialize(String aApiUrl, String aCertificatePath, String aPassword, String aTrustStore, String aTrustStorePassword)
    {        
        // TODO: add argument checking
        
        _certificatePath = aCertificatePath;
        _certificatePassword = aPassword;
        _apiUrl = aApiUrl;
        
        if (aTrustStore != null && !aTrustStore.isEmpty())
        {
            System.setProperty("javax.net.ssl.trustStore", aTrustStore);
        }
        if (aTrustStorePassword != null && !aTrustStorePassword.isEmpty())
        {
            System.setProperty("javax.net.ssl.trustStorePassword", aTrustStorePassword);
        }
    }
    
    private static String convertStreamToString(java.io.InputStream aStream)
    {
        java.util.Scanner s = new java.util.Scanner(aStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    
    private static void allowMethods(String... methods)
    {
        try
        {
            Field methodsField = HttpURLConnection.class.getDeclaredField("methods");

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);

            methodsField.setAccessible(true);

            String[] oldMethods = (String[]) methodsField.get(null);
            Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
            methodsSet.addAll(Arrays.asList(methods));
            String[] newMethods = methodsSet.toArray(new String[0]);

            methodsField.set(null, newMethods);
        }
        catch (NoSuchFieldException | IllegalAccessException e)
        {
            throw new IllegalStateException(e);
        }
    }
    
    public static String GetResponse(String aApiAction, String aHttpMethod, String aToken, Object aObject) throws Exception
    {   
        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, new TrustManager[]{ CertificateSecurityHelper.GetX509TrustManager() }, new java.security.SecureRandom());
        
        URL url = new URL(_apiUrl + aApiAction);
        
        // Allow PATCH method
        allowMethods("PATCH");
        
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());        
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        
        connection.setRequestProperty("content-type", "application/json");
        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestProperty("Authorization", "Bearer " + aToken);        
        connection.setDoOutput(true);
        connection.setDoInput(true);
        
        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = GetHostnameVerifier();
        
        connection.setHostnameVerifier(allHostsValid);
        
        if (aHttpMethod == HttpMethod.Get)
        {
            connection.setRequestMethod("GET");
            
            InputStream is = connection.getInputStream();
        
            String test = convertStreamToString(is);

            byte[] byteArray = test.getBytes(StandardCharsets.UTF_8);

            return new String(byteArray, StandardCharsets.UTF_8);
        }
        else if (aHttpMethod == HttpMethod.Post)
        {
            connection.setRequestMethod("POST");
        }
        else if (aHttpMethod == HttpMethod.Put)
        {
            connection.setRequestMethod("PUT");
        }
        else if (aHttpMethod == HttpMethod.Delete)
        {
            connection.setRequestMethod("DELETE");
        }
        else if (aHttpMethod == HttpMethod.Patch)
        {
            connection.setRequestMethod("PATCH");            
        }
        else
        {
            throw new Exception("Http method " + aHttpMethod + " is not supported.");
        }
 
        if (aObject != null)
        {
            String s = JsonHelper.ToJson(aObject);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
            outputStreamWriter.write(s);
            outputStreamWriter.flush();
        }
        
        InputStream is = connection.getInputStream();
        
        String content = convertStreamToString(is);
        
        byte[] byteArray = content.getBytes(StandardCharsets.UTF_8);
        
        return new String(byteArray, StandardCharsets.UTF_8);
    }    
    
    public static String Upload(String aUrl, String aToken, HttpEntity aMultipartEntity) throws Exception
    {
        TrustManager[] trustAllCerts = GetTrustManagers();
 
        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());        
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        
        String uri = _apiUrl + aUrl;
        
        TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
        SSLSocketFactory sf = new SSLSocketFactory(acceptingTrustStrategy, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("https", 8443, sf));
        ClientConnectionManager ccm = new PoolingClientConnectionManager(registry);
        
        CloseableHttpClient httpClient = new DefaultHttpClient(ccm);
        HttpPost uploadFile = new HttpPost(uri);

        uploadFile.setHeader("charset", "utf-8");
        uploadFile.setHeader("Authorization", "Bearer " + aToken);
        
        uploadFile.setEntity(aMultipartEntity);
        CloseableHttpResponse response = httpClient.execute(uploadFile);
        HttpEntity responseEntity = response.getEntity();
        
        InputStream is = responseEntity.getContent();
        
        String test = convertStreamToString(is);
        
        byte[] byteArray = test.getBytes(StandardCharsets.UTF_8);
        
        return new String(byteArray, StandardCharsets.UTF_8);
    }
}
