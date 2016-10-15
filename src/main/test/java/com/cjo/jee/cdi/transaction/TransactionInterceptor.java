package com.cjo.jee.cdi.transaction;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

/**
 * Created by popom on 15/10/2016.
 */
@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

    @AroundInvoke
    public Object manageTransaction(InvocationContext invocationContext) {
        try {
            // Begin a transaction
            System.out.println("Begin Transaction");
            Object proceed = invocationContext.proceed();
            System.out.println("Commit transaction ...");
            return proceed;
        } catch (Exception e) {
            System.out.println("Rollback transaction ...");
            throw new RuntimeException("Transaction error", e);
        }
    }

}
