package com.cjo.jee.controllers;

import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.security.sasl.AuthenticationException;

import com.cjo.jee.backend.AuthenticationService;
import com.cjo.jee.controllers.model.User;

@ManagedBean
public class Login {

	@Inject
	private AuthenticationService authService;
	
	@Inject
	UserSessionManager sessionManager;

	@ManagedProperty("#{user}")
	private User user;
	
	public String authenticate() throws AuthenticationException {
		authService.authentication(user.getUsername(), user.getPassword());
		sessionManager.onLoginSuccess(user.getUsername());
		Logger.getLogger(Login.class.getName()).info("User authenticated "+user.getUsername());
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
