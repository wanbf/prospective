package com.prospective.practice.pra.notice;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeTest {

    public static void main(String[] args) throws InterruptedException {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MILLISECOND, 10);
        Date date = c.getTime();
        Timer timer = new Timer();
        timer.schedule(new MyTask(), date);
        Thread.sleep(2000);
        timer.cancel();
    }

    static class MyTask extends TimerTask {

        @Override
        public void run() {
            System.out.println(111);
        }
    }
}
