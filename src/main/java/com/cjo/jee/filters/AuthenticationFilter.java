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

import com.cjo.jee.controllers.UserSessionManager;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/secured/*")
public class AuthenticationFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(AuthenticationFilter.class.getName());

    @Inject
    UserSessionManager flowManager;
    
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
		if ("/login".equals(req.getServletPath())) {
			LOGGER.info("on login ..");
			chain.doFilter(request, response);
			return;
		}
		if ("/".equals(req.getServletPath())) {
			LOGGER.info("on / ..");
			chain.doFilter(request, response);
			return;
		}
		
		if (flowManager.isAuthenticated()) {
			LOGGER.info("Authenticated ... ");
			chain.doFilter(request, response);
		} else {
			
			LOGGER.info("not authenticated on "+req.getServletPath());
			flowManager.saveContext(req);

			req.getRequestDispatcher("/login").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
