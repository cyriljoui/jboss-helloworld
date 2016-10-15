package com.cjo.jee.dao;

import com.cjo.jee.entity.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by popom on 15/10/2016.
 */
@ApplicationScoped
public class UserDaoMemory implements IUserDao {

    private Map<String, User> users;

    @PostConstruct
    public void initialize() {
        users = new HashMap<>();
        users.put("cjoui", new User(UUID.randomUUID().toString(), "cjoui", "P@ssw0rd"));
    }

    @Override
    public User findByUsername(String username) {
        return users.get(username);
    }
}
