package com.cjo.jee.cdi;

import com.cjo.jee.cdi.ioc.Bean1;
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
        System.out.println(">>  Before calling hello");
        System.out.println(helloService.callHello());
        System.out.println("<< After calling hello");


        System.out.println(">>  Before calling hello2");
        try {
            System.out.println(helloService.callHelloTrow());
        } catch (Exception e) {
        }
        System.out.println("<< After calling hello2");

        ProductService productService = container.instance().select(ProductService.class).get();
        productService.createProduct("1");

        Bean1 bean1 = container.instance().select(Bean1.class).get();

    }
}
