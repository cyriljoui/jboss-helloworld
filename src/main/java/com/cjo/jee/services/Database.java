package com.cjo.jee.services;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RUNTIME)
public @interface Database {
}
