package com.angel.prospective.dubbo.service;


import com.alibaba.dubbo.config.spring.ServiceBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wanbf on 2017/12/8.
 */
public class ServerStarter {
    static ClassPathXmlApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext(new String[]{"applicationContext-service.xml"});
    }


    public static void main(String[] args) throws Exception {

       /* System.out.println(context.getBean(Test.class).getId());
        context.start();*/
        System.out.println(ServiceBean.getSpringContext().getBean(Test.class).getId());

        System.out.println(" app run ");

        System.in.read();


    }
}
