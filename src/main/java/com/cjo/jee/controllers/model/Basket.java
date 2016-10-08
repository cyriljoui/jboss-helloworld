package com.cjo.jee.controllers.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Basket implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, String> items = new HashMap<>();
	
	public void addItem(String name, String value) {
		items.put(name, value);
	}
	
	public Map<String, String> getItems() {
		return items;
	}
}
