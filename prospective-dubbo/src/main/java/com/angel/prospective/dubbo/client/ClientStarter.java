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
        VmService vmService = (VmService) context.getBean("vmService"); // 获取bean
        try {
            System.out.println(vmService.getVmInfoByEnv(EnvTag.TEST_ENV));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
