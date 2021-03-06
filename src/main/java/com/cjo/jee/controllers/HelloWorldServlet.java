package com.cjo.jee.controllers;

import com.cjo.jee.controllers.model.AuthenticatedUserSession;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secured-hello")
public class HelloWorldServlet extends HttpServlet {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 2563570703208835685L;

	@Inject
	private AuthenticatedUserSession userSession;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("user", userSession.getUsername());

		request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
