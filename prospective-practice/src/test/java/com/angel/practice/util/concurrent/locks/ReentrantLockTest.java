package com.angel.practice.util.concurrent.locks;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wanbf on 2017/11/29.
 */
public class ReentrantLockTest {
    private final Lock queueLock = new ReentrantLock();

    @Test
    public void test() {
        queueLock.lock();
        Long duration = 1000L;
        System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during " + (duration / 1000) + " seconds");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

    }
}
