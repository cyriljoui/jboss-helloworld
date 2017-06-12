package com.cjo.jee.endpoints;

import com.cjo.jee.services.AuthenticationService;
import com.cjo.jee.services.IRepository;

import javax.inject.Inject;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.logging.Logger;

/**
 * Created by michir on 11/06/2017.
 */
@Path("/authenticate")
public class AuthenticationEndpoint {

    @Inject
    Logger logger;

    @Inject
    AuthenticationService service;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticate(@FormParam("username") String username, @FormParam("password") String password) {
        logger.info("Authenticating "+username);
        try {
            service.authenticate(username, password);
            return Response.ok(Collections.singletonMap("login", username)).build();
        } catch (AuthenticationException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
