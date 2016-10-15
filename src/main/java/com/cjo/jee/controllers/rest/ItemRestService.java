package com.cjo.jee.controllers.rest;

import com.cjo.jee.controllers.model.ItemDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by popom on 15/10/2016.
 */
@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
public class ItemRestService {

    List<ItemDto> items = Arrays.asList(
            new ItemDto("1", "Item 1", "Description 1"),
            new ItemDto("2", "Item 2", "Description 2"),
            new ItemDto("3", "Item 3", "Description 3"));

    @GET
    public List<ItemDto> getItems() {
        return items;
    }

    @Path("/xml")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<ItemDto> getItemsXml() {
        return items;
    }

    @GET
    @Path("/{id}")
    public ItemDto getItem(@PathParam("id") String id) {
        Optional<ItemDto> first = items.stream().filter(itemDto -> itemDto.getId().equals(id)).findFirst();


        return first.get();
    }

    @POST
    public Response createItem(ItemDto itemDto) {
        System.out.println("TODO create item ..." + itemDto.getTitle());
        // Call service ...
        return Response.ok(itemDto).build();
    }
}
