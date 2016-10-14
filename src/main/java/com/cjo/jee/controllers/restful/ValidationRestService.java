package com.cjo.jee.controllers.restful;

import com.cjo.jee.backend.Item;
import com.cjo.jee.backend.ItemService;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Catalog Rest service.
 */
@Path("/")
public class ValidationRestService {

    @Inject
    private ItemService itemService;

    @Path("/valid/query")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> validQuery(@NotNull @QueryParam("name") String name) {
        return Arrays.asList("Item1", "Item2", "Item3");
    }

    @Path("/valid/service")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Item validService(@QueryParam("stock") Integer stock) {
        Item item = new Item();
        item.setId(UUID.randomUUID().toString());
        item.setStock(stock);
        itemService.createItem(item);
        return item;
    }

}
