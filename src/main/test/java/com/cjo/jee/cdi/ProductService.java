package com.cjo.jee.cdi;

import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * Created by popom on 12/10/2016.
 */
public class ProductService {

    @Inject
    private Event<Product> productEvent;

    public Product createProduct(String id) {
        Product product = new Product();
        product.setId(id);
        productEvent.fire(product);

        return product;
    }

}
