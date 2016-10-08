package com.cjo.jee.controllers;

import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class Hello {
	
	@Inject
	private Logout logout;
	
	public String logout() {
		Logger.getLogger(Hello.class.getName()).info("logout");
		logout.logout();
		return "logout";
	}	
}
