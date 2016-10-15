package com.cjo.jee.controllers.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by popom on 15/10/2016.
 */
@ApplicationPath("rest/api")
public class RestApplicationConfig extends Application {

    private final Set<Class<?>> classes;

    public RestApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(ItemRestService.class);
        c.add(NotFoundExceptionHandler.class);

        c.add(ProductRestService.class);
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

}
