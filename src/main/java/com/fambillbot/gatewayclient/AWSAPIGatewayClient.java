
package com.fambillbot.gatewayclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

/**
 *
 * 
 * run the application with -Dendpoint="path to the resource" -Dapikey="api-key-value" AWSAPIGatewayClient
 * @author vidhya ( it.vidhyadharan@gmail.com)
 */
public class AWSAPIGatewayClient {
    
   public static void main(String[] args) {
       
        final Client client = Client.create();
        String baseurl = System.getProperty("endpoint","https://6tegmyq1f0.execute-api.us-east-1.amazonaws.com/test/");
        WebResource webResource = client.resource(baseurl);
        final String otp_body = "{\"otp\":\"12134\"}";
        //File to Multipart form data
        ClientResponse response = webResource
                .header("x-api-key", System.getProperty("apikey","sample-key"))
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, otp_body);
        System.out.println("Response code "+response.getStatus());
    }
}
