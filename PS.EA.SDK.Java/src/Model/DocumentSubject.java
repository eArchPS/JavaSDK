/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author zemljics
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentSubject
{
    @SerializedName("documentSubjectGuid")
    private UUID _documentSubjectGuid;
    @SerializedName("clasification")
    private String _clasification;
    @SerializedName("description")
    private String _description;
    @SerializedName("title")
    private String _title;
    @SerializedName("addedDateTime")
    private Date _addedDateTime;
    @SerializedName("nodeGuid")
    private UUID _nodeGuid;
    @SerializedName("isLocked")
    private Boolean _isLocked;
    @SerializedName("lockedDateTime")
    private Date _lockedDateTime;

    public DocumentSubject() { }
    
    public DocumentSubject(UUID aDocumentSubjectGuid, String aClasification, String aDescription, String aTitle, Date aAddedDateTime, UUID aNodeGuid, Boolean aIsLocked, Date aLockedDateTime)
    {
        this._documentSubjectGuid = aDocumentSubjectGuid;
        this._clasification = aClasification;
        this._description = aDescription;
        this._title = aTitle;
        this._addedDateTime = aAddedDateTime;
        this._nodeGuid = aNodeGuid;
        this._isLocked = aIsLocked;
        this._lockedDateTime = aLockedDateTime;
    }    
    
    public UUID getDocumentSubjectGuid()
    {
        return _documentSubjectGuid;
    }

    public void setDocumentSubjectGuid(UUID _documentSubjectGuid)
    {
        this._documentSubjectGuid = _documentSubjectGuid;
    }

    public String getClasification()
    {
        return _clasification;
    }

    public void setClasification(String _clasification)
    {
        this._clasification = _clasification;
    }

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String _description)
    {
        this._description = _description;
    }

    public String getTitle()
    {
        return _title;
    }

    public void setTitle(String _title)
    {
        this._title = _title;
    }
    
    public Date getAddedDateTime()
    {
        return _addedDateTime;
    }
    
    public void setAddedDateTime(Date _addedDateTime)
    {
        this._addedDateTime = _addedDateTime;
    }
    
    public UUID getNodeGuid()
    {
        return _nodeGuid;
    }
    
    public void setNodeGuid(UUID _nodeGuid)
    {
        this._nodeGuid = _nodeGuid;
    }
    
    public Boolean getIsLocked()
    {
        return _isLocked;
    }
    
    public void setIsLocked(Boolean _isLocked)
    {
        this._isLocked = _isLocked;
    }
    
    public Date getLockedDateTime()
    {
        return _lockedDateTime;
    }
    
    public void setLockedDateTime(Date _lockedDateTime)
    {
        this._lockedDateTime = _lockedDateTime;
    }
}
