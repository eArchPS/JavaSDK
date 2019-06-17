/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Model.Metadata;
import java.security.MessageDigest;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

/**
 *
 * @author zemljics
 */
public final class EAClientHelper
{    
    private EAClientHelper() {}
    
    public static HttpEntity GetMultipartEntity(byte[] aDocumentData, Metadata aDocumentMetadata) throws Exception
    {
        /*
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                
        Metadata metadata = new Metadata("saso jaz", null, 0, "laela", "20171025_200117_1", "gif", null, null, null, 1, 2, "2A860A2B94AC84F38AF8B4ECDB270CCA0C796964", UUID.fromString("4ED71431-7105-E711-9837-2C27D7F09B64"), null, null, false, new Date(), null, "komentar", null);

        String mdJson = _gson.toJson(metadata);

        builder.addBinaryBody("file", new File("C:/Users/zemljics/Desktop/20171025_200117_1.gif"), ContentType.APPLICATION_OCTET_STREAM, "20171025_200117_1.gif");
        builder.addTextBody("metadata", mdJson, ContentType.APPLICATION_JSON);


        HttpEntity multipartEntity = builder.build();
        */
        
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        
        // SHA1 into metadata
        
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        
        byte[] hash = sha1.digest(aDocumentData);
        
        String hashString = new HexBinaryAdapter().marshal(hash);
        
        aDocumentMetadata.setFileSHA1(hashString);
        
        String metadataJson = JsonHelper.ToJson(aDocumentMetadata);
        
        builder.addBinaryBody("file", aDocumentData, ContentType.APPLICATION_OCTET_STREAM, aDocumentMetadata.getFileName());
        builder.addTextBody("metadata", metadataJson, ContentType.APPLICATION_JSON);
        
        HttpEntity multipartEntity = builder.build();
        
        return multipartEntity;
    }
}
