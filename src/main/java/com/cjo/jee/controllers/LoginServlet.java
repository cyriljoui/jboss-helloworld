package com.cjo.jee.controllers;

import com.cjo.jee.controllers.model.AuthenticatedUserSession;
import com.cjo.jee.entity.User;
import com.cjo.jee.service.AuthenticationException;
import com.cjo.jee.service.IAuthenticationService;

import javax.inject.Inject;
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

    @Inject
    private IAuthenticationService authenticationService;

    @Inject
    private AuthenticatedUserSession userSession;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Credentials OK?
        try {
            User authenticatedUser = authenticationService.authenticate(username, password);
            userSession.setAuthenticated(true);
            userSession.setUsername(username);
            req.getRequestDispatcher("/secured-hello").forward(req, resp);
        } catch (AuthenticationException e) {
            req.setAttribute("error", "Login / password error");
            doGet(req, resp);
        }
    }
}
