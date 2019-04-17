package com.angel.prospective.util;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;
import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

import java.net.InetSocketAddress;

public class MClient {

    public static void main(String[] args) {
        getValue();
        String[] servers = {"10.200.4.77:11211", "10.200.4.78:11211"};
        SockIOPool pool = SockIOPool.getInstance("dataServer");
        pool.setServers(servers);
        pool.setFailover(true);
        pool.setInitConn(10);
        pool.setMinConn(5);
        pool.setMaxConn(50);
        pool.setMaintSleep(30L);
        pool.setNagle(false);
        pool.setSocketTO(30000);
        pool.setBufferSize(5242880);
        pool.setAliveCheck(true);
        pool.initialize();
        MemCachedClient memCachedClient = new MemCachedClient("dataServer");

        System.out.println(memCachedClient.get("lv_mmmp").toString());
        System.out.println(memCachedClient.get("f4b22603-2381-4500-89e1-f4c7451c81b7"));


    }

    public static void setValue() {
        try {
            MemcachedClient mc = new MemcachedClient(new InetSocketAddress(
                    "10.201.3.176", 12000));
            Future<Boolean> b = null;
            Map<String, String> map = new HashMap<>();
            map.put("st1", "ssss");
            b = mc.set("neead", 900, map);
            if (b.get().booleanValue() == true) {
                mc.shutdown();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 用spymemcached从缓存中取得对象
    public static void getValue() {
        try {
         /*   MemcachedClient mc = new MemcachedClient(new InetSocketAddress(
                    "10.201.3.176", 12000));*/
            MemcachedClient mc = new MemcachedClient(new InetSocketAddress(
                    "10.200.4.77", 11211));
            Map<String, String> map = new HashMap<>();
            map.put("ss1", "sss2");
            mc.add("lv_mmmp", 9000, map);
            System.out.println(mc.get("f4b22603-2381-4500-89e1-f4c7451c81b7"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}