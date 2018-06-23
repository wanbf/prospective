package com.angel.practice.util.concurrent;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by wanbf on 2017/11/29.
 */
public class ArrayBlockingQueueTest {
    @Test
    public void test() throws InterruptedException {
        ArrayBlockingQueue<String> names = new ArrayBlockingQueue<String>(1);
/*        names.offer("zhangsan");
        names.offer("lisi");*/
        names.put("11");
      //  names.put("22");
        System.out.println( names.poll());
    }
}
