package com.angel.prospective.util.concurrent;

import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;

public class CountDownTest extends TestCase {
    final CountDownLatch latch = new CountDownLatch(1);

    public void test1() throws InterruptedException {
        Thread.currentThread().setName("Thread333");
        new Thread(() -> {
            System.out.println("Thread 1 has running");
            latch.countDown();
        }, "Thread111").start();
        new Thread(() -> {
            System.out.println("Thread 1 has running");
            latch.countDown();
        }, "Thread122").start();
        latch.await();
        System.out.println("Thread main has running");
    }
}
