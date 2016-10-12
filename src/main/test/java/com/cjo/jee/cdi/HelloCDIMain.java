package com.cjo.jee.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Created by popom on 10/10/2016.
 */
public class HelloCDIMain {

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        HelloService helloService = container.instance().select(HelloService.class).get();
        System.out.println(helloService.callHello());

        ProductService productService = container.instance().select(ProductService.class).get();
        productService.createProduct("1");
    }
}
