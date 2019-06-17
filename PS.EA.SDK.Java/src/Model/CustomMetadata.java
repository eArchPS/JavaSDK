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
public class CustomMetadata
{
    @SerializedName("value")
    private String _value;
    @SerializedName("customMetadataType")
    private CustomMetadataType _customMetadataType;

    public CustomMetadata() { }
    
    public CustomMetadata(String aValue, CustomMetadataType aCustomMetadataType)
    {
        this._value = aValue;
        this._customMetadataType = aCustomMetadataType;
    }    
    
    public String getValue()
    {
        return _value;
    }

    public void setValue(String aValue)
    {
        this._value = aValue;
    }

    public CustomMetadataType getCustomMetadataType()
    {
        return _customMetadataType;
    }

    public void setCustomMetadataType(CustomMetadataType aCustomMetadataType)
    {
        this._customMetadataType = aCustomMetadataType;
    }
}
