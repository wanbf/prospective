package com.angel.prospective.util.concurrent;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        AtomicInteger st = new AtomicInteger(1);
        int N = 4;
        CyclicBarrier barry = new CyclicBarrier(N, () -> System.out.println("barry is run over"));
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                int threadNum = st.getAndIncrement();
                System.out.println("Thread " + threadNum + " has start");
                try {
                    Thread.sleep(100);
                    System.out.println("Thread " + threadNum + " has running");
                    barry.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + threadNum + " has over");
            }).start();
        }
        System.out.println("---wait 2s-----");
    }

}
