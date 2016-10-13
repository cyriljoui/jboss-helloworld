package com.cjo.jee.cdi.ioc;

import javax.inject.Inject;

/**
 * Created by popom on 13/10/2016.
 */
public class Bean1 {

    @Inject
    private Bean2 bean2;

    public Bean1() {
        System.out.println("Bean1");
    }
}
