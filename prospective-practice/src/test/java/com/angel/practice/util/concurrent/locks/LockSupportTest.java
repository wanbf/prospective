package com.angel.practice.util.concurrent.locks;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by wanbf on 2017/11/29.
 */
public class LockSupportTest {
    @Test
    public void test() throws InterruptedException {
        Thread thread = Thread.currentThread();
        LockSupport.unpark(thread);//释放许可
        thread.sleep(1000);
        LockSupport.park();// 获取许可
        System.out.println("b");
       // LockSupport.park(); 出现死锁
    }
}
