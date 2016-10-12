package com.cjo.jee.cdi;

/**
 * Created by popom on 12/10/2016.
 */
@SimpleTwo
public class SimpleServiceTwo implements ISimpleService {
    @Override
    public String createHello() {
        return "Hello2";
    }
}
