package io.github.mtjakobczyk.javamagazine;

import java.io.IOException;

import com.oracle.bmc.ConfigFileReader;
import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;

import com.oracle.bmc.core.VirtualNetworkClient;
import com.oracle.bmc.core.model.CreateVcnDetails;
import com.oracle.bmc.core.requests.CreateVcnRequest;
import com.oracle.bmc.core.responses.CreateVcnResponse;

public class FirstStepsSDK {
    public static void main(String[] args) throws IOException {
        // Compartment inside which to create the VCN
        String compartmentId = args[0];
        
        // Parse the .oci/config and use the authentication information from the DEFAULT profile  
        var configFile = ConfigFileReader.parseDefault();
        var ociAuthProvider = new ConfigFileAuthenticationDetailsProvider(configFile);
        
        // Creating a client instance to interact with /20160918/vcns endpoint
        VirtualNetworkClient vnClient =  VirtualNetworkClient.builder().build(ociAuthProvider);
        
        // Creating CreateVcnDetails payload object
        CreateVcnDetails details = CreateVcnDetails.builder()
                .cidrBlock("192.168.1.0/24")
                .compartmentId(compartmentId)
                .displayName("sdk-demo-vcn")
                .dnsLabel("sdkdemo")
                .build();
        
        // Preparing the request object
        CreateVcnRequest request = CreateVcnRequest.builder().createVcnDetails(details).build();
        
        // Calling the CreateVcn REST API
        CreateVcnResponse response = vnClient.createVcn(request);
        
        // Print the OCID of the newly created VCN
        if(response.get__httpStatusCode__()==200) 
            System.out.println(response.getVcn().getId());
    }
}
