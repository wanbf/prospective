package com.prospective.practice.pra.notice;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thready begin");
        Thready t = new Thready();
        t.start();
        t.join();
        System.out.println(System.currentTimeMillis());
        t.join(2000);
        System.out.println(System.currentTimeMillis());
        System.out.println("Thready over");
    }
}

class Thready extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thready run");
    }
}
