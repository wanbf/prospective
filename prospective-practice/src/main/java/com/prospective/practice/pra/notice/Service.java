package com.prospective.practice.pra.notice;

public class Service extends Thread {
    Object lock = new Object();

    public static void main(String[] args) {
        Service run = new Service();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        super.run();
        synchronized (lock){

            System.out.println("begin");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end");
        }

    }
}
