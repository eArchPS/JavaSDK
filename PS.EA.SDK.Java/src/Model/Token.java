/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author zemljics
 */
public class Token
{
    @SerializedName("token")
    private String _token;

    public Token() { }
    
    public Token(String aToken)
    {
        _token = aToken;
    }

    public void setToken(String aToken)
    {
        _token = aToken;
    }

    public String getToken()
    {
        return _token;
    }
}
