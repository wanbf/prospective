package com.prospective.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author wanbf
 * @date 2019/4/13 11:02
 */
public class Car implements InitializingBean,DisposableBean{
    public Car() {
        System.out.println("Car Constructor");
    }

    public void init() {
        System.out.println("Car init");
    }

    public void destroy() {
        System.out.println("Car destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car init");
    }
}

