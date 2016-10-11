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

	@Inject
    private Logger logger;

    @Inject
    UserSessionManager flowManager;
    
	/**
     * Default constructor. 
     */
    public AuthenticationFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
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
		logger.info("---------------");
		logger.info("req.getRequestURI(): "+req.getRequestURI());
		logger.info("req.getContextPath(): "+req.getContextPath());
		logger.info("req.getPathInfo(): "+req.getPathInfo());
		logger.info("req.RequestURL(): "+req.getRequestURL());
		logger.info("req.getServletContext().getContextPath(): "+req.getServletContext().getContextPath());
		logger.info("req.getMethod(): "+req.getMethod());		
		logger.info("req.getServletPath(): "+req.getServletPath());
		if ("/login".equals(req.getServletPath())) {
			logger.info("on login ..");
			chain.doFilter(request, response);
			return;
		}
		if ("/".equals(req.getServletPath())) {
			logger.info("on / ..");
			chain.doFilter(request, response);
			return;
		}
		
		if (flowManager.isAuthenticated()) {
			logger.info("Authenticated ... ");
			chain.doFilter(request, response);
		} else {
			
			logger.info("not authenticated on "+req.getServletPath());
			flowManager.saveContext(req);

			req.getRequestDispatcher("/login").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
