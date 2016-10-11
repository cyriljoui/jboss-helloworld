package com.cjo.jee.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Hello {
	
	@Inject
	private UserSessionManager sessionManager;
	
	public String logout() {
		sessionManager.logout();
		return "index";
	}
	
}
