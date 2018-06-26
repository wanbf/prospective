package com.prospective.guava.reflection;

import com.google.common.collect.Lists;
import junit.framework.TestCase;

import java.util.ArrayList;

public class ReflectionTest extends TestCase {
    public void test1() {
        ArrayList<String> stringList = Lists.newArrayList();
        ArrayList<Integer> intList = Lists.newArrayList();
        assertEquals(true, stringList.getClass().isAssignableFrom(intList.getClass()));
        assertEquals(stringList.getClass(), intList.getClass());
    }

    public void test2() {

    }
}
