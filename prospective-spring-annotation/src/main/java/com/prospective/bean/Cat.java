package com.prospective.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author wanbf
 * @date 2019/4/13 11:47
 */
@Component
public class Cat {
    public void Cat() {
        System.out.println("Cat construct");
    }

    @PostConstruct
    public void init() {
        System.out.println("Cat init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Cat destroy");
    }
}
