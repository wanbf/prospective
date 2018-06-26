package com.prospective.guava.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImmutableListMultimapTest {
    @Test
    public void test() {
        ImmutableListMultimap <String,String>map = ImmutableListMultimap.of("zhangsan","zs",
                "zhangsan","sd",
                "lisi","ls");
        assertEquals(3, map.size());
        assertEquals(2, map.get("zhangsan").size());
    }
}
