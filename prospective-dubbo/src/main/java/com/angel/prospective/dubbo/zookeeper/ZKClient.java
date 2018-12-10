package com.angel.prospective.dubbo.zookeeper;

import org.I0Itec.zkclient.ZkClient;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class ZKClient {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ZkClient zkClient = new ZkClient("127.0.0.1:2181");
        List<String> configurators = zkClient.getChildren("/dubbo/com.angel.prospective.dubbo.service.Provider/configurators");
        List<String> providers = zkClient.getChildren("/dubbo/com.angel.prospective.dubbo.service.Provider/providers");

        for (String item : configurators) {
            System.out.println("configurators：" + URLDecoder.decode(item, "utf-8"));
        }
        for (String item : providers) {
            System.out.println("providers：" + URLDecoder.decode(item, "utf-8"));
        }
    }
}
