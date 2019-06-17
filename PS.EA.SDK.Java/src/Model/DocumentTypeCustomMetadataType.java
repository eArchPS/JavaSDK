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
public class DocumentTypeCustomMetadataType
{
    @SerializedName("customMetadataType")
    private CustomMetadataType _customMetadataType;
    @SerializedName("required")
    private Boolean _required;
    @SerializedName("minValue")
    private String _minValue;
    @SerializedName("maxValue")
    private String _maxValue;
    
    public DocumentTypeCustomMetadataType(CustomMetadataType aCustomMetadataType, Boolean aRequired, String aMinValue, String aMaxValue)
    {
        this._customMetadataType = aCustomMetadataType;
        this._required = aRequired;
        this._minValue = aMinValue;
        this._maxValue = aMaxValue;
    }
    
    public CustomMetadataType getCustomMetadataType()
    {
        return _customMetadataType;
    }
    
    public void setCustomMetadataType(CustomMetadataType _customMetadataType)
    {
        this._customMetadataType = _customMetadataType;
    }
    
    public Boolean getRequired()
    {
        return _required;
    }
    
    public void setRequired(Boolean _required)
    {
        this._required = _required;
    }
    
    public String getMinValue()
    {
        return _minValue;
    }
    
    public void setMinValue(String _minValue)
    {
        this._minValue = _minValue;
    }
    
    public String getMaxValue()
    {
        return _maxValue;
    }
    
    public void setMaxValue(String _maxValue)
    {
        this._maxValue = _maxValue;
    }
}
