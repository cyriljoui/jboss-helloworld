package com.cjo.jee.backend;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.security.sasl.AuthenticationException;

@ApplicationScoped
public class AuthenticationService {

	public static Map<String, String> users;
	
	static {
		users = new HashMap<>();
		users.put("john.doe", "pwd");
	}
	
	public String authentication(String username, String password) throws AuthenticationException {
		if (! users.containsKey(username)) {
			throw new AuthenticationException("invalid username "+username);
		}
		if (! users.get(username).equals(password)) {
			throw new AuthenticationException("invalid password");
		}
		return username;
	}
	
}
