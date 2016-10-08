package com.cjo.jee.filters;

import java.io.IOException;
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
import javax.servlet.http.HttpServletResponse;

import com.cjo.jee.controllers.UserSessionManager;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	private static final Logger LOGGER = Logger.getLogger(AuthenticationFilter.class.getName());

	@Inject
	UserSessionManager flowManager;

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
		LOGGER.info("---------------");
		LOGGER.info("req.getRequestURI(): "+req.getRequestURI());
		LOGGER.info("req.getContextPath(): "+req.getContextPath());
		LOGGER.info("req.getPathInfo(): "+req.getPathInfo());
		LOGGER.info("req.RequestURL(): "+req.getRequestURL());
		LOGGER.info("req.getServletContext().getContextPath(): "+req.getServletContext().getContextPath());
		LOGGER.info("req.getMethod(): "+req.getMethod());
		LOGGER.info("req.getServletPath(): "+req.getServletPath());

		if (req.getPathInfo().equals("/index.xhtml")) {
			LOGGER.info("on /index.xhtml ...");
			chain.doFilter(request, response);
			return;
		}
		if (req.getPathInfo().equals("/login.xhtml")) {
			LOGGER.info("on /login.xhtml ...");
			chain.doFilter(request, response);
			return;
		}
		if (flowManager.isAuthenticated()) {
			LOGGER.info("Authenticated ... ");
			chain.doFilter(request, response);
		} else {

			LOGGER.info("not authenticated on "+req.getRequestURI());
			((HttpServletResponse)response).sendRedirect(req.getServletContext().getContextPath()+"/faces/login.xhtml");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
