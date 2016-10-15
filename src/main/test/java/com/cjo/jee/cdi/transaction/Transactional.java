package com.cjo.jee.cdi.transaction;

import java.lang.annotation.*;

/**
 * Created by popom on 15/10/2016.
 */
@Inherited
@javax.interceptor.InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Transactional {
}
