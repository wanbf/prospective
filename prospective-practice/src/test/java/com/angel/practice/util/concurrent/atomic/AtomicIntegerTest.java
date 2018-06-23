package com.angel.practice.util.concurrent.atomic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wanbf on 2017/11/29.
 */
public class AtomicIntegerTest {

    private final AtomicInteger in = new AtomicInteger();

    @Test
    public void test() {
        assertEquals(0, in.get());
        in.set(1);
        assertEquals(1, in.get());
        in.lazySet(2);
        assertEquals(2, in.get());
        assertEquals(2, in.getAndSet(3));
        assertEquals(3, in.get());
        assertEquals(3, in.getAndIncrement());
        assertEquals(4, in.get());
        assertEquals(4, in.getAndDecrement());
        assertEquals(3, in.get());
        assertEquals(3, in.intValue());
        assertEquals(3l, in.longValue());
    }
}
