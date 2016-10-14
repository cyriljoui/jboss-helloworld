package com.cjo.jee.controllers;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by popom on 14/10/2016.
 */
@WebFilter("/secured-hello")
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        System.out.println(">> auth filter ");

        // Check user connected ?
        String loggedUsername = (String) httpServletRequest.getSession().getAttribute("loggedUsername");
        if (loggedUsername == null) {
            // not logged => error go to login
            request.getRequestDispatcher("/login").forward(request, response);
            return;
        }

        // User logged, go on ...
        chain.doFilter(request, response);
    }


    @Override
    public void destroy() {
        System.out.println("Destroy filter ...");
    }
}
