package com.angel.prospective.util.cache;

import java.util.Iterator;

/**
 * Created by wanbf on 2017/11/22.
 */
public class CacheValuesIterator<V> implements Iterator<V> {

    private Iterator<? extends CacheObj<?, V>> iterator;

    private CacheObj<?, V> nextValue;

    CacheValuesIterator(AbstractCache<?, V> abstractCacheMap) {
        iterator = abstractCacheMap.cacheMap.values().iterator();
        nextValue();
    }

    private void nextValue() {
        while (iterator.hasNext()) {
            nextValue = iterator.next();
            if (!nextValue.isExpired())
                return;
        }
        nextValue = null;

    }

    @Override
    public boolean hasNext() {
        return nextValue != null;
    }

    @Override
    public V next() {
        final V cachedObject = nextValue.obj;
        nextValue();
        return cachedObject;
    }

    @Override
    public void remove() {
        iterator.remove();
    }


}
