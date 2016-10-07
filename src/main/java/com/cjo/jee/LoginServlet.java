package com.cjo.jee;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());
       
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
		
		if (username.equals("john.doe") && password.equals("pwd")) {
			request.getSession(true).setAttribute("user", username);
			String savedPath = (String) request.getSession().getAttribute("X-SAVED-REQUEST-PATH");
			if (savedPath != null) {
				LOGGER.info("> redirect on "+savedPath);
				if (((String) request.getSession().getAttribute("X-SAVED-REQUEST-METHOD")).equalsIgnoreCase("GET")) {
					response.sendRedirect(savedPath);
				} else {
					request.getRequestDispatcher(savedPath).forward(request, response);
				}
			} else {
				request.getRequestDispatcher("/").forward(request, response);
			}
			
		}
	}

}
