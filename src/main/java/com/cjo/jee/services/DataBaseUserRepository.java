package com.cjo.jee.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cjo.jee.endpoints.api.User;

@ApplicationScoped
@Database
public class DataBaseUserRepository implements IRepository {

	@PersistenceContext(unitName="bookPu")
	private EntityManager em;

	@Override
	public Map<String, String> list() { 		
 		List<User> users = em.createQuery("FROM User", User.class).getResultList();
 		Map<String, String> map = new HashMap<>();
 		users.stream().forEach(u -> map.put(u.getLogin(), u.getPassword())); 		
 		return map;
	}

}
