package com.prospective.practice;


import com.prospective.practice.spring.tag.RpcService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 * Created by wanbf on 2018/1/15.
 */
public class Main {
    static AbstractApplicationContext ctx;
    static {
        ctx = new FileSystemXmlApplicationContext("classpath:beans.xml");

    }

    public static void main(String[] args) throws InterruptedException, NoSuchMethodException {

        RpcService rpcService = ctx.getBean("rpcService",RpcService.class);

        System.out.println(rpcService);


    }


}
