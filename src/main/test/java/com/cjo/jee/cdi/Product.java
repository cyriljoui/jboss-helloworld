package com.cjo.jee.cdi;

import java.io.Serializable;

/**
 * Created by popom on 12/10/2016.
 */
public class Product implements Serializable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
