package com.cjo.jee.service;

import com.cjo.jee.dao.IProductDao;
import com.cjo.jee.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by popom on 15/10/2016.
 */
@ApplicationScoped
public class CatalogService implements ICatalogService {

    @Inject
    private IProductDao productDao;

    @Override
    public Product createProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public Product loadProduct(String id) {
        return productDao.load(id);
    }

    @Override
    public List<Product> loadAllProducts() {
        return productDao.findAll();
    }
}
