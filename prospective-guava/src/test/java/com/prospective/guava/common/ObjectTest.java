package com.prospective.guava.common;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class ObjectTest {
    @Test
    public void test(){
        assertEquals(true, Objects.equals("a","a"));
        assertEquals(true, Objects.equals("",""));
    }
}
