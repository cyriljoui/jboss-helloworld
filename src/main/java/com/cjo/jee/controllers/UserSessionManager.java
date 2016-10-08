package com.cjo.jee.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjo.jee.controllers.model.Basket;

@SessionScoped
public class UserSessionManager implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(UserSessionManager.class.getName());

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -1737557596049036133L;

	private String user;
	
	private String savedPath;
	
	private String httpMethod;

	@Inject
	private Basket basket;
	
	void onLoginSuccess(String user, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.user = user;
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("basket", basket);
		
		if (savedPath != null) {
			if (httpMethod.equalsIgnoreCase("GET")) {
				LOGGER.info("redirect on "+savedPath);
				response.sendRedirect(savedPath);
			} else {
				request.getRequestDispatcher(savedPath).forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/").forward(request, response);
		}
	}
	
	public boolean isAuthenticated() {
		return user != null;
	}

	public void saveContext(HttpServletRequest request) {
		this.savedPath = request.getRequestURI();
		this.httpMethod = request.getMethod();
	}
	
	void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		request.getRequestDispatcher("/").forward(request, response);
	}
}
