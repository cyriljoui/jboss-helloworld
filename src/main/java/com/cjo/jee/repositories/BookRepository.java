package com.cjo.jee.repositories;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import com.cjo.jee.endpoints.api.Author;
import com.cjo.jee.endpoints.api.Book;

/**
 * Created by michir on 12/06/2017.
 */
@Stateless
public class BookRepository {

	@PersistenceContext(unitName="bookPu")
	private EntityManager em;
	
    @PostConstruct
    public void init() {
    	Author author = new Author();
    	{
    		author.setName("Albert Einstein");
    		em.persist(author);
    	}
        {
            Book e = new Book();
            e.setTitle("Java JEE");
            e.setAuthor(author);
            em.persist(e);
        }
        {
            Book e = new Book();
            e.setTitle("AWS en pratique");
            e.setAuthor(author);
            em.persist(e);
        }
        {
            Book e = new Book();
            e.setTitle("Docker in Action");
            e.setAuthor(author);
            em.persist(e);
        }
    }

    public List<Book> listBooks() {
        return em.createQuery("FROM Book", Book.class).getResultList();
    }

    public Book create(Book book) {
    	em.persist(book);
    	return book;
    }

    public Book read(Long id) {
        return em.find(Book.class, id);
    }

    /**
     * @param book
     * @throws EntityNotFoundException
     */
    public void update(Book book) {
    	if (read(book.getId()) == null) {
    		throw new EntityNotFoundException();
    	}
    	em.merge(book);
    }

    public void delete(Book book) {
        em.remove(book);
    }

}
