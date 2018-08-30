package com.angel.prospective.dubbo.client;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.angel.prospective.dubbo.service.Provider;

/**
 * Created by wanbf on 2017/12/27.
 */
public class ClientConsumer {

    public static void main(String[] args) throws Exception {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("yyy");

// 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://10.200.4.74:2181");
        registry.setUsername("root");
        registry.setPassword("root");

// 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

// 引用远程服务
        ReferenceConfig<Provider> reference = new ReferenceConfig<Provider>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
       reference.setMonitor("monitor");
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(Provider.class);
        //reference.setVersion("1.0.0");

// 和本地bean一样使用xxxService
        Provider provider = reference.get();
        System.out.println(provider.build("zhangsan"));
        Thread.sleep(1000000);
    }
}
