package com.cjo.jee.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
public class UserSessionManager implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -1737557596049036133L;

	private String user;
	
	void onLoginSuccess(String user) {
		this.user = user;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
	}
	
	public boolean isAuthenticated() {
		return user != null;
	}

	void logout() {
		this.user = null;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
