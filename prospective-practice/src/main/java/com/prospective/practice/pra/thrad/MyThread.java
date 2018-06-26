package com.prospective.practice.pra.thrad;

public class MyThread extends Thread {
    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        System.out.println(Thread.currentThread().getName());
    }

    public MyThread() {
        super();
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName());
    }
}
