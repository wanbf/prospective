package com.prospective.guava.primitive;

import com.google.common.primitives.Ints;
import junit.framework.TestCase;

public class IntsTest extends TestCase {
    public void testInt(){
        int[] array = new int[]{2,8,6,9};
        assertEquals(9,Ints.max(array));
        assertEquals(2,Ints.min(array));
        assertEquals(-1,Ints.compare(1,2));
        assertEquals(4,Ints.asList(array).size());
    }
}
