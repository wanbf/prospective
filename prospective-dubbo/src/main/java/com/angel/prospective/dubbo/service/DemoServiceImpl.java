package com.angel.prospective.dubbo.service;


import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * Created by wanbf on 2017/12/8.
 */
@Component
@Service
public class DemoServiceImpl implements Provider{
    @Override
    public String build(String name) throws Exception {
        System.out.println(" got a argument: " + name);
        return "message from provider: " + name;
    }
}
