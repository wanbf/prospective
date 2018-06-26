package com.prospective.practice.pra.notice;


public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalEx local = new ThreadLocalEx();
        System.out.println("first:" + local.get());
        Thread.sleep(1000);
        new Thread(() -> System.out.println("second:" + local.get()))
                .start();
    }
}

class ThreadLocalEx extends InheritableThreadLocal<Long> {
    @Override
    protected Long initialValue() {
        return System.currentTimeMillis();
    }

    @Override
    protected Long childValue(Long parentValue) {
        return 123456789L;
    }
}
