package com.cjo.jee.services;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.cjo.jee.endpoints.api.Book;
import com.cjo.jee.repositories.BookRepository;

@ApplicationScoped
@Transactional
public class BooksService {

    @Inject
    private BookRepository bookRepository;
	
	public Collection<Book> all() {
		return bookRepository.listBooks();
	}

	public Book forId(String id) {
	    return bookRepository.read(Long.valueOf(id));
	}
	
	public Long add(Book book) {
	    return bookRepository.create(book).getId();
	}

	public Book save(Book book) {
	    bookRepository.update(book);
		return book;
	}

    public void delete(String id) {
	    Book book = bookRepository.read(Long.valueOf(id));
	    bookRepository.delete(book);
    }
}
