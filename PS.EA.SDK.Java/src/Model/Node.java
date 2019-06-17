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
public class Node
{
    @SerializedName("nodeGuid")
    private UUID _nodeGuid;
    @SerializedName("label")
    private String _label;
    @SerializedName("nodeParentGuid")
    private UUID _nodeParentGuid;
    @SerializedName("retentionPeriodInMonths")
    private Integer _retentionPeriodInMonths;
    @SerializedName("retentionType")
    private Integer _retentionType;
    @SerializedName("code")
    private String _code;
    @SerializedName("dispositionSet")
    private Boolean _dispositionSet;

    public Node() { }
    
    public Node(UUID aNodeGuid, String aLabel, UUID aNodeParentGuid, Integer aRetentionPeriodInMonths, Integer aRetentionType, String aCode, Boolean aDispositionSet)
    {
        this._nodeGuid = aNodeGuid;
        this._label = aLabel;
        this._nodeParentGuid = aNodeParentGuid;
        this._retentionPeriodInMonths = aRetentionPeriodInMonths;
        this._retentionType = aRetentionType;
        this._code = aCode;
        this._dispositionSet = aDispositionSet;
    }
    
    public UUID getNodeGuid()
    {
        return _nodeGuid;
    }

    public void setNodeGuid(UUID aNodeGuid)
    {
        this._nodeGuid = aNodeGuid;
    }

    public String getLabel()
    {
        return _label;
    }

    public void setLabel(String aLabel)
    {
        this._label = aLabel;
    }

    public UUID getNodeParentGuid()
    {
        return _nodeParentGuid;
    }

    public void setNodeParentGuid(UUID aNodeParentGuid)
    {
        this._nodeParentGuid = aNodeParentGuid;
    }

    public Integer getRetentionPeriodInMonths()
    {
        return _retentionPeriodInMonths;
    }

    public void setRetentionPeriodInMonths(Integer aRetentionPeriodInMonths)
    {
        this._retentionPeriodInMonths = aRetentionPeriodInMonths;
    }

    public Integer getRetentionType()
    {
        return _retentionType;
    }

    public void setRetentionType(Integer aRetentionTypeEnum)
    {
        this._retentionType = aRetentionTypeEnum;
    }

    public String getCode()
    {
        return _code;
    }

    public void setCode(String aCode)
    {
        this._code = aCode;
    }

    public Boolean getDispositionSet()
    {
        return _dispositionSet;
    }

    public void setDispositionSet(Boolean aDispositionSet)
    {
        this._dispositionSet = aDispositionSet;
    }  
}
