/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zemljics
 */

package PS.EA.SDK.Java;

import Api.EAApi;
import Model.*;
import java.util.Calendar;
import java.util.UUID;

public class EAClient
{
    private EAApi _api;
    
    public EAClient(String aApiAddress) throws Exception
    {        
        if (aApiAddress == null || aApiAddress.isEmpty())
        {
            throw new NullPointerException("Argument 'aApiAddress' is null or empty.");
        }
        
        _api = new EAApi(aApiAddress);
    }
    
    // <editor-fold desc="Node">
    
    public Node[] GetAllNodes(String aToken) throws Exception
    {
        return _api.GetAllNodes(aToken);
    }
    
    public Node GetNode(String aToken, UUID aNodeGuid) throws Exception
    {
        if (aNodeGuid == null)
        {
            throw new NullPointerException("Argument 'aNodeGuid' is null.");
        }
        
        return _api.GetNode(aToken, aNodeGuid);
    }
    
    public UUID AddNode(String aToken, Node aNode) throws Exception
    {
        if (aNode == null)
        {
            throw new NullPointerException("Argument 'aNode' is null.");
        }
        
        return _api.AddNode(aToken, aNode);
    }
    
    public void EditNode(String aToken, Node aNode) throws Exception
    {
        if (aNode == null)
        {
            throw new NullPointerException("Argument 'aNode' is null.");
        }
        if (aNode.getNodeGuid() == null)
        {
            throw new NullPointerException("Property 'NodeGuid' in 'aNode' object is null.");
        }
        
        _api.EditNode(aToken, aNode);
    }
    
    public void DeleteNode(String aToken, UUID aNodeGuid) throws Exception
    {
        if (aNodeGuid == null)
        {
            throw new NullPointerException("Argument 'aNodeGuid' is null.");
        }
        
        _api.DeleteNode(aToken, aNodeGuid);
    }
    
    // </editor-fold>
    
    // <editor-fold desc="Status">
    
    public Status[] GetAllStatuses(String aToken) throws Exception
    {
        return _api.GetAllStatuses(aToken);
    }

    public Status GetStatus(String aToken, UUID aStatusGuid) throws Exception
    {
        if (aStatusGuid == null)
        {
            throw new NullPointerException("Argument 'aStatusGuid' is null.");
        }
        
        return _api.GetStatus(aToken, aStatusGuid);
    }

    public UUID AddStatus(String aToken, Status aStatus) throws Exception
    {
        if (aStatus == null)
        {
            throw new NullPointerException("Argument 'aStatus' is null.");
        }
        
        return _api.AddStatus(aToken, aStatus);
    }

    public void EditStatus(String aToken, Status aStatus) throws Exception
    {
        if (aStatus == null)
        {
            throw new NullPointerException("Argument 'aStatus' is null.");
        }
        if (aStatus.getStatusGuid() == null)
        {
            throw new NullPointerException("Property 'StatusGuid' in 'aStatus' object is null.");
        }
        
        _api.EditStatus(aToken, aStatus);
    }

    public void DeleteStatus(String aToken, UUID aStatusGuid) throws Exception
    {
        if (aStatusGuid == null)
        {
            throw new NullPointerException("Argument 'aStatusGuid' is null.");
        }
        
        _api.DeleteStatus(aToken, aStatusGuid);
    }
    
    // </editor-fold>
    
    // <editor-fold desc="DocumentSubject">
    
    public DocumentSubject GetDocumentSubject(String aToken, UUID aDocumentSubjectGuid) throws Exception
    {
        if (aDocumentSubjectGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentSubjectGuid' is null.");
        }
        
        return _api.GetDocumentSubject(aToken, aDocumentSubjectGuid);
    }
    
    public DocumentSubject[] GetDocumentSubjects(String aToken, int aDocumentSubjectsSkip, int aDocumentSubjectsCount) throws Exception
    {
        return _api.GetDocumentSubjects(aToken, aDocumentSubjectsSkip, aDocumentSubjectsCount);
    }
    
    public UUID AddDocumentSubject(String aToken, DocumentSubject aDocumentSubject) throws Exception
    {
        if (aDocumentSubject == null)
        {
            throw new Exception("Argument 'aDocumentSubject' is null.");
        }
        
        return _api.AddDocumentSubject(aToken, aDocumentSubject);
    }
    
