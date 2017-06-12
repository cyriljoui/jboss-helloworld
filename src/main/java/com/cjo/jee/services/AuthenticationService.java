package com.cjo.jee.services;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.naming.AuthenticationException;

@ApplicationScoped
public class AuthenticationService {

	@Inject
//	@Database
	private IRepository repository;

    @Inject
    Logger logger;

	Set<String> tokens = new HashSet<>();

	public String authenticate(String login, String pwd) throws AuthenticationException {
		Map<String, String> users = repository.list();
		if (users.containsKey(login) && users.get(login).equals(pwd)) {
			tokens.add(login);
			return login;
		} else {
			throw new AuthenticationException("Invalid credentials");
		}
	}

	public boolean validate(String token) {
	    logger.info(token+" > "+tokens.contains(token)+", tokens "+tokens);
	    //return tokens.stream().anyMatch(t -> t.equals(token));
		return tokens.contains(token);
	}
}
