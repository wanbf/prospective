package com.prospective.practice.pra.notice;

public class ThreadTest extends Thread {
    int i = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadTest t = new ThreadTest();
        new Thread(t).start();
        new Thread(t).start();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (i < 100) {
                    System.out.println(i);
                    i++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else return;
            }
        }
    }
}

