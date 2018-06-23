package com.angel.prospective.util.cache;

/**
 * Created by wanbf on 2017/11/22.
 */
public class CacheObj<K, V> {
    final K key;

    final V obj;

    long lastAccess;

    long accessCount;

    long ttl;

    CacheObj(K key, V obj, long ttl) {
        this.key = key;
        this.obj = obj;
        this.ttl = ttl;
        lastAccess = System.currentTimeMillis();
    }

    boolean isExpired() {
        return (ttl > 0) && (lastAccess + ttl < System.currentTimeMillis());
    }

    V get() {
        lastAccess = System.currentTimeMillis();
        accessCount++;
        return obj;
    }

    @Override
    public String toString() {
        return "CacheObj [key=" + key + ", obj=" + obj + ", lastAccess=" + lastAccess + ", accessCount=" + accessCount + ", ttl=" + ttl + "]";
    }
}
