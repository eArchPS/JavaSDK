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
public class Status
{
    @SerializedName("statusGuid")
    private UUID _statusGuid;
    @SerializedName("label")
    private String _label;
    @SerializedName("description")
    private String _description;
    
    public Status() { }
    
    public Status(UUID aStatusGuid, String aLabel, String aDescription)
    {
        this._statusGuid = aStatusGuid;
        this._label = aLabel;
        this._description = aDescription;
    }

    public UUID getStatusGuid()
    {
        return _statusGuid;
    }

    public void setStatusGuid(UUID aStatusGuid)
    {
        this._statusGuid = aStatusGuid;
    }

    public String getLabel()
    {
        return _label;
    }

    public void setLabel(String aLabel)
    {
        this._label = aLabel;
    }

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String aDescription)
    {
        this._description = aDescription;
    }
}

