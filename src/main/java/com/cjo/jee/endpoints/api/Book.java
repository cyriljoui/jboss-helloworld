package com.cjo.jee.endpoints.api;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Book {

	private String title;

	private String author;

	private String isbn = "ISBN "+ UUID.randomUUID().toString().substring(0, 10);

	private String id = UUID.randomUUID().toString();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }
}
