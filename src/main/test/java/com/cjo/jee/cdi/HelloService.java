package com.cjo.jee.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

/**
 * Created by popom on 10/10/2016.
 */
@Interceptors(LoggingInterceptor.class)
public class HelloService {

//    @Inject
//    private ISimpleService simpleService;

    @Inject
    @Named("simpleServiceNamed")
    private ISimpleService simpleServiceNamed;

    @Inject @SimpleTwo
    private ISimpleService simpleServiceTwo;

    @PostConstruct
    public void initialize() {
        System.out.println("Post construct ..." + this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Pre destroy ... " + this);
    }

    public String callHello() {
        return "Hello world CDI,simpleServiceNamed=" + simpleServiceNamed + ", simpleServiceTwo=" + simpleServiceTwo;
    }

}
