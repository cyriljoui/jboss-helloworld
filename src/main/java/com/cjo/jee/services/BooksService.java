package com.cjo.jee.services;

import com.cjo.jee.endpoints.api.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class BooksService {

	private Map<String, Book> fms;

	@PostConstruct
	public void init() {
		this.fms = new HashMap<>();
		{
			Book e = new Book();
			e.setTitle("Java JEE");
			fms.put(e.getId(), e);
		}
		{
			Book e = new Book();
			e.setTitle("AWS en pratique");
			fms.put(e.getId(), e);
		}
		{
			Book e = new Book();
			e.setTitle("Docker in Action");
			fms.put(e.getId(), e);
		}
	}
	
	public Collection<Book> all() {
		return fms.values();
	}

	public Book forId(String id) {
		return fms.get(id);
	}

	public String add(Book book) {
		fms.put(book.getId(), book);
		return book.getId();
	}

	public Book save(Book book) {
	    if (!fms.containsKey(book.getId())) {
	        throw new NotFoundException();
        }
		fms.put(book.getId(), book);
		return book;
	}

    public void delete(String id) {
	    if (!fms.containsKey(id)) {
	        throw new NotFoundException();
        }
	    fms.remove(id);
    }
}
