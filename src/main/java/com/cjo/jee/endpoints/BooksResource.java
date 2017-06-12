package com.cjo.jee.endpoints;

import com.cjo.jee.endpoints.api.Book;
import com.cjo.jee.services.BooksService;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BooksResource {

	@Inject
	private Logger logger;
	
	@Inject
    BooksService service;

	@GET
	public Collection<Book> books() {
		return service.all();
	}
	
	@GET
	@Path("{id}")
	public Response book(@PathParam("id") String id) {

		try {
			return Response.ok(service.forId(id)).build();
		} catch (NoSuchElementException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response save(@PathParam("id") String id) {
	    service.delete(id);
        return Response.ok().build();
    }

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Book book) {
		return Response.ok(service.save(book)).build();
	}
	
}
