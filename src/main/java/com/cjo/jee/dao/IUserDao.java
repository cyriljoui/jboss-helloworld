package com.cjo.jee.dao;

import com.cjo.jee.entity.User;

/**
 * Created by popom on 15/10/2016.
 */
public interface IUserDao {

    User findByUsername(String username);

}
