package com.cjo.jee.cdi.ioc;

import javax.inject.Inject;

/**
 * Created by popom on 13/10/2016.
 */
public class Bean2 {

    @Inject
    private Bean3 bean3;

    public Bean2() {
        System.out.println("Bean2");
    }
}
