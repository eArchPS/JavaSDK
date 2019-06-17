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
public class DocumentType
{
    @SerializedName("documentTypeGuid")
    private UUID _documentTypeGuid;
    @SerializedName("label")
    private String _label;
    @SerializedName("description")
    private String _description;
    @SerializedName("documentTypeCustomMetadataTypes")
    private DocumentTypeCustomMetadataType[] _documentTypeCustomMetadataTypes;
    
    public DocumentType() { }
    
    public DocumentType(UUID aDocumentTypeGuid, String aLabel, String aDescription, DocumentTypeCustomMetadataType[] aDocumentTypeCustomMetadataTypes)
    {
        this._documentTypeGuid = aDocumentTypeGuid;
        this._label = aLabel;
        this._description = aDescription;
        this._documentTypeCustomMetadataTypes = aDocumentTypeCustomMetadataTypes;
    }
    
    public UUID getDocumentTypeGuid()
    {
        return _documentTypeGuid;
    }
    
    public void setDocumentTypeGuid(UUID _documentTypeGuid)
    {
        this._documentTypeGuid = _documentTypeGuid;
    }
    
    public String getLabel()
    {
        return _label;
    }
    
    public void setLabel(String _label)
    {
        this._label = _label;
    }
    
    public String getDescription()
    {
        return _description;
    }
    
    public void setDescription(String _description)
    {
        this._description = _description;
    }
    
    public DocumentTypeCustomMetadataType[] getDocumentTypeCustomMetadataTypes()
    {
        return _documentTypeCustomMetadataTypes;
    }
    
    public void setDocumentTypeCustomMetadataTypes(DocumentTypeCustomMetadataType[] _documentTypeCustomMetadataTypes)
    {
        this._documentTypeCustomMetadataTypes = _documentTypeCustomMetadataTypes;
    }
}
