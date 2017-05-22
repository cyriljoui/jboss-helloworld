package com.cjo.jee.filters;

import javax.servlet.http.HttpServletRequest;

public class LogEvent {

	
	private final HttpServletRequest req;

	public LogEvent(HttpServletRequest req) {
		super();
		this.req = req;
	}

	/**
	 * @return the req
	 */
	public HttpServletRequest getReq() {
		return req;
	}
	
	
	
}
