package com.cjo.jee.service;

import com.cjo.jee.entity.User;

/**
 * Created by popom on 15/10/2016.
 */
public interface IAuthenticationService {

    User authenticate(String username, String password) throws AuthenticationException;

}
