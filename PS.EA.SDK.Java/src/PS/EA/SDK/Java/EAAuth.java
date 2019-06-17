/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PS.EA.SDK.Java;

import Api.EAAuthApi;

/**
 *
 * @author zemljics
 */
public class EAAuth
{
    private EAAuthApi _api;
    
    public EAAuth(String aAuthApiAddress, String aCertificatePath, String aCertificatePassword)
    {
        _api = new EAAuthApi(aAuthApiAddress, aCertificatePath, aCertificatePassword);            
    }
    
    public String GetBearerToken() throws Exception
    {
        return _api.GetBearerToken();
    }
}
