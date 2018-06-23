package com.prospective.practice.pra;

/**
 * Created by wanbf on 2018/1/30.
 */
public class Program {
    private static volatile int state = 0;
    private static final int total = 1000;

    public static void main(String[] args) {
        final Program program = new Program();

        new Thread(() -> {

            for (int num = 0; num < total; num += 2) {
                synchronized (program) {
                    if (state != 0) {
                        try {

                            program.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    print(num);
                    state = 1;
                    program.notify();
                }
            }
        }).start();

        new Thread(() -> {

            for (int num1 = 1; num1 < total; num1 += 2) {
                synchronized (program) {
                    if (state != 1) {
                        try {

                            program.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                    }
                    print(num1);
                    state = 0;
                    program.notify();
                }
            }
        }).start();

    }

    private static synchronized void print(int num) {
        System.out.print("hello ");
        System.out.print("world ");
        System.out.println(num);
    }
}