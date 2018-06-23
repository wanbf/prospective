package com.prospective.practice.pra;


/**
 * Created by wanbf on 2018/4/18.
 */
public class Main {
    public static boolean stop;

    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stop)
                    System.out.println(1111);
            }
        });
        th.start();
        Thread.sleep(1000);
        stop = true;

    }


}

