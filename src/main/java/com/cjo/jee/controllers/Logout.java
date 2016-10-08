package com.cjo.jee.controllers;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class Logout {
	
	@Inject
	private UserSessionManager sessionManager;
	
	public void logout() {
		sessionManager.logout();
	}
	
}
