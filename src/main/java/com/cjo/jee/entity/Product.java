package com.cjo.jee.entity;

/**
 * Created by popom on 15/10/2016.
 */
public class Product {

    private String id;

    private String title;

    private String description;

    private float internalPrice;

    public Product() {
    }

    public Product(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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

    public float getInternalPrice() {
        return internalPrice;
    }

    public void setInternalPrice(float internalPrice) {
        this.internalPrice = internalPrice;
    }
}
