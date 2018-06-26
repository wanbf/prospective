package com.prospective.guava.common;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class OptionalTest {
    @Test
    public void test() {
        Optional<Integer> possible = Optional.of(5);
        assertEquals(true, possible.isPresent());
        assertEquals((Integer) 5, possible.get());
    }
}
