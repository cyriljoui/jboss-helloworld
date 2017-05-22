package com.cjo.jee.services;

import java.util.Collections;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

public class DataBaseUserRepository implements IRepository {

	public DataBaseUserRepository(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String, String> list() {
		return Collections.singletonMap("db", "db");
	}

}
