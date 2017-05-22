package com.cjo.jee.controllers;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjo.jee.filters.Connected;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private Connected connected;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		connected.disconnect();
		//response.sendRedirect(request.getContextPath());
		request.getRequestDispatcher("/").forward(request, response);
	}
}
