package com.cjo.jee.services;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cjo.jee.endpoints.api.Author;

@ApplicationScoped
public class AuthorsService {

	@PersistenceContext(unitName="bookPu")
	private EntityManager em;

	public Collection<Author> all() {
		return em.createQuery("FROM Author", Author.class).getResultList();
	}
}
