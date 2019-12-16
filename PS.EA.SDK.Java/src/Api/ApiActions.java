/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

/**
 *
 * @author zemljics
 */
public class ApiActions
{
    public static String GetAllNodes = "/Node";
    public static String GetNode = "/Node/%s";
    public static String AddNode = "/Node";
    public static String EditNode = "/Node";
    public static String DeleteNode = "/Node/%s";
        
    public static String GetAllStatuses = "/Status";
    public static String GetStatus = "/Status/%s";
    public static String AddStatus = "/Status";
    public static String EditStatus = "/Status";
    public static String DeleteStatus = "/Status/%s";
        
    public static String GetDocumentSubject = "/DocumentSubject/%s";
    public static String AddDocumentSubject = "/DocumentSubject";
    public static String EditDocumentSubject = "/DocumentSubject";
    public static String GetDocumentSubjects = "/DocumentSubject/%s/%s";
    public static String DeleteDocumentSubject = "/DocumentSubject/%s";
        
    public static String GetCustomMetadataTypes = "/CustomMetadataType";
    public static String GetCustomMetadataType = "/CustomMetadataType/%s";
    
    public static String GetDocumentTypes = "/DocumentType";
    public static String GetDocumentType = "/DocumentType/%s";
        
    public static String GetDocument = "/Document/%s";
    public static String GetDocuments = "/Document/%s/%s/%s";
    public static String GetDocumentMetadata = "/Document/%s/Metadata";
    public static String GetDocumentCustomMetadata = "/Document/%s/CustomMetadata";
    public static String GetDocumentsBySubjectGuid = "/Document/BySubjectGuid/%s";
    public static String GetDocumentsByLegacyGuid = "/Document/ByLegacyGuid/%s";
    public static String AddDocument = "/Document";
    public static String DeleteDocument = "/Document/%s";
    
    public static String EditAuthor = "/Document/%s/Metadata/Author";
    public static String EditLabel = "/Document/%s/Metadata/Label";
    public static String EditTitle = "/Document/%s/Metadata/Title";
    public static String EditCreatedDate = "/Document/%s/Metadata/CreatedDate";
    public static String EditReceivedDate = "/Document/%s/Metadata/ReceivedDate";
    public static String EditConfidentiality = "/Document/%s/Metadata/Confidentiality";
    public static String EditNodeGuid = "/Document/%s/Metadata/NodeGuid";
    public static String EditStatusGuid = "/Document/%s/Metadata/StatusGuid";
    public static String EditDocumentSubjectGuid = "/Document/%s/Metadata/DocumentSubjectGuid";
    public static String EditDocumentLegacyGuid = "/Document/%s/Metadata/DocumentLegacyGuid";
    public static String EditContainsPersonalData = "/Document/%s/Metadata/ContainsPersonalData";
    public static String EditCode = "/Document/%s/Metadata/Code";
    public static String EditReceiver = "/Document/%s/Metadata/Receiver";
    public static String EditSender = "/Document/%s/Metadata/Sender";
    public static String EditShortDescription = "/Document/%s/Metadata/ShortDescription";
    public static String EditComment = "/Document/%s/Metadata/Comment";
        
    public static String EditCustomMetadata = "/Document/%s/CustomMetadata/";
        
    public static String GetDocumentRetention = "/DocumentRetention/%s";
    public static String AddDocumentRetention = "/DocumentRetention";
    public static String EditDocumentRetention = "/DocumentRetention";
    public static String DeleteDocumentRetention = "/DocumentRetention/%s";
}
