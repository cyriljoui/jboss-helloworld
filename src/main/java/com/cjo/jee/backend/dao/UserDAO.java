package com.cjo.jee.backend.dao;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cjo.jee.backend.data.Item;
import com.cjo.jee.backend.data.User;

@Stateless
public class UserDAO {

	@PersistenceContext(unitName="helloPU")
	private EntityManager em;

	@Inject
	private Logger logger;
	
	public User findByUsernameAndPassword(String username, String password) {
		return em.createQuery("FROM User where username = :username and password = :pwd", User.class)
				.setParameter("username", username)
				.setParameter("pwd", password)
				.getSingleResult();
	}

	public User findByUsername(String username) {
		return em.createQuery("FROM User where username = :username", User.class)
				.setParameter("username", username)
				.getSingleResult();
	}

	public void addItem(User user, Item item) {
		User u = this.findByUsername(user.getUsername());
		logger.info("Add item "+item.getDescription()+" for user "+user.getUsername());
		u.getItems().forEach(e -> logger.info(""+e.getId()+", "+e.getDescription()));
		em.persist(item);
		u.getItems().add(item);
	}
	
	public void addItem2(User user, Item item) {
		if (!em.contains(user)) {
			user = em.merge(user);
		}
		logger.info("Add item "+item.getDescription()+" for user "+user.getUsername());
		user.getItems().forEach(e -> logger.info(""+e.getId()+", "+e.getDescription()));

		em.persist(item);
		user.getItems().add(item);
	}

}
