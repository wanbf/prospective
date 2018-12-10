package com.angel.prospective.dubbo.service;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wanbf on 2017/12/8.
 */
public class ServerStarter {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext(new String[]{"applicationContext-service.xml"});
        context.start();
        System.out.println(" app run ");
        System.in.read();


    }
}
