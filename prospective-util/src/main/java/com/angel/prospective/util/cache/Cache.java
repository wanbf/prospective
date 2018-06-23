package com.angel.prospective.util.cache;

import java.util.Iterator;

/**
 * Created by wanbf on 2017/11/22.
 */
public interface Cache<K, V> {
    int capacity();

    long timeout();

    void put(K key, V object);

    void put(K key, V object, long timeout);

    V get(K key);

    Iterator<V> iterator();

    int prune();

    boolean isFull();

    void remove(K key);

    void clear();

    int size();

    boolean isEmpty();
}
