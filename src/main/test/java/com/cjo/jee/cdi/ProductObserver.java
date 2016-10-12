package com.cjo.jee.cdi;

import javax.enterprise.event.Observes;

/**
 * Created by popom on 12/10/2016.
 */
public class ProductObserver {

    public void addProduct(@Observes Product product) {
        System.out.println("Add a product: " + product);
    }

}
