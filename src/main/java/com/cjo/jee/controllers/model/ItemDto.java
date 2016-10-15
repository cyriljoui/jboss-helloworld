package com.cjo.jee.controllers.model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by popom on 15/10/2016.
 */
@XmlRootElement
public class ItemDto {

    private String id;

    private String title;

    private String description;

    public ItemDto() {
    }

    public ItemDto(String id, String title, String description) {
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
}
