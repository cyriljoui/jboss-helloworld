package com.cjo.jee.dao;

import com.cjo.jee.entity.Product;

import java.util.List;

/**
 * Created by popom on 15/10/2016.
 */
public interface IProductDao {

    Product save(Product product);

    Product load(String id);

    List<Product> findAll();

}
