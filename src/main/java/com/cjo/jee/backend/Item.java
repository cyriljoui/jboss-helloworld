package com.cjo.jee.backend;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by popom on 13/10/2016.
 */
public class Item {

    private @NotNull String id;

    private @Min(1) Integer stock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
