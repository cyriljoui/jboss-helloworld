package com.cjo.jee.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by popom on 14/10/2016.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Credentials OK?
        if ("cjoui".equals(username) && "pass".equals(password)) {
            req.getSession().setAttribute("loggedUsername", username);
            req.getRequestDispatcher("/secured-hello").forward(req, resp);
        } else {
            req.setAttribute("error", "Login / password error");
            doGet(req, resp);
        }
    }
}
