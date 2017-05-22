package com.cjo.jee.filters;

import java.io.Serializable;
import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SessionScoped
public class Connected implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private HttpServletRequest request;

	// @Inject
	private HttpSession session;

	@PostConstruct
	void init() {
		this.session = request.getSession();
	}
	
	public boolean isConnected() {
		return session.getAttribute("user") != null;
	}
	
	public Principal connect(String user) {
		Principal p = new Principal() {
			@Override
			public String getName() {
				return user;
			}
		};
		session.setAttribute("user", p);
		return p;
	}
	
	public void disconnect() {
		session.invalidate();
	}
	
	public Principal getPrincipal() {
		return (Principal) session.getAttribute("user");
	}
}
