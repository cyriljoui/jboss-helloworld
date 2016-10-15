package com.cjo.jee.controllers.rest;

import com.cjo.jee.controllers.model.*;
import com.cjo.jee.controllers.model.Error;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by popom on 15/10/2016.
 */
@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable exception) {
        exception.printStackTrace();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(new Error(exception.getClass().getCanonicalName(), exception.getMessage()))
                .build();
    }
}
