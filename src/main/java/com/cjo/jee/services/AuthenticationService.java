package com.cjo.jee.services;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.naming.AuthenticationException;

@ApplicationScoped
public class AuthenticationService {

	@Inject
	@Database
	private IRepository repository;
	
	public String authenticate(String login, String pwd) throws AuthenticationException {
		Map<String, String> users = repository.list();
		if (users.containsKey(login) && users.get(login).equals(pwd)) {
			return login;
		} else {
			throw new AuthenticationException("Invalid credentials");
		}
	}
}
