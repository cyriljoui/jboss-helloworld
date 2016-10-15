package com.cjo.jee.dao;

import com.cjo.jee.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

/**
 * Created by popom on 15/10/2016.
 */
@ApplicationScoped
public class ProductDao implements IProductDao {

    private Map<String, Product> products = new HashMap<>();

    @Override
    public Product save(Product product) {
        String id = UUID.randomUUID().toString();
        product.setId(id);
        products.put(id, product);
        return product;
    }

    @Override
    public Product load(String id) {
        return products.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }
}
