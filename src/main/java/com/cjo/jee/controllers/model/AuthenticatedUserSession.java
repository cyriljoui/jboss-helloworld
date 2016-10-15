package com.cjo.jee.controllers.model;

import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * Created by popom on 15/10/2016.
 */
@SessionScoped
public class AuthenticatedUserSession implements Serializable {

    private boolean authenticated;

    private String username;

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy user session ...");
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
