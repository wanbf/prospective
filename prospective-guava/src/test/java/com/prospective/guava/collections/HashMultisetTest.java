package com.prospective.guava.collections;

import com.google.common.collect.HashMultiset;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashMultisetTest {
    @Test
    public void test(){
        HashMultiset<String> set = HashMultiset.create();
        set.add("zhangsan");
        set.add("zhangsan");
        set.add("zhangsan");
        set.add("lisi");
        assertEquals(4,set.size());

    }
}
