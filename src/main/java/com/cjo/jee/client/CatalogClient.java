package com.cjo.jee.client;

import com.cjo.jee.controllers.model.ProductDto;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by popom on 15/10/2016.
 */
public class CatalogClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String uriTemplate = "http://localhost:8080/jboss-helloworld/rest/api/product/547879b8-79b7-4f75-95ba-5a1a71d61797";
        Invocation.Builder invocBuilder = client.target(uriTemplate).request(MediaType.APPLICATION_JSON);

        ProductDto productDto = invocBuilder.get(ProductDto.class);
        System.out.println("title: " + productDto.getTitle());

//        list.stream().forEach(product -> {
//            System.out.println("Product: " + product);
//        });
    }
}
