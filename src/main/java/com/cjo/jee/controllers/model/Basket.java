package com.cjo.jee.controllers.model;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Basket {

	private String name;
	
	private String value;
	
	private Map<String, String> items = new HashMap<>();
	
	public void addItem(String name, String value) {
		items.put(name, value);
	}
	
	public Map<String, String> getItems() {
		return items;
	}

	public void addNewItem() {
		Logger.getLogger(Basket.class.getName()).info("Adding new item "+name);
		addItem(name, value);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
