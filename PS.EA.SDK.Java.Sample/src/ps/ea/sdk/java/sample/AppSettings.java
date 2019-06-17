/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps.ea.sdk.java.sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zemljics
 */
public final class AppSettings
{
    private static Boolean _debug;
    private static String _authAddress;
    private static String _apiAddress;
    private static String _certFilePath;
    private static String _certPassword;
    
    private AppSettings() {}
            
    static 
    {      
        try
        {
            FileInputStream appSettingsStream = new FileInputStream(PSEASDKJavaSample.class.getResource("config.properties").getPath());
            Properties appSettings = new Properties();
        
            appSettings.load(appSettingsStream);

            _debug = Boolean.parseBoolean(appSettings.getProperty("env.debug"));
            _authAddress = appSettings.getProperty("api.authAddress");
            _apiAddress = appSettings.getProperty("api.apiAddress");
            _certFilePath = appSettings.getProperty("cert.filePath");
            _certPassword = appSettings.getProperty("cert.password");
        }
        catch (Exception ex)
        {
            Logger.getLogger(AppSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Boolean getDebug()
    {
        return _debug;
    }
    
    public static String getAuthAddress()
    {
        return _authAddress;
    }
    
    public static String getApiAddress()
    {
        return _apiAddress;
    }
    
    public static String getCertFilePath()
    {
        return _certFilePath;
    }
    
    public static String getCertPassword()
    {
        return _certPassword;
    }
}
