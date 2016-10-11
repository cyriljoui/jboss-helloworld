package com.cjo.jee.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by popom on 10/10/2016.
 */
public class HelloService {

    @PostConstruct
    public void initialize() {
        System.out.println("Post construct ..." + this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Pre destroy ... " + this);
    }

    public String callHello() {
        return "Hello world CDI";
    }

}
