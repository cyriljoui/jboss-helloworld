package com.cjo.jee.cdi;

/**
 * Created by popom on 12/10/2016.
 */
public class SimpleServiceDefault implements ISimpleService {
    @Override
    public String createHello() {
        return "Hello";
    }
}
