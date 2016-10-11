package com.cjo.jee.controllers.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class Basket implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -8829927525323558779L;

	@Inject
	private Logger logger;
	
	private String value;
	
	private Map<String, String> items = new HashMap<>();
	
	public void addItem(String name, String value) {
		items.put(name, value);
	}
	
	public Map<String, String> getItems() {
		return items;
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
