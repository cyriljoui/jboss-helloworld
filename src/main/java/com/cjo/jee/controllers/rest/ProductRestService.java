package com.cjo.jee.controllers.rest;

import com.cjo.jee.controllers.model.ProductDto;
import com.cjo.jee.entity.Product;
import com.cjo.jee.service.ICatalogService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by popom on 15/10/2016.
 */
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductRestService {

    @Inject
    private ICatalogService catalogService;

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") String id) {
        Product product = catalogService.loadProduct(id);
        if (product == null) {
            throw new NotFoundException("Product not found");
        }

        return Response.ok(new ProductDto(product)).build();
    }

    @POST
    public ProductDto create(@Valid ProductDto productDto) {
        Product product = new Product(productDto.getId(), productDto.getTitle(), productDto.getDescription());
        Product productDb = catalogService.createProduct(product);
        return new ProductDto(productDb);
    }

    @GET
    public List<ProductDto> listAll() {
        return catalogService.loadAllProducts()
                .stream()
                .map(product -> new ProductDto(product))
                .collect(Collectors.toList());
    }
}
