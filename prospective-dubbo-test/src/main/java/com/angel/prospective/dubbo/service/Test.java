package com.angel.prospective.dubbo.service;

import org.springframework.context.annotation.Configuration;

/**
 * Created by wanbf on 2018/5/25.
 */
@Configuration
public class Test {
    public String id ="1";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
