package com.prospective.practice.pra.thrad;

public final class Main {
    static final String test1 = "";

    public static void main(String[] args) {
       /* ThreadGroup group = new ThreadGroup("group1");
        MyThread thread = new MyThread(group, null, "threadA");
        thread.setName("threadB");
        thread.start();*/
        Main m1 = new Main();
        Main m2 = new Main();
        Thread t = new Thread(() -> m1.test("m1"));
        Thread t1 = new Thread(() -> m2.test("m2"));
        t.start();
        t1.start();

    }

    void test(String s) {
        synchronized (s) {
            for (int i = 0; i < 10000; i++) {
                System.out.println(s + ":" + i);
            }
        }
    }
}
