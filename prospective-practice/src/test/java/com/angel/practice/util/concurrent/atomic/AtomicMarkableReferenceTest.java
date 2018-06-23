package com.angel.practice.util.concurrent.atomic;


import com.angel.practice.entity.Student;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicMarkableReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by wanbf on 2017/11/29.
 */
public class AtomicMarkableReferenceTest {
    Student st = new Student(12);
    AtomicMarkableReference aure = new AtomicMarkableReference(st, true);

    @Test
    public void test() {
        assertTrue(aure.isMarked());
        st = (Student) aure.getReference();
        assertEquals(12,st.getAge());
        assertEquals(12, ((Student)  aure.get(new boolean[]{true})).getAge());
    }
}
