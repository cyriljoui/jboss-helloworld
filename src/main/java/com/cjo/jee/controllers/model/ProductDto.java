package com.cjo.jee.controllers.model;

import com.cjo.jee.entity.Product;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by popom on 15/10/2016.
 */
public class ProductDto {

    private String id;

    private @NotNull String title;

    private @NotNull @Size(min = 10, max = 200) String description;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.description = product.getDescription();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
