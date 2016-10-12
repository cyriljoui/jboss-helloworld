package com.cjo.jee.backend;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.security.sasl.AuthenticationException;

import com.cjo.jee.backend.dao.UserDAO;
import com.cjo.jee.backend.data.User;

@ApplicationScoped
public class AuthenticationService {

	@EJB
	private UserDAO userDao;
	
	public String authentication(String username, String password) throws AuthenticationException {
		User user = userDao.findByUsernameAndPassword(username, password);
		if (user == null) {
			throw new AuthenticationException("invalid credentials for "+username);
		}
		return username;
	}
	
}