    public void EditDocumentSubject(String aToken, DocumentSubject aDocumentSubject) throws Exception
    {
        if (aDocumentSubject == null)
        {
            throw new NullPointerException("Argument 'aDocumentSubject' is null.");
        }
        if (aDocumentSubject.getDocumentSubjectGuid() == null)
        {
            throw new NullPointerException("Property 'DocumentSubjectGuid' in 'aDocumentSubject' object is null.");
        }
        
        _api.EditDocumentSubject(aToken, aDocumentSubject);
    }
    
    public void DeleteDocumentSubject(String aToken, UUID aDocumentSubjectGuid) throws Exception
    {
        if (aDocumentSubjectGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentSubjectGuid' is null.");
        }
        
        _api.DeleteDocumentSubject(aToken, aDocumentSubjectGuid);
    }
    
    // </editor-fold>
    
    // <editor-fold desc="CustomMetadataType">
    
    public CustomMetadataType[] GetCustomMetadataTypes(String aToken) throws Exception
    {
        return _api.GetCustomMetadataTypes(aToken);
    }
    
    public CustomMetadataType GetCustomMetadataType(String aToken, UUID aCustomMetadataTypeGuid) throws Exception
    {
        if (aCustomMetadataTypeGuid == null)
        {
            throw new NullPointerException("Argument 'aCustomMetadataTypeGuid' is null.");
        }
        
        return _api.GetCustomMetadataType(aToken, aCustomMetadataTypeGuid);
    }
    
    // </editor-fold>
    
    // <editor-fold desc="DocumentType">
    
    public DocumentType[] GetDocumentTypes(String aToken) throws Exception
    {
        return _api.GetDocumentTypes(aToken);
    }
    
    public DocumentType GetDocumentType(String aToken, UUID aDocumentTypeGuid) throws Exception
    {
        if (aDocumentTypeGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentTypeGuid' is null.");
        }
        
        return _api.GetDocumentType(aToken, aDocumentTypeGuid);
    }
    
    // </editor-fold>
    
    // <editor-fold desc="Document">
    
