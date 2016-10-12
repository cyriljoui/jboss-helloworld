package com.cjo.jee.controllers.model;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.cjo.jee.backend.dao.UserDAO;
import com.cjo.jee.backend.data.Item;
import com.cjo.jee.backend.data.User;
import com.cjo.jee.controllers.HttpSession;

@Named
@SessionScoped
public class Basket implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -8829927525323558779L;

	@Inject
	private Logger logger;
	
	@EJB
	private UserDAO dao;
	
	@Inject
	@HttpSession
	private Map<String, Object> session;
	
	private String value;
	
	public void addItem(String name, String value) {
		User user = dao.findByUsername(((User) session.get("user")).getUsername());
		
		Item item = new Item();
		item.setDescription(value);
		
		if (Math.random() > .5) {
			logger.info(">> using addItem");
			dao.addItem(user, item);
		} else {
			logger.info(">> using addItem2");
			dao.addItem2(user, item);
		}
	}
	
	@Transactional
	public Map<Object, Object> getItems() {
		return dao.findByUsername(((User) session.get("user")).getUsername())
				.getItems()
				.stream()
				.collect(Collectors.toMap(i-> i.getId(), i-> i.getDescription()));
	}

	public void addNewItem() {
		logger.info("Adding new item "+value);
		addItem(UUID.randomUUID().toString(), value);
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
