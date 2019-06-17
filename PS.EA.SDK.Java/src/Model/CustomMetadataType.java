/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.google.gson.annotations.SerializedName;
import java.util.UUID;

/**
 *
 * @author zemljics
 */
public class CustomMetadataType
{
    @SerializedName("customMetadataTypeGuid")
    private UUID _customMetadataTypeGuid;
    @SerializedName("label")
    private String _label;
    @SerializedName("dataType")
    private String _dataType;
    @SerializedName("format")
    private String _format;
    @SerializedName("length")
    private Integer _length;
    @SerializedName("searchable")
    private Boolean _searchable;

    public CustomMetadataType() { }
    
    public CustomMetadataType(UUID aCustomMetadataTypeGuid, String aLabel, String aDataType, String aFormat, Integer aLength, Boolean aSearchable)
    {
        this._customMetadataTypeGuid = aCustomMetadataTypeGuid;
        this._label = aLabel;
        this._dataType = aDataType;
        this._format = aFormat;
        this._length = aLength;
        this._searchable = aSearchable;
    }    
    
    public UUID getCustomMetadataTypeGuid()
    {
        return _customMetadataTypeGuid;
    }

    public void setCustomMetadataTypeGuid(UUID _customMetadataTypeGuid)
    {
        this._customMetadataTypeGuid = _customMetadataTypeGuid;
    }

    public String getLabel()
    {
        return _label;
    }

    public void setLabel(String aLabel)
    {
        this._label = aLabel;
    }

    public String getDataType()
    {
        return _dataType;
    }

    public void setDataType(String aDataType)
    {
        this._dataType = aDataType;
    }

    public String getFormat()
    {
        return _format;
    }

    public void setFormat(String aFormat)
    {
        this._format = aFormat;
    }

    public Integer getLength()
    {
        return _length;
    }

    public void setLength(Integer aLength)
    {
        this._length = aLength;
    }
    
    public Boolean getSearchable()
    {
        return _searchable;
    }
    
    public void setSearchable(Boolean aSearchable)
    {
        this._searchable = aSearchable;
    }
}