    public byte[] GetDocument(String aToken, UUID aDocumentGuid) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        
        return _api.GetDocument(aToken, aDocumentGuid);
    }
    
    public Metadata[] GetDocuments(String aToken, int aDocumentsSkip, int aDocumentsCount, UUID aNodeGuid) throws Exception
    {
        return _api.GetDocuments(aToken, aDocumentsSkip, aDocumentsCount, aNodeGuid);
    }
    
    public Metadata GetDocumentMetadata(String aToken, UUID aDocumentGuid) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null");
        }
        
        return _api.GetDocumentMetadata(aToken, aDocumentGuid);
    }
    
    public CustomMetadata[] GetDocumentCustomMetadata(String aToken, UUID aDocumentGuid) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        
        return _api.GetDocumentCustomMetadata(aToken, aDocumentGuid);
    }
    
    public UUID[] GetDocumentsBySubjectGuid(String aToken, UUID aSubjectGuid) throws Exception
    {
        if (aSubjectGuid == null)
        {
            throw new NullPointerException("Argument 'aSubjectGuid' is null.");
        }
        
        return _api.GetDocumentsBySubjectGuid(aToken, aSubjectGuid);
    }
    
    public UUID[] GetDocumentsByLegacyGuid(String aToken, UUID aLegacyGuid) throws Exception
    {
        if (aLegacyGuid == null)
        {
            throw new NullPointerException("Argument 'aLegacyGuid' is null.");
        }
        
        return _api.GetDocumentsByLegacyGuid(aToken, aLegacyGuid);
    }
    
    public UUID AddDocument(String aToken, byte[] aData, Metadata aMetadata) throws Exception
    {
        if (aData == null)
        {
            throw new NullPointerException("Argument 'aData' is null.");
        }
        if (aMetadata == null)
        {
            throw new NullPointerException("Argument 'aMetadata' is null.");
        }
        
        return _api.AddDocument(aToken, aData, aMetadata);
    }
    
    public void DeleteDocument(String aToken, UUID aDocumentGuid) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        
        _api.DeleteDocument(aToken, aDocumentGuid);
    }
    
    // </editor-fold>
    
    // <editor-fold desc="Metadata">

    public void MetadataEditAuthor(String aToken, UUID aDocumentGuid, String aAuthor) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        
        _api.MetadataEditAuthor(aToken, aDocumentGuid, aAuthor);
    }

    public void MetadataEditLabel(String aToken, UUID aDocumentGuid, String aLabel) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        
        _api.MetadataEditLabel(aToken, aDocumentGuid, aLabel);
    }
    
    public void MetadataEditTitle(String aToken, UUID aDocumentGuid, String aTitle) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        if (aTitle == null || aTitle.isEmpty())
        {
            throw new NullPointerException("Argument 'aTitle' is null or empty.");
        }
        
        _api.MetadataEditTitle(aToken, aDocumentGuid, aTitle);
    }

    public void MetadataEditCreatedDateTime(String aToken, UUID aDocumentGuid, Calendar aCreatedDateTime) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        
        _api.MetadataEditCreatedDateTime(aToken, aDocumentGuid, aCreatedDateTime);
    }

    public void MetadataEditReceivedDateTime(String aToken, UUID aDocumentGuid, Calendar aReceivedDate) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        
        _api.MetadataEditReceivedDateTime(aToken, aDocumentGuid, aReceivedDate);
    }

    public void MetadataEditConfidentiality(String aToken, UUID aDocumentGuid, Integer aConfidentiality) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        
        _api.MetadataEditConfidentiality(aToken, aDocumentGuid, aConfidentiality);
    }

    public void MetadataEditNodeGuid(String aToken, UUID aDocumentGuid, UUID aNodeGuid) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        if (aNodeGuid == null)
        {
            throw new NullPointerException("Argument 'aNodeGuid' is null.");
        }
        
        _api.MetadataEditNodeGuid(aToken, aDocumentGuid, aNodeGuid);
    }

    public void MetadataEditStatusGuid(String aToken, UUID aDocumentGuid, UUID aStatusGuid) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        
        _api.MetadataEditStatusGuid(aToken, aDocumentGuid, aStatusGuid);
    }

    public void MetadataEditSubjectGuid(String aToken, UUID aDocumentGuid, UUID aSubjectGuid) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        
        _api.MetadataEditSubjectGuid(aToken, aDocumentGuid, aSubjectGuid);
    }

    public void MetadataEditLegacyGuid(String aToken, UUID aDocumentGuid, UUID aLegacyGuid) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        
        _api.MetadataEditLegacyGuid(aToken, aDocumentGuid, aLegacyGuid);
    }
    
    // </editor-fold>
    
    // <editor-fold desc="CustomMetadata">
    
    public void EditCustomMetadata(String aToken, UUID aDocumentGuid, CustomMetadata aCustomMetadata) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        if (aCustomMetadata == null)
        {
            throw new NullPointerException("Argument 'aCustomMetadata' is null.");
        }
        
        _api.EditCustomMetadata(aToken, aDocumentGuid, aCustomMetadata);
    }
    
    // </editor-fold>
    
    // <editor-fold desc="DocumentRetention">
    
    public DocumentRetention GetDocumentRetention(String aToken, UUID aDocumentGuid) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        
        return _api.GetDocumentRetention(aToken, aDocumentGuid);
    }

    public UUID AddDocumentRetention(String aToken, DocumentRetention aDocumentRetention) throws Exception
    {
        if (aDocumentRetention == null)
        {
            throw new NullPointerException("Argument 'aDocumentRetention' is null.");
        }
        
        return _api.AddDocumentRetention(aToken, aDocumentRetention);
    }

    public void EditDocumentRetention(String aToken, DocumentRetention aDocumentRetention) throws Exception
    {
        if (aDocumentRetention == null)
        {
            throw new NullPointerException("Argument 'aDocumentRetention' is null.");
        }
        if (aDocumentRetention.getDocumentGuid() == null)
        {
            throw new NullPointerException("Property 'DocumentGuid' in 'aDocumentRetention' object is null.");
        }
        
        _api.EditDocumentRetention(aToken, aDocumentRetention);
    }

    public void DeleteDocumentRetention(String aToken, UUID aDocumentGuid) throws Exception
    {
        if (aDocumentGuid == null)
        {
            throw new NullPointerException("Argument 'aDocumentGuid' is null.");
        }
        
        _api.DeleteDocumentRetention(aToken, aDocumentGuid);
    }
    
    // </editor-fold>
}
