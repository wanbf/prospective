package com.angel.practice.util.concurrent.locks;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wanbf on 2017/11/29.
 */
public class ReentrantReadWriteLockTest {

    @Test
    public void test() {
        final Queue q3 = new Queue();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    q3.get();
                }
            }).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    q3.put(new Random().nextInt(10000));
                }
            }).start();
        }
    }

    private class Queue {
        private Object data = null;//共享数据，只能有一个线程能写该数据，但可以有多个线程同时读该数据。
        private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

        public void get() {
            rwl.readLock().lock();//上读锁，其他线程只能读不能写
            System.out.println(Thread.currentThread().getName() + " be ready to read data!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "have read data :" + data);
            rwl.readLock().unlock(); //释放读锁，最好放在finnaly里面
        }

        public void put(Object data) {
            rwl.writeLock().lock();//上写锁，不允许其他线程读也不允许写
            System.out.println(Thread.currentThread().getName() + " be ready to write data!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " have write data: " + data);

            rwl.writeLock().unlock();//释放写锁
        }
    }
}
