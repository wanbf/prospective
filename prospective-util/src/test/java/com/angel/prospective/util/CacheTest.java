package com.angel.prospective.util;

import com.angel.prospective.util.cache.FIFOCache;
import com.angel.prospective.util.cache.LFUCache;
import com.angel.prospective.util.cache.LRUCache;
import com.angel.prospective.util.cache.TimedCache;
import com.angel.prospective.util.date.DateUnit;
import org.junit.Test;

/**
 * Created by wanbf on 2017/11/22.
 */
public class CacheTest {

    @Test
    public void test() throws InterruptedException {
        FIFOCache<String, String> fifoCache = new FIFOCache<String, String>(3, 0);
        fifoCache.put("key1", "value1", DateUnit.SECOND.getMillis() * 3);
        fifoCache.put("key2", "value2", DateUnit.SECOND.getMillis() * 3);
        fifoCache.put("key3", "value3", DateUnit.SECOND.getMillis() * 3);
        fifoCache.put("key4", "value4", DateUnit.SECOND.getMillis() * 3);
        //由于缓存容量只有3，当加入第四个元素的时候，根据FIFO规则，最先放入的对象将被移除，于是
        for (String value : fifoCache) {
            System.out.println(value);
        }
        System.out.println("--------------------------------------------------------------------------");

        LFUCache<String, String> lfuCache = new LFUCache<String, String>(3);
        lfuCache.put("key1", "value1", DateUnit.SECOND.getMillis() * 3);
        lfuCache.get("key1");//使用次数+1
        lfuCache.put("key2", "value2", DateUnit.SECOND.getMillis() * 3);
        lfuCache.put("key3", "value3", DateUnit.SECOND.getMillis() * 3);
        lfuCache.put("key4", "value4", DateUnit.SECOND.getMillis() * 3);

        //由于缓存容量只有3，当加入第四个元素的时候，根据LRU规则，最少使用的将被移除（2,3被移除）
        for (String value : lfuCache) {
            System.out.println(value);
        }

        System.out.println("--------------------------------------------------------------------------");

        LRUCache<String, String> lruCache = new LRUCache<String, String>(3);
        lruCache.put("key1", "value1", DateUnit.SECOND.getMillis() * 3);
        lruCache.put("key2", "value2", DateUnit.SECOND.getMillis() * 3);
        lruCache.put("key3", "value3", DateUnit.SECOND.getMillis() * 3);
        lruCache.get("key1");//使用时间推近
        lruCache.put("key4", "value4", DateUnit.SECOND.getMillis() * 3);

        //由于缓存容量只有3，当加入第四个元素的时候，根据LRU规则，最少使用的将被移除（2被移除）
        for (String value : lruCache) {
            System.out.println(value);
        }

        System.out.println("--------------------------------------------------------------------------");

        //设置了每个元素的超时时间是3秒，当4秒后此对象便被移除了
        System.out.println("Before expire: " + fifoCache.get("key2"));
        System.out.println("Sleep 4s...");
        Thread.sleep(DateUnit.SECOND.getMillis() * 4);
        System.out.println("After expire: " + fifoCache.get("key2"));

        System.out.println("--------------------------------------------------------------------------");

        TimedCache<String, String> timedCache = new TimedCache<String, String>(DateUnit.SECOND.getMillis() * 3);
        timedCache.put("key1", "value1", DateUnit.SECOND.getMillis() * 3);
        timedCache.put("key2", "value2", DateUnit.SECOND.getMillis() * 100);
        timedCache.put("key3", "value3", DateUnit.SECOND.getMillis() * 3);
        timedCache.put("key4", "value4", DateUnit.SECOND.getMillis() * 3);

        //启动定时任务，每4秒检查一次过期
        timedCache.schedulePrune(DateUnit.SECOND.getMillis() * 3);

        System.out.println("Sleep 4s...");
        Thread.sleep(DateUnit.SECOND.getMillis() * 4);

        //四秒后由于value2设置了100秒过期，其他设置了三秒过期，因此只有value2被保留下来
        for (String value : timedCache) {
            System.out.println(value);
        }
        //取消定时清理
        timedCache.cancelPruneSchedule();
    }

}
