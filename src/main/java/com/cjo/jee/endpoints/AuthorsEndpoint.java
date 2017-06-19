package com.cjo.jee.endpoints;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cjo.jee.endpoints.api.Author;
import com.cjo.jee.endpoints.api.Book;
import com.cjo.jee.services.AuthorsService;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorsEndpoint {

	@Inject
    AuthorsService service;

	@GET
	@Path("{name}/books")
	public Collection<Book> books(@PathParam("name") String author) {
		return null; //service.search(author);
	}
	
	@GET
	public Collection<Author> authors() {
		return service.all();
	}
}
