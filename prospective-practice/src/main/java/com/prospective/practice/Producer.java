package com.prospective.practice;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wanbf on 2018/1/15.
 */
public class Producer implements Runnable {
    private static final int SLEEPTIME = 1000;
    private boolean isRunning;
    private BlockingQueue<PcData> queue;
    private static AtomicInteger count;


    public Producer(BlockingQueue queue) {
        this.queue = queue;
        this.isRunning = true;
        this.count = new AtomicInteger();
    }

    @Override
    public void run() {
        PcData data = null;
        Random r = new Random();
        System.out.println("start producting id:" + Thread.currentThread().getId());
        while (isRunning) {
            try {
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new PcData(count.incrementAndGet());
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.err.println(" 加入队列失败");
                }
                System.out.println("生产: "+count);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop() {
        this.isRunning = false;
    }
}
