package com.cjo.jee.interceptors;

import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjo.jee.filters.AuthenticationFilter;

public class LoggingInterceptor {

	private static final Logger LOGGER = Logger.getLogger(AuthenticationFilter.class.getName());
	
	@AroundInvoke
	public void around(InvocationContext context) {
		HttpServletRequest req = (HttpServletRequest) context.getParameters()[0];
		HttpServletResponse resp = (HttpServletResponse) context.getParameters()[1];

		LOGGER.info("---------------");
		LOGGER.info("req.getRequestURI(): "+req.getRequestURI());
		LOGGER.info("req.getContextPath(): "+req.getContextPath());
		LOGGER.info("req.getPathInfo(): "+req.getPathInfo());
		LOGGER.info("req.RequestURL(): "+req.getRequestURL());
		LOGGER.info("req.getServletContext().getContextPath(): "+req.getServletContext().getContextPath());
		LOGGER.info("req.getMethod(): "+req.getMethod());		
		LOGGER.info("req.getServletPath(): "+req.getServletPath());

	}
	
}
