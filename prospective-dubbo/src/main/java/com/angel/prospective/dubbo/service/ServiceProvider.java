package com.angel.prospective.dubbo.service;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wanbf on 2017/12/27.
 */
public class ServiceProvider {
   static  Logger logger = LoggerFactory.getLogger(ServiceProvider.class);
    public static void main(String[] args) throws InterruptedException {
      try {
          Provider provider = new DemoServiceImpl();

          // 当前应用配置
          ApplicationConfig application = new ApplicationConfig();
          application.setName("demo-service");

          // 连接注册中心配置
          RegistryConfig registry = new RegistryConfig();
          registry.setAddress("zookeeper://127.0.0.1:2181");

          // 服务提供者协议配置
          ProtocolConfig protocol = new ProtocolConfig();
          protocol.setName("dubbo");
          protocol.setPort(8889);
          protocol.setThreads(200);

          // 服务提供者暴露服务配置

          ServiceConfig<Provider> service = new ServiceConfig<Provider>();
          service.setApplication(application);
          service.setRegistry(registry);
          service.setProtocol(protocol);
          service.setInterface(Provider.class);
          service.setRef(provider);
         // service.setVersion("1.0.0");

          // 暴露及注册服务
          service.export();
      }catch (Exception ex){
          logger.error("异常",ex);
      }finally {
          Thread.sleep(10000000);
      }

    }
}
