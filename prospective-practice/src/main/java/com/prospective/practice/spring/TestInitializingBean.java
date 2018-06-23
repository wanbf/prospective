package com.prospective.practice.spring;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by wanbf on 2018/5/24.
 */
public class TestInitializingBean implements InitializingBean, DisposableBean, ApplicationListener<ContextRefreshedEvent>, BeanNameAware {
    private int age;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void testInit() {
        System.out.println("testInit");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy" );
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("onApplicationEvent");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName" );
    }
}
