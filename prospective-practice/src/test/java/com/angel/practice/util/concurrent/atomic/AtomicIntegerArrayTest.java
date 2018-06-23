package com.angel.practice.util.concurrent.atomic;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by wanbf on 2017/11/29.
 */
public class AtomicIntegerArrayTest {
    private  final AtomicIntegerArray aia=new AtomicIntegerArray(10);
    @Test
    public void test(){
        assertEquals(10,aia.length());
        aia.set(1,2);
        assertEquals(2,aia.get(1));
        assertEquals(2,aia.getAndIncrement(1));
        assertEquals(3,aia.get(1));
        System.out.println(aia.toString());
    }
}
