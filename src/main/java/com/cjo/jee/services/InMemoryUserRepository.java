package com.cjo.jee.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

@ApplicationScoped
@Default
public class InMemoryUserRepository implements IRepository {

	private Map<String, String> users;
		
	@Override
	public Map<String, String> list() {
		return users;
	}
	
	@PostConstruct
	public void init() {
		users = new HashMap<>();
		
		users.put("john.doe", "pwd");
		users.put("michir", "mic");
	}
}
