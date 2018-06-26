package com.prospective.guava.cache;

import com.google.common.cache.*;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CacheLoaderTest {
    @Test
    public void test() throws InterruptedException {
        LoadingCache<String, String> stringCache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(1, TimeUnit.MILLISECONDS)
                .removalListener((RemovalListener) removalNotification -> System.out.println("remove"))
                .build(
                        new CacheLoader<String, String>() {
                            public String load(String key)  {
                                return create(key);
                            }
                        });
        stringCache.put("st","st");
        assertEquals(1,stringCache.size());

    }

    private String create(String key) {
        return "value";
    }
}
