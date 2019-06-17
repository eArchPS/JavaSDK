/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

/**
 *
 * @author zemljics
 */
public final class CertificateSecurityHelper
{
    private CertificateSecurityHelper() { }
    
    public static HostnameVerifier GetHostnameVerifier()
    {
        return new HostnameVerifier()
        {
            public boolean verify(String hostname, SSLSession session)
            {
                return true;
            }

            public boolean verify(String hostname, String temp)
            {
                return true;
            }
        };
    }
    
    public static X509TrustManager GetX509TrustManager()
    {
        return new X509TrustManager()
        {

            public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
            { }

            public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
            { }

            public X509Certificate[] getAcceptedIssuers() 
            {
                return new X509Certificate[0];
            }

            public boolean isClientTrusted(X509Certificate[] arg0)
            {
                return true;
            }

            public boolean isServerTrusted(X509Certificate[] arg0)
            {
                return true;
            }
        };
    }
}
