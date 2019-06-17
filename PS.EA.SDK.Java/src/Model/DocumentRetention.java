/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author zemljics
 */
public class DocumentRetention
{
    @SerializedName("documentGuid")
    private UUID _documentGuid;
    @SerializedName("retentionDate")
    private Date _retentionDate;
    @SerializedName("dispositionSet")
    private Boolean _dispositionSet;
    
    public DocumentRetention() { }
    
    public DocumentRetention(UUID aDocumentGuid, Date aRetentionDate, Boolean aDispositionSet)
    {
        this._documentGuid = aDocumentGuid;
        this._retentionDate = aRetentionDate;
        this._dispositionSet = aDispositionSet;
    }
    
    public UUID getDocumentGuid()
    {
        return _documentGuid;
    }
    
    public void setDocumentGuid(UUID aDocumentGuid)
    {
        _documentGuid = aDocumentGuid;
    }
    
    public Date getRetentionDate()
    {
        return _retentionDate;
    }
    
    public void setRetentionDate(Date aRetentionDate)
    {
        _retentionDate = aRetentionDate;
    }
    
    public Boolean getDispositionSet()
    {
        return _dispositionSet;
    }
    
    public void setDispositionSet(Boolean aDispositionSet)
    {
        _dispositionSet = aDispositionSet;
    }
}
