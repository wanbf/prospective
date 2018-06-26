package com.prospective.practice.pra.notice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest extends Thread {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        ConditionTest c = new ConditionTest();
        new Thread(c).start();
        Thread.sleep(3000);
        c.freed();
    }

    void freed() {
        lock.lock();
        System.out.println("signal all");
        condition.signalAll();
        lock.unlock();
    }

    @Override
    public void run() {
        super.run();
        try {
            lock.lock();
            System.out.println("begin await");
            condition.await();
            System.out.println("after await");
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

