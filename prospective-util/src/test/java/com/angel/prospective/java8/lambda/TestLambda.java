package com.angel.prospective.java8.lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author wanbf
 * @date 2018/12/26 10:12
 */
public class TestLambda {
    @Test
    public void test() {
        Comparator<Integer> comparator = (o1, o2) -> {
            if (o1 > o2) return 0;
            else return 1;
        };

    }
}
