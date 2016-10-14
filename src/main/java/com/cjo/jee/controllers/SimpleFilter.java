package com.cjo.jee.controllers;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by popom on 14/10/2016.
 */
@WebFilter("/*")
public class SimpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Initialize Filter ....");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println(">>Executing filter ... " + httpServletRequest.getRequestURI());
        chain.doFilter(request, response);
        System.out.println("<<Executing filter ... " + httpServletRequest.getRequestURI());
    }


    @Override
    public void destroy() {
        System.out.println("Destroy filter ...");
    }
}
