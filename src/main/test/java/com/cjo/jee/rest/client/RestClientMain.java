package com.cjo.jee.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by popom on 13/10/2016.
 */
public class RestClientMain {
    public static void main(String[] args) throws Exception {

        String uriTemplate = "http://localhost:8080/jboss-helloworld/rest/catalog";
        Client client = ClientBuilder.newClient();
        Invocation.Builder invocBuilder = client.target(uriTemplate).request(MediaType.APPLICATION_JSON);
        List list = invocBuilder.get(List.class);
        System.out.println("List: " + list);
        client.close();

        // Deprecated RestEasy
//        ClientRequest request = new ClientRequest(
//                uriTemplate);
//        request.accept("application/json");
//        ClientResponse<List> response = request.get(List.class);
//        System.out.println(response.getEntity());
    }
}
