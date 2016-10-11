package com.cjo.jee.controllers;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.sasl.AuthenticationException;

import com.cjo.jee.backend.AuthenticationService;
import com.cjo.jee.controllers.model.User;

@RequestScoped
@Named
public class Login {

	@Inject
	private Logger logger;
	
	@Inject
	private AuthenticationService authService;
	
	@Inject
	UserSessionManager sessionManager;

	private User user = new User();
	
	public String authenticate() throws AuthenticationException {
		authService.authentication(user.getUsername(), user.getPassword());
		sessionManager.onLoginSuccess(user);
		logger.info("User authenticated "+user.getUsername());
		return "next";
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
