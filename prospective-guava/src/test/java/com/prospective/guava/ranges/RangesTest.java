package com.prospective.guava.ranges;

import com.google.common.collect.Range;
import com.google.common.primitives.Ints;
import junit.framework.TestCase;

public class RangesTest extends TestCase {
    public void test1() {
        assertEquals(true,Range.closed(1, 3).contains(2));
        assertEquals(false,Range.closed(1, 3).contains(4));
        assertEquals(false,Range.lessThan(5).contains(5));
        assertEquals(true, Range.closed(1, 4).containsAll(Ints.asList(1, 2, 3)));
        assertEquals(true,Range.closedOpen(4, 4).isEmpty());
        assertEquals(Integer.valueOf(3),Range.open(3, 10).lowerEndpoint());
        assertEquals(Range.openClosed(5, 5),Range.closed(3, 5).intersection(Range.open(5, 10)));
    }
}
