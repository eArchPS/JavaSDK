/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import Helpers.EAClientHelper;
import Helpers.HttpConnectionHelper;
import Helpers.JsonHelper;
import Model.CustomMetadata;
import Model.CustomMetadataType;
import Model.DocumentRetention;
import Model.DocumentSubject;
import Model.DocumentType;
import Model.Metadata;
import Model.Node;
import Model.Status;
import PS.EA.SDK.Java.HttpMethod;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.UUID;
import org.apache.http.HttpEntity;

/**
 *
 * @author zemljics
 */
public class EAApi
{
    public EAApi(String aApiAddress) throws Exception
    {
        if (aApiAddress == null || aApiAddress.isEmpty())
        {
            throw new NullPointerException("Argument 'aApiAddress' is null or empty.");
        }
        
        HttpConnectionHelper.Initialize(aApiAddress);
    }

    // <editor-fold desc="Node">

    public Node[] GetAllNodes(String aToken) throws Exception
    {
        String response = HttpConnectionHelper.GetResponse(ApiActions.GetAllNodes, HttpMethod.Get, aToken, null);

        Node[] nodes = JsonHelper.FromJson(response, Node[].class);

        return nodes;
    }

    public Node GetNode(String aToken, UUID aNodeGuid) throws Exception
    {
        String url = String.format(ApiActions.GetNode, aNodeGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Get, aToken, null);

        Node node = JsonHelper.FromJson(response, Node.class);

        return node;
    }

    public UUID AddNode(String aToken, Node aNode) throws Exception
    {            
        String response = HttpConnectionHelper.GetResponse(ApiActions.AddNode, HttpMethod.Post, aToken, aNode);

        UUID nodeGuid = JsonHelper.FromJson(response, UUID.class);

        return nodeGuid;
    }

    public void EditNode(String aToken, Node aNode) throws Exception
    {
        //String url = String.format(ApiActions.EditNode, aNodeGuid);

        String response = HttpConnectionHelper.GetResponse(/*url*/ApiActions.EditNode, HttpMethod.Put, aToken, aNode);
    }

    public void DeleteNode(String aToken, UUID aNodeGuid) throws Exception
    {
        String url = String.format(ApiActions.DeleteNode, aNodeGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Delete, aToken, null);
    }

    // </editor-fold>

    // <editor-fold desc="Status">

    public Status[] GetAllStatuses(String aToken) throws Exception
    {
        String response = HttpConnectionHelper.GetResponse(ApiActions.GetAllStatuses, HttpMethod.Get, aToken, null);

        Status[] statuses = JsonHelper.FromJson(response, Status[].class);

        return statuses;
    }

    public Status GetStatus(String aToken, UUID aStatusGuid) throws Exception
    {
        String url = String.format(ApiActions.GetStatus, aStatusGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Get, aToken, null);

        Status status = JsonHelper.FromJson(response, Status.class);

        return status;
    }

    public UUID AddStatus(String aToken, Status aStatus) throws Exception
    {
        String response = HttpConnectionHelper.GetResponse(ApiActions.AddStatus, HttpMethod.Post, aToken, aStatus);

        UUID statusGuid = JsonHelper.FromJson(response, UUID.class);

        return statusGuid;
    }

    public void EditStatus(String aToken, Status aStatus) throws Exception
    {            
        String response = HttpConnectionHelper.GetResponse(ApiActions.EditStatus, HttpMethod.Put, aToken, aStatus);
    }

    public void DeleteStatus(String aToken, UUID aStatusGuid) throws Exception
    {
        String url = String.format(ApiActions.DeleteStatus, aStatusGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Delete, aToken, null);
    }

    // </editor-fold>

    // <editor-fold desc="DocumentSubject">

    public DocumentSubject GetDocumentSubject(String aToken, UUID aDocumentSubjectGuid) throws Exception
    {
        String url = String.format(ApiActions.GetDocumentSubject, aDocumentSubjectGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Get, aToken, null);

        DocumentSubject documentSubject = JsonHelper.FromJson(response, DocumentSubject.class);

        return documentSubject;
    }
    
    public DocumentSubject[] GetDocumentSubjects(String aToken, int aDocumentSubjectsSkip, int aDocumentSubjectsCount) throws Exception
    {
        String url = String.format(ApiActions.GetDocumentSubjects, aDocumentSubjectsSkip, aDocumentSubjectsCount);
        
        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Get, aToken, null);
        
        System.out.println("RESPONSE: " + response);
        
        DocumentSubject[] documentSubjects = JsonHelper.FromJson(response, DocumentSubject[].class);
        
