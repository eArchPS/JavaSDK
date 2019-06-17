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

    public DocumentSubject() { }
    
    public DocumentSubject(UUID aDocumentSubjectGuid, String aClasification, String aDescription, String aTitle, Date aAddedDateTime)
    {
        this._documentSubjectGuid = aDocumentSubjectGuid;
        this._clasification = aClasification;
        this._description = aDescription;
        this._title = aTitle;
        this._addedDateTime = aAddedDateTime;
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
}
