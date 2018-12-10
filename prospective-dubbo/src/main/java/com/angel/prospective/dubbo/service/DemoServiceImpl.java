package com.angel.prospective.dubbo.service;



/**
 * Created by wanbf on 2017/12/8.
 */
public class DemoServiceImpl implements Provider{
    @Override
    public String build(String name) throws Exception {
        System.out.println(" got a argument: " + name);
        return "message from provider: " + name;
    }
}
