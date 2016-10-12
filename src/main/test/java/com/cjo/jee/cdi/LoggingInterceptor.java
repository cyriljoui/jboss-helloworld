package com.cjo.jee.cdi;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Created by popom on 12/10/2016.
 */
public class LoggingInterceptor {

    @AroundConstruct
    private void init(InvocationContext ic) throws Exception {
        System.out.println("Entering constructor");
        try {
            ic.proceed();
        } finally {
            System.out.println("Exiting constructor");
        }
    }

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        System.out.println(">> " + ic.getTarget().toString() + " - " + ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            System.out.println("<< " + ic.getTarget().toString() + " - " + ic.getMethod().getName());
        }
    }
}
