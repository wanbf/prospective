package com.prospective.practice.pra.thrad;


/**
 * Created by wanbf on 2018/4/18.
 */
public class ThreadInfo {
    public static void main(String[] args) {
        System.out.println("id:" + Thread.currentThread().getId());
        System.out.println("name:" + Thread.currentThread().getName());
        System.out.println("priority:" + Thread.currentThread().getPriority());
        System.out.println("state;" + Thread.currentThread().getState());
        System.out.println("threadGroup:" + Thread.currentThread().getThreadGroup());
        System.out.println("isAlive:" + Thread.currentThread().isAlive());
        System.out.println("isDaemon:" + Thread.currentThread().isDaemon());
        System.out.println("isInterrupt:" + Thread.currentThread().isInterrupted());
        System.out.println("activeCount:" + Thread.activeCount());
        System.out.println("toString:" + Thread.currentThread().toString());
    }

}

