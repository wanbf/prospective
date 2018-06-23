package com.angel.practice.util;

import org.junit.Test;

import java.util.IdentityHashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by wanbf on 2017/12/11.
 */
public class IdentityHashMapTest {
    IdentityHashMap map = new IdentityHashMap();
    Integer i=new Integer(2);
    @Test
    public void test() {
        map.put(1, 1);
        map.put(1, 2);
        assertEquals(2, map.get(1));

        map.put(new Integer(1),3);
        assertEquals(null, map.get(new Integer(1)));
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("执行钩子线程");
            }
        });
        map.put(i,3);
        assertEquals(3, map.get(i));
        System.out.println(map.size());
    }
}
