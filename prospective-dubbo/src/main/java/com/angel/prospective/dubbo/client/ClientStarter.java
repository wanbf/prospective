package com.angel.prospective.dubbo.client;

import com.angel.prospective.dubbo.service.Provider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wanbf on 2017/12/8.
 */
public class ClientStarter {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext-client.xml" });
        context.start();
        Provider demoService = (Provider) context.getBean("demoService1"); // 获取bean
        String message ;
        try {
            message = demoService.build("2016-10-20");
            System.out.println(" the message from server is:" + message);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
