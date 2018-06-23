package com.angel.practice.util.concurrent.atomic;


import com.angel.practice.entity.Student;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;

/**
 * Created by wanbf on 2017/11/29.
 */
public class AtomicReferenceTest {
    private final AtomicReference<Student> ar = new AtomicReference<Student>();

    @Test
    public void test() {
        ar.set(new Student(11));
        assertEquals(11, ar.get().getAge());
        AtomicBoolean bool = new AtomicBoolean();
        System.out.println(bool.get());

        AtomicInteger in = new AtomicInteger();
        System.out.println(in.get());
    }
}
