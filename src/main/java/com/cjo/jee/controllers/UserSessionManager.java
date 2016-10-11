package com.cjo.jee.controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.cjo.jee.controllers.model.User;

@SessionScoped
public class UserSessionManager implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -1737557596049036133L;

	@Inject
	private Logger logger;

	@Inject
	@HttpSession
	private Map<String, Object> session;
	
	void onLoginSuccess(User user) {
		logger.info("User authenticated ... "+user.getUsername());
		session.put("user", user);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
	}

	public boolean isAuthenticated() {
		logger.info("is authenticated?");
		return session.containsKey("user");
	}

	void logout() {
		logger.info("logout ...");
		session.clear();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	@SessionScoped
	@Produces
	@HttpSession
	public Map<String, Object> session() {
		return new HashMap<>();
	}
}
