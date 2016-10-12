package com.cjo.jee.cdi;

import javax.inject.Named;

/**
 * Created by popom on 12/10/2016.
 */
@Named("simpleServiceNamed")
public class SimpleServiceNamed implements ISimpleService {
    @Override
    public String createHello() {
        return "Hello2";
    }
}
