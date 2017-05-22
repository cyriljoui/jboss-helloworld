package com.cjo.jee.services;

import java.util.Collections;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Database
public class DataBaseUserRepository implements IRepository {

	@Override
	public Map<String, String> list() {
		return Collections.singletonMap("db", "db");
	}

}
