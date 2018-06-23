package com.prospective.practice.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by wanbf on 2018/5/24.
 */
public class TestBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1)
            throws BeansException {
        System.out.println("执行后");
        return arg0;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)
            throws BeansException {
        System.out.println("执行前");
        return arg0;
    }

    public void test(){
        System.out.println("TestBeanPostProcessor初始化已经被执行！！");
    }
}
