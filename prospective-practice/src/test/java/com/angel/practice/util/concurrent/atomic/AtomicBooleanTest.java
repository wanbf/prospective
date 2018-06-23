package com.angel.practice.util.concurrent.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by wanbf on 2017/11/29.
 */
public class AtomicBooleanTest {

    private final AtomicBoolean bool = new AtomicBoolean(false);

    @Test
    public void test() {
        assertTrue(bool.compareAndSet(false, true));//设置为true，返回true 代表成功
        assertTrue(bool.compareAndSet(true, false));//设置为false,返回true,代表成功
        assertTrue(!bool.get());//判断获取的值为false
        assertEquals("false", bool.toString()); //判断获取的tostring值
        bool.set(true);
        assertTrue(bool.get());//判断获取的值为true
        bool.lazySet(false);
        assertTrue(!bool.get());//判断获取的值为false
        Boolean pre=bool.getAndSet(true);
        assertEquals(!pre,bool.get());
    }
}
