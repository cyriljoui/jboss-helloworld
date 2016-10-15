package com.cjo.jee.service;

import com.cjo.jee.dao.IUserDao;
import com.cjo.jee.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Created by popom on 15/10/2016.
 */
@ApplicationScoped
public class AuthenticationService implements IAuthenticationService {

    @Inject
    private IUserDao userDao;

    @Override
    public User authenticate(String username, String password) throws AuthenticationException {
        User user = userDao.findByUsername(username);

        if (user == null) {
            throw new AuthenticationException("User not found");
        }

        if (!password.equals(user.getPassword())) {
            throw new AuthenticationException("Bad credentials");
        }

        return user;
    }
}
