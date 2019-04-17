package com.angel.prospective.util;

/**
 * @author wanbf
 * @date 2019/3/27 17:59
 */
public class DemoLock {
    static String A = " Aa";
    static String B = "b";
    static Object o1 =new Object();
    static Object o2 =new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (DemoLock.class) {
                System.out.println("t1 A");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (DemoLock.class) {
                    System.out.println("t1 B");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (DemoLock.class) {
                System.out.println("t2 B");
                synchronized (DemoLock.class) {
                    System.out.println("t2 A");
                }

            }
        });

        t1.start();
        t2.start();

    }
}
