package com.cjo.jee.service;

import com.cjo.jee.entity.Product;

import java.util.List;

/**
 * Created by popom on 15/10/2016.
 */
public interface ICatalogService {

    Product createProduct(Product product);

    Product loadProduct(String id);

    List<Product> loadAllProducts();

}
