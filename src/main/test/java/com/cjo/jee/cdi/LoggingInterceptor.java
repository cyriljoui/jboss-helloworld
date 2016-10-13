package com.cjo.jee.cdi;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Created by popom on 12/10/2016.
 */
public class LoggingInterceptor {

    @AroundConstruct
    private void init(InvocationContext ic) {
        System.out.println("Entering constructor");
        try {
            try {
                ic.proceed();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
