package com.prospective.practice;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by wanbf on 2018/1/15.
 */
public class Consumer implements Runnable {
    private static final int SLEEP_TIME = 1000;
    private BlockingQueue<PcData> queue;
    private boolean isRunning;

    public Consumer(BlockingQueue<PcData> queue) {
        this.queue = queue;
        this.isRunning = true;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (isRunning) {
            try {
                Thread.sleep(r.nextInt(SLEEP_TIME));
                PcData data = queue.take();
                if (data != null) {
                    System.out.println(MessageFormat.format("消费{0}", data.getData()));
                }
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
