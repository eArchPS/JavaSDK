/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enums.DigitalSignatureTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author zemljics
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata
{
    @SerializedName("documentGuid")
    private UUID _documentGuid;
    @SerializedName("author")
    private String _author;
    @SerializedName("addedDateTime")
    private Date _addedDateTime;
    @SerializedName("confidentiality")
    private Integer _confidentiality;
    @SerializedName("label")
    private String _label;
    @SerializedName("fileName")
    private String _fileName;
    @SerializedName("fileExtension")
    private String _fileExtension;
    @SerializedName("legacyGuid")
    private UUID _legacyGuid;
    @SerializedName("digitalSignature")
    private byte[] _digitalSignature;    
    @SerializedName("digitalSignatureType")
    private Integer _digitalSignatureType;
    @SerializedName("title")
    private String _title;
    @SerializedName("fileSHA1")
    private String _fileSHA1;
    @SerializedName("nodeGuid")
    private UUID _nodeGuid;
    @SerializedName("subjectGuid")
    private UUID _subjectGuid;
    @SerializedName("statusGuid")
    private UUID _statusGuid;
    @SerializedName("createdDate")
    private Date _createdDate;
    @SerializedName("receivedDate")
    private Date _receivedDate;
    @SerializedName("comment")
    private String _comment;
    @SerializedName("customMetadatas")
    private CustomMetadata[] _customMetadatas;
    @SerializedName("signingCertificate")
    private byte[] _signingCertificate;
    @SerializedName("documentTypeGuid")
    private UUID _documentTypeGuid;
    @SerializedName("containsPersonalData")
    private Boolean _containsPersonalData;    
    @SerializedName("code")
    private String _code;
    @SerializedName("receiver")
    private String _receiver;
    @SerializedName("sender")
    private String _sender;
    @SerializedName("shortDescription")
    private String _shortDescription;

    public Metadata() { }
    
    public Metadata(UUID aDocumentGuid, String aAuthor, Date aAddedDateTime, Integer aConfidentiality, String aLabel, String aFileName, String aFileExtension, UUID aLegacyGuid, byte[] aDigitalSignature, Integer aDigitalSignatureType, String aTitle, String aFileSHA1, UUID aNodeGuid, UUID aSubjectGuid, UUID aStatusGuid, Date aCreatedDate, Date aReceivedDate, String aComment, CustomMetadata[] aCustomMetadatas, byte[] aSigningCertificate, UUID aDocumentTypeGuid, Boolean aContainsPersonalData, String aCode, String aReceiver, String aSender, String aShortDescription)
    {
        this._documentGuid = aDocumentGuid;
        this._author = aAuthor;
        this._addedDateTime = aAddedDateTime;
        this._confidentiality = aConfidentiality;
        this._label = aLabel;
        this._fileName = aFileName;
        this._fileExtension = aFileExtension;
        this._legacyGuid = aLegacyGuid;
        this._digitalSignature = aDigitalSignature;
        this._digitalSignatureType = aDigitalSignatureType;
        this._title = aTitle;
        this._fileSHA1 = aFileSHA1;
        this._nodeGuid = aNodeGuid;
        this._subjectGuid = aSubjectGuid;
        this._statusGuid = aStatusGuid;
        this._createdDate = aCreatedDate;
        this._receivedDate = aReceivedDate;
        this._comment = aComment;
        this._customMetadatas = aCustomMetadatas;
        this._signingCertificate = aSigningCertificate;
        this._documentTypeGuid = aDocumentTypeGuid;
        this._containsPersonalData = aContainsPersonalData;
        this._code = aCode;
        this._receiver = aReceiver;
        this._sender = aSender;
        this._shortDescription = aShortDescription;
    }
    
    public UUID getDocumentGuid()
    {
        return _documentGuid;
    }
    
    public void setDocumentGuid(UUID _documentGuid)
    {
        this._documentGuid = _documentGuid;
    }
    
    public String getAuthor()
    {
        return _author;
    }

    public void setAuthor(String aAuthor)
    {
        this._author = aAuthor;
    }

    public Date getAddedDateTime()
    {
        return _addedDateTime;
    }

    public void setAddedDateTime(Date aAddedDateTime)
    {
        this._addedDateTime = aAddedDateTime;
    }

    public Integer getConfidentiality()
    {
        return _confidentiality;
    }

    public void setConfidentiality(Integer aConfidentiality)
    {
        this._confidentiality = aConfidentiality;
    }

    public String getLabel()
    {
        return _label;
    }

    public void setLabel(String aLabel)
    {
        this._label = aLabel;
    }

    public String getFileName()
    {
        return _fileName;
    }

    public void setFileName(String aFileName)
    {
        this._fileName = aFileName;
    }

    public String getFileExtension()
    {
        return _fileExtension;
    }

    public void setFileExtension(String aFileExtension)
    {
        this._fileExtension = aFileExtension;
    }

    public UUID getLegacyGuid()
    {
        return _legacyGuid;
    }

    public void setLegacyGuid(UUID aLegacyGuid)
    {
        this._legacyGuid = aLegacyGuid;
    }

    public byte[] getDigitalSignature()
    {
        return _digitalSignature;
    }

    public void setDigitalSignature(byte[] aDigitalSignature)
    {
        this._digitalSignature = aDigitalSignature;
    }

    public Integer getDigitalSignatureType()
    {
        return _digitalSignatureType;
    }
    
    public void setDigitalSignatureType(Integer aDigitalSignatureType)
    {
        this._digitalSignatureType = aDigitalSignatureType;
    }
    
    public String getTitle()
    {
        return _title;
    }
    
    public void setTitle(String aTitle)
    {
        this._title = aTitle;
    }
    
    public String getFileSHA1()
    {
        return _fileSHA1;
    }
    
    public void setFileSHA1(String aFileSHA1)
    {
        this._fileSHA1 = aFileSHA1;
    }

    public UUID getNodeGuid()
    {
        return _nodeGuid;
    }

    public void setNodeGuid(UUID aNodeGuid)
    {
        this._nodeGuid = aNodeGuid;
    }

    public UUID getSubjectGuid()
    {
        return _subjectGuid;
    }

    public void setSubjectGuid(UUID aSubjectGuid)
    {
        this._subjectGuid = aSubjectGuid;
    }

    public UUID getStatusGuid()
    {
        return _statusGuid;
    }

    public void setStatusGuid(UUID aStatusGuid)
    {
        this._statusGuid = aStatusGuid;
    }

    public Date getCreatedDate()
    {
        return _createdDate;
    }

    public void setCreatedDate(Date aCreatedDate)
    {
        this._createdDate = aCreatedDate;
    }

    public Date getReceivedDate()
    {
        return _receivedDate;
    }

    public void setReceivedDate(Date aReceivedDate)
    {
        this._receivedDate = aReceivedDate;
    }

    public String getComment()
    {
        return _comment;
    }

    public void setComment(String aComment)
    {
        this._comment = aComment;
    }

    public CustomMetadata[] getCustomMetadatas()
    {
        return _customMetadatas;
    }

    public void setCustomMetadatas(CustomMetadata[] aCustomMetadatas)
    {
        this._customMetadatas = aCustomMetadatas;
    }
    
    public byte[] getSigningCertificate()
    {
        return _signingCertificate;
    }
    
    public void setSigningCertificate(byte[] aSigningCertificate)
    {
        this._signingCertificate = aSigningCertificate;
    }
    
    public UUID getDocumentTypeGuid()
    {
        return _documentTypeGuid;
    }
    
    public void setDocumentTypeGuid(UUID aDocumentTypeGuid)
    {
        this._documentTypeGuid = aDocumentTypeGuid;
    }
    
    public Boolean getContainsPersonalData()
    {
        return _containsPersonalData;
    }
    
    public void setContainsPersonalData(Boolean aContainsPersonalData)
    {
        this._containsPersonalData = aContainsPersonalData;
    }
    
    public String getCode()
    {
        return _code;
    }
    
    public void setCode(String aCode)    
    {
        this._code = aCode;
    }
    
    public String getReceiver()
    {
        return _receiver;
    }
    
    public void setReceiver(String aReceiver)    
    {
        this._receiver = aReceiver;
    }
    
    public String getSender()
    {
        return _sender;
    }
    
    public void setSender(String aSender)    
    {
        this._sender = aSender;
    }
    
    public String getShortDescription()
    {
        return _shortDescription;
    }
    
    public void setShortDescription(String aShortDescription)    
    {
        this._shortDescription = aShortDescription;
    }
}
