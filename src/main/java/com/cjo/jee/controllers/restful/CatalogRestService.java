package com.cjo.jee.controllers.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

/**
 * Catalog Rest service.
 */
@Path("/catalog")
public class CatalogRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getItems() {
        return Arrays.asList("Item1", "Item2", "Item3");
    }

}
