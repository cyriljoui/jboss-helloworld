package com.cjo.jee.filters;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SessionScoped
public class ConnectionFlow implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private HttpSession session;

	@Inject
	private HttpServletRequest req;

	public void top() throws ServletException {
		session.setAttribute("X-SAVED-REQUEST-PATH", req.getRequestURI());
		session.setAttribute("X-SAVED-REQUEST-METHOD", req.getMethod());
	}
	
	public String savedPath() {
		return (String) session.getAttribute("X-SAVED-REQUEST-PATH");
	}
	
	public String savedMethod() {
		return (String) session.getAttribute("X-SAVED-REQUEST-METHOD");
	}
}
