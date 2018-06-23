package com.angel.prospective.util.cache;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wanbf on 2017/11/22.
 */
public abstract class AbstractCache<K, V> implements Cache<K, V>, Iterable<V> {
    protected Map<K, CacheObj<K, V>> cacheMap;

    private final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private final Lock readLock = cacheLock.readLock();
    private final Lock writeLock = cacheLock.writeLock();

    protected int capacity;

    protected long timeout;

    protected boolean existCustomTimeout;

    protected int hitCount;

    protected int missCount;

    @Override
    public void put(K key, V object) {
        put(key, object, timeout);
    }


    @Override
    public void put(K key, V object, long timeout) {
        writeLock.lock();
        try {
            CacheObj<K, V> co = new CacheObj<>(key, object, timeout);
            if (timeout != 0) {
                existCustomTimeout = true;
            }
            if (isFull()) {
                pruneCache();
            }
            cacheMap.put(key, co);
        } finally {
            writeLock.unlock();
        }
    }

    public int getHitCount() {
        return hitCount;
    }

    @Override
    public V get(K key) {
        readLock.lock();
        try {
            final CacheObj<K, V> co = cacheMap.get(key);
            if (co == null) {
                missCount++;
                return null;
            }
            if (co.isExpired()) {
                cacheMap.remove(key);
                missCount++;
                return null;
            }
            hitCount++;
            return co.get();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new CacheValuesIterator<V>(this);
    }

    protected abstract int pruneCache();

    @Override
    public final int prune() {
        writeLock.lock();
        try {
            return pruneCache();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public int capacity() {
        return capacity;
    }

    protected boolean isPruneExpiredActive() {
        return (timeout != 0) || existCustomTimeout;
    }

    @Override
    public boolean isFull() {
        return (capacity > 0) && (cacheMap.size() >= capacity);
    }

    @Override
    public void remove(K key) {
        writeLock.lock();
        try {
            cacheMap.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void clear() {
        writeLock.lock();
        try {
            cacheMap.clear();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public int size() {
        return cacheMap.size();
    }

    @Override
    public boolean isEmpty() {
        return cacheMap.isEmpty();
    }

    @Override
    public String toString() {
        return this.cacheMap.toString();
    }

    @Override
    public long timeout() {
        return timeout;
    }

}
