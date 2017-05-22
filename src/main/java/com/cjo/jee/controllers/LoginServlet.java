package com.cjo.jee.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.cjo.jee.filters.Connected;
import com.cjo.jee.filters.ConnectionFlow;
import com.cjo.jee.services.AuthenticationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

	@Inject	
	private AuthenticationService authenticationService;

	@Inject
	private Connected connected;
	
	@Inject
	private ConnectionFlow connectionFlow;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("GET on /login");
		if (connected.isConnected()) {
			request.getRequestDispatcher("/").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("POST on /login");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			// authenticate user
			String user = authenticationService.authenticate(username, password);
			// save into session
			Principal principal = connected.connect(user);
			// manage flow back
			String savedPath = connectionFlow.savedPath();
			if (savedPath != null) {
				if (connectionFlow.savedMethod().equalsIgnoreCase("GET")) {
					response.sendRedirect(savedPath);
				} else {
					request.getRequestDispatcher(savedPath).forward(new HttpServletRequestWrapper(request) {
						@Override
						public Principal getUserPrincipal() {
							return principal;
						}
					}, response);
				}
			}
		} catch (AuthenticationException e) {
			
			request.setAttribute("error", e.getMessage());
			this.doGet(request, response);
			//request.getRequestDispatcher("/").forward(request, response);
		}
	}
}
