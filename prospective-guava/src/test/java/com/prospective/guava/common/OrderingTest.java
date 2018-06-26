package com.prospective.guava.common;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderingTest {
    @Test
    public void test() {
        Ordering<String> order = new Ordering<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Ints.compare(s1.length(), s2.length());
            }
        };
        assertEquals("bc", order.max("a", "bc"));
    }
}
