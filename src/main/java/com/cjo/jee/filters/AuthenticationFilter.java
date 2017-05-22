package com.cjo.jee.filters;

import java.io.IOException;
import java.security.Principal;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	private static final Logger LOGGER = Logger.getLogger(AuthenticationFilter.class.getName());

	@Inject
	private Connected connected;

	@Inject
	private ConnectionFlow flow;

	/**
	 * Default constructor. 
	 */
	public AuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		// static resources
		if (req.getServletPath().startsWith("/js") || req.getServletPath().startsWith("/css")) {
			chain.doFilter(request, response);
			return;
		}
		LOGGER.info("---------------");
		LOGGER.info("req.getRequestURI(): "+req.getRequestURI());
		LOGGER.info("req.getContextPath(): "+req.getContextPath());
		LOGGER.info("req.getPathInfo(): "+req.getPathInfo());
		LOGGER.info("req.RequestURL(): "+req.getRequestURL());
		LOGGER.info("req.getServletContext().getContextPath(): "+req.getServletContext().getContextPath());
		LOGGER.info("req.getMethod(): "+req.getMethod());		
		LOGGER.info("req.getServletPath(): "+req.getServletPath());

		if ("/logout".equals(req.getServletPath())) {
			LOGGER.info("on logout ..");
			chain.doFilter(req, response);
			return;
		}
		
		// pass the request along the filter chain
		if (connected.isConnected()) {
			req = new HttpServletRequestWrapper(req) {
				@Override
				public Principal getUserPrincipal() {
					return connected.getPrincipal();
				}
			};
		}

		if ("/login".equals(req.getServletPath())) {
			LOGGER.info("on login ..");
			chain.doFilter(req, response);
			return;
		}
		if (!req.getServletPath().startsWith("/secured/")) {
			LOGGER.info("not secured ...");
			chain.doFilter(req, response);
			return;
		}

		if (! connected.isConnected()) {

			LOGGER.info("not authenticated on "+req.getServletPath());
			flow.top();
			req.getRequestDispatcher("/login").forward(req, response);

		} else {
			LOGGER.info("Authenticated ..., user principal="+connected.getPrincipal());
			chain.doFilter(req, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
