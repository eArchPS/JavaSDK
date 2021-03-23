/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps.ea.sdk.java.sample;

import Model.*;
import PS.EA.SDK.Java.*;
import java.util.Arrays;
import java.util.UUID;

/**
 *
 * @author zemljics
 */
public class PSEASDKJavaSample
{
    public static void main(String[] args) throws Exception
    {                
        // ######### USAGE EXAMPLE #########
        
        // Create auth object and aquire token
        EAAuth auth = new EAAuth(AppSettings.getAuthAddress(), AppSettings.getCertFilePath(), AppSettings.getCertPassword());        
        String token = auth.GetBearerToken();        
        System.out.println(token);
        
        // Create client
        EAClient client = new EAClient(AppSettings.getApiAddress());
        
        // Get and print all nodes        
        Node[] nodes = client.GetAllNodes(token);
        
        for (Node node : nodes)
        {
            System.out.println(node.getNodeGuid() + "; " + node.getCode() + "; " + node.getLabel());
        }
        
        // Find ROOT node
        Node rootNode = null;
        
        for (Node node : nodes)
        {            
            if (node.getLabel().equals("ROOT"))
            {
                rootNode = node;
            }
        }
        
        if (rootNode == null)
        {
            throw new Exception("Cannot find ROOT node in supplied nodes.");
        }
        
        // Create a new Node object
        Node node = new Node(null, "Novo vozlisce", rootNode.getNodeGuid(), 12, 2, "Koda vozlisca", Boolean.TRUE, null, null);
        
        // Add node object and print returned guid
        UUID nodeGuid = client.AddNode(token, node);
        
        System.out.println("Inserted node GUID: " + nodeGuid);
        
        // Get node by guid
        node = client.GetNode(token, nodeGuid);
        
        // Make changes to node and update it
        node.setCode("Računi 2019");
        node.setDispositionSet(Boolean.FALSE);
        
        client.EditNode(token, node);
        
        // Delete node
        client.DeleteNode(token, nodeGuid);
    }    
}