        return documentSubjects;
    }

    public UUID AddDocumentSubject(String aToken, DocumentSubject aDocumentSubject) throws Exception
    {
        String response = HttpConnectionHelper.GetResponse(ApiActions.AddDocumentSubject, HttpMethod.Post, aToken, aDocumentSubject);

        UUID documentSubjectGuid = JsonHelper.FromJson(response, UUID.class);

        return documentSubjectGuid;
    }

    public void EditDocumentSubject(String aToken, DocumentSubject aDocumentSubject) throws Exception
    {
        String response = HttpConnectionHelper.GetResponse(ApiActions.EditDocumentSubject, HttpMethod.Put, aToken, aDocumentSubject);
    }
    
    public void DeleteDocumentSubject(String aToken, UUID aDocumentSubjectGuid) throws Exception
    {
        String url = String.format(ApiActions.DeleteDocumentSubject, aDocumentSubjectGuid);
        
        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Delete, aToken, null);
    }
    
    // </editor-fold>

    // <editor-fold desc="CustomMetadataType">

    public CustomMetadataType[] GetCustomMetadataTypes(String aToken) throws Exception
    {
        String response = HttpConnectionHelper.GetResponse(ApiActions.GetCustomMetadataTypes, HttpMethod.Get, aToken, null);
        
        CustomMetadataType[] customMetadataTypes = JsonHelper.FromJson(response, CustomMetadataType[].class);

        return customMetadataTypes;
    }

    public CustomMetadataType GetCustomMetadataType(String aToken, UUID aCustomMetadataTypeGuid) throws Exception
    {
        String url = String.format(ApiActions.GetCustomMetadataType, aCustomMetadataTypeGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Get, aToken, null);

        CustomMetadataType customMetadataType = JsonHelper.FromJson(response, CustomMetadataType.class);

        return customMetadataType;
    }

    // </editor-fold>

    // <editor-fold desc="DocumentType">
    
    public DocumentType[] GetDocumentTypes(String aToken) throws Exception
    {
        String response = HttpConnectionHelper.GetResponse(ApiActions.GetDocumentTypes, HttpMethod.Get, aToken, null);
        
        DocumentType[] documentTypes = JsonHelper.FromJson(response, DocumentType[].class);
        
        return documentTypes;
    }
    
    public DocumentType GetDocumentType(String aToken, UUID aDocumentTypeGuid) throws Exception
    {
        String url = String.format(ApiActions.GetDocumentType, aDocumentTypeGuid);
        
        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Get, aToken, null);
        
        DocumentType documentType = JsonHelper.FromJson(response, DocumentType.class);
        
        return documentType;
    }
    
    // </editor-fold >
    
    // <editor-fold desc="Document">

    public byte[] GetDocument(String aToken, UUID aDocumentGuid) throws Exception
    {
        String url = String.format(ApiActions.GetDocument, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Get, aToken, null);

        return response.getBytes(StandardCharsets.UTF_8);
    }
    
    public Metadata[] GetDocuments(String aToken, int aDocumentsSkip, int aDocumentsCount, UUID aNodeGuid) throws Exception
    {
        String url = String.format(ApiActions.GetDocuments, aDocumentsSkip, aDocumentsCount, aNodeGuid);
        
        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Get, aToken, null);
        
        Metadata[] metadata = JsonHelper.FromJson(response, Metadata[].class);
        
        return metadata;
    }

    public Metadata GetDocumentMetadata(String aToken, UUID aDocumentGuid) throws Exception
    {
        String url = String.format(ApiActions.GetDocumentMetadata, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Get, aToken, null);

        Metadata metadata = JsonHelper.FromJson(response, Metadata.class);

        return metadata;
    }

    public CustomMetadata[] GetDocumentCustomMetadata(String aToken, UUID aDocumentGuid) throws Exception
    {
        String url = String.format(ApiActions.GetDocumentCustomMetadata, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Get, aToken, null);

        CustomMetadata[] customMetadata = JsonHelper.FromJson(response, CustomMetadata[].class);

        return customMetadata;
    }

    public UUID[] GetDocumentsBySubjectGuid(String aToken, UUID aSubjectGuid) throws Exception
    {
        String url = String.format(ApiActions.GetDocumentsBySubjectGuid, aSubjectGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Get, aToken, null);

        UUID[] guids = JsonHelper.FromJson(response, UUID[].class);

        return guids;
    }

    public UUID[] GetDocumentsByLegacyGuid(String aToken, UUID aLegacyGuid) throws Exception
    {
        String url = String.format(ApiActions.GetDocumentsByLegacyGuid, aLegacyGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Get, aToken, null);

        UUID[] guids = JsonHelper.FromJson(response, UUID[].class);

        return guids;
    }

    public UUID AddDocument(String aToken, byte[] aData, Metadata aMetadata) throws Exception
    {
        HttpEntity multipartEntity = EAClientHelper.GetMultipartEntity(aData, aMetadata);

        String response = null;

        if (multipartEntity != null)
        {         
            response = HttpConnectionHelper.Upload(ApiActions.AddDocument, aToken, multipartEntity);            
            response = response.replace("\"", "");
        }
        else
        {
            throw new NullPointerException("Generated 'multipartEntity' is null.");
        }
        
        return UUID.fromString(response);
    }

    public void DeleteDocument(String aToken, UUID aDocumentGuid) throws Exception
    {
        String url = String.format(ApiActions.DeleteDocument, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Delete, aToken, null);
    }

    // </editor-fold>

    // <editor-fold desc="Metadata">

    public void MetadataEditAuthor(String aToken, UUID aDocumentGuid, String aAuthor) throws Exception
    {
        String url = String.format(ApiActions.EditAuthor, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Patch, aToken, aAuthor);
    }
    
    public void MetadataEditTitle(String aToken, UUID aDocumentGuid, String aTitle) throws Exception
    {
        String url = String.format(ApiActions.EditTitle, aDocumentGuid);
        
        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Patch, aToken, aTitle);
    }

    public void MetadataEditLabel(String aToken, UUID aDocumentGuid, String aLabel) throws Exception
    {
        String url = String.format(ApiActions.EditLabel, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Patch, aToken, aLabel);
    }

    public void MetadataEditCreatedDateTime(String aToken,UUID aDocumentGuid, Calendar aCreatedDateTime) throws Exception
    {
        String url = String.format(ApiActions.EditCreatedDate, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Patch, aToken, aCreatedDateTime.getTime());
    }

    public void MetadataEditReceivedDateTime(String aToken, UUID aDocumentGuid, Calendar aReceivedDate) throws Exception
    {
        String url = String.format(ApiActions.EditReceivedDate, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Patch, aToken, aReceivedDate.getTime());
    }

    public void MetadataEditConfidentiality(String aToken, UUID aDocumentGuid, Integer aConfidentiality) throws Exception
    {
        String url = String.format(ApiActions.EditConfidentiality, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Patch, aToken, aConfidentiality);
    }

    public void MetadataEditNodeGuid(String aToken, UUID aDocumentGuid, UUID aNodeGuid) throws Exception
    {
        String url = String.format(ApiActions.EditNodeGuid, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Patch, aToken, aNodeGuid);
    }

    public void MetadataEditStatusGuid(String aToken, UUID aDocumentGuid, UUID aStatusGuid) throws Exception
    {
        String url = String.format(ApiActions.EditStatusGuid, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Patch, aToken, aStatusGuid);
    }

    public void MetadataEditSubjectGuid(String aToken, UUID aDocumentGuid, UUID aSubjectGuid) throws Exception
    {
        String url = String.format(ApiActions.EditDocumentSubjectGuid, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Patch, aToken, aSubjectGuid);
    }

    public void MetadataEditLegacyGuid(String aToken, UUID aDocumentGuid, UUID aLegacyGuid) throws Exception
    {
        String url = String.format(ApiActions.EditDocumentLegacyGuid, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Patch, aToken, aLegacyGuid);
    }

    // </editor-fold>

    // <editor-fold desc="CustomMetadata">

    public void EditCustomMetadata(String aToken, UUID aDocumentGuid, CustomMetadata aCustomMetadata) throws Exception
    {
        String url = String.format(ApiActions.EditCustomMetadata, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Patch, aToken, aCustomMetadata);
    }

    // </editor-fold>

    // <editor-fold desc="DocumentRetention">

    public DocumentRetention GetDocumentRetention(String aToken, UUID aDocumentGuid) throws Exception
    {
        String url = String.format(ApiActions.GetDocumentRetention, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Get, aToken, null);

        DocumentRetention documentRetention = JsonHelper.FromJson(response, DocumentRetention.class);

        return documentRetention;
    }

    public UUID AddDocumentRetention(String aToken, DocumentRetention aDocumentRetention) throws Exception
    {
        String response = HttpConnectionHelper.GetResponse(ApiActions.AddDocumentRetention, HttpMethod.Post, aToken, aDocumentRetention);

        UUID documentRetentionGuid = JsonHelper.FromJson(response, UUID.class);

        return documentRetentionGuid;
    }

    public void EditDocumentRetention(String aToken, DocumentRetention aDocumentRetention) throws Exception
    {
        String response = HttpConnectionHelper.GetResponse(ApiActions.EditDocumentRetention, HttpMethod.Put, aToken, aDocumentRetention);
    }

    public void DeleteDocumentRetention(String aToken, UUID aDocumentGuid) throws Exception
    {
        String url = String.format(ApiActions.DeleteDocumentRetention, aDocumentGuid);

        String response = HttpConnectionHelper.GetResponse(url, HttpMethod.Delete, aToken, null);
    }

    // </editor-fold>
}
