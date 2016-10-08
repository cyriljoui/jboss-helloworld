package com.cjo.jee.controllers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjo.jee.backend.AuthenticationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());
    
	@Inject
	private AuthenticationService authService;
	
	@Inject
	UserSessionManager flowManager;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("GET on /login");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("POST on /login");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			String user = authService.authentication(username, password);
			flowManager.onLoginSuccess(user, request, response);

		} catch (AuthenticationException e) {
			// TODO handle error
		}
		
	}

}
