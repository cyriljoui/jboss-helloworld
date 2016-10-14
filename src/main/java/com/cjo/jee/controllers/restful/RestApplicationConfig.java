package com.cjo.jee.controllers.restful;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * JAX-RS Application configuration.
 */
@ApplicationPath("rest")
public class RestApplicationConfig extends Application {

    private final Set<Class<?>> classes;

    public RestApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(CatalogRestService.class);
        c.add(ValidationRestService.class);
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

}
