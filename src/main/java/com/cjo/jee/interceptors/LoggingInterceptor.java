package com.cjo.jee.interceptors;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.cjo.jee.filters.LogEvent;

@ApplicationScoped
public class LoggingInterceptor {

	@Inject
	private Logger LOGGER;
	//	private static final Logger LOGGER = Logger.getLogger(AuthenticationFilter.class.getName());

	//@AroundInvoke
	//	public Object around(InvocationContext context) throws Exception {
	//		HttpServletRequest req = (HttpServletRequest) context.getParameters()[0];
	//		HttpServletResponse resp = (HttpServletResponse) context.getParameters()[1];
	//
	//		LOGGER.info("---------------");
	//		LOGGER.info("req.getRequestURI(): "+req.getRequestURI());
	//		LOGGER.info("req.getContextPath(): "+req.getContextPath());
	//		LOGGER.info("req.getPathInfo(): "+req.getPathInfo());
	//		LOGGER.info("req.RequestURL(): "+req.getRequestURL());
	//		LOGGER.info("req.getServletContext().getContextPath(): "+req.getServletContext().getContextPath());
	//		LOGGER.info("req.getMethod(): "+req.getMethod());		
	//		LOGGER.info("req.getServletPath(): "+req.getServletPath());
	//
	//		return context.proceed();
	//		
	//	}

	public void onEvent(@Observes HttpServletRequest req) {
		LOGGER.info("---------------");
		LOGGER.info("req.getRequestURI(): "+req.getRequestURI());
		LOGGER.info("req.getContextPath(): "+req.getContextPath());
		LOGGER.info("req.getPathInfo(): "+req.getPathInfo());
		LOGGER.info("req.RequestURL(): "+req.getRequestURL());
		LOGGER.info("req.getServletContext().getContextPath(): "+req.getServletContext().getContextPath());
		LOGGER.info("req.getMethod(): "+req.getMethod());		
		LOGGER.info("req.getServletPath(): "+req.getServletPath());
	}

	public void onError(@Observes @com.cjo.jee.services.Error LogEvent log) {
		HttpServletRequest req = log.getReq();
		LOGGER.severe("req.getPathInfo(): "+req.getPathInfo());
		LOGGER.severe("req.RequestURL(): "+req.getRequestURL());
		LOGGER.severe("req.getServletContext().getContextPath(): "+req.getServletContext().getContextPath());
	}
	
	public void onEvent2(@Observes LogEvent log) {
		onEvent(log.getReq());
	}
}
