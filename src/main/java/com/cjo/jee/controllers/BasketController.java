package com.cjo.jee.controllers;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjo.jee.controllers.model.Basket;

@WebServlet("/baskets")
public class BasketController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Basket basket;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		basket.addItem(request.getParameter("name"), request.getParameter("value"));
		
		request.getRequestDispatcher("/hello").forward(request, response);
	}

}
