package com.prospective.guava.collections;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImmutableSetTest {
    @Test
    public void test() {
        ImmutableSet<String> COLORS = ImmutableSet.of("red", "green", "blue");
        ImmutableSet<String> COPY_COLORS = ImmutableSet.copyOf(COLORS);
        assertEquals(3, COLORS.size());

    }
}
