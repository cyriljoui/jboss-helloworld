package com.cjo.jee.services;

import java.util.Map;

public interface IRepository {

	/**
	 * List all users.
	 * @return all users;
	 */
	Map<String, String> list();

}