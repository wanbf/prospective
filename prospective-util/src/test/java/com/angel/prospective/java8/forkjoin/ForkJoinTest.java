package com.angel.prospective.java8.forkjoin;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author wanbf
 * @date 2019/1/3 17:35
 */
public class ForkJoinTest {
    @Test
    public void test01() {
        // 获取任务的开始时间
        long millis = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinWork(0L, 10000000000L);//参数为起始值与结束值

        //  执行任务
        Long result = pool.invoke(task);
        System.out.println(result);

        //获取任务的结束时间
        long millis2 = System.currentTimeMillis();
        // 21444
        System.out.println("使用 Fork/Join框架计算总共用时：" + (millis2 - millis));
    }

    @Test
    public void test02() {
        // 获取任务的开始时间
        long millis = System.currentTimeMillis();

        long num = 0;
        for (int i = 0; i < 10000000000L; i++) {
            num += i;
        }

        // 获取任务的结束时间
        long millis2 = System.currentTimeMillis();
        System.out.println(num);
        System.out.println("使用传统方式计算共用时：" + (millis2 - millis));
    }

    @Test
    public void test03() {
        // 获取任务的开始时间
        long millis = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0L, 10000000000L)
                .parallel()
                .sum();
        // 获取任务的结束时间
        long millis2 = System.currentTimeMillis();
        System.out.println(sum);
        // 84844
        System.out.println("使用Java8并行流方式计算共用时：" + (millis2 - millis));
    }


}

class ForkJoinWork extends RecursiveTask<Long> {

    private Long start;//起始值
    private Long end;//结束值
    public static final Long critical = 100000L;//临界值

    public ForkJoinWork(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        //判断是否是拆分完毕
        Long lenth = end - start;
        if (lenth <= critical) {
            //如果拆分完毕就相加
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            //没有拆分完毕就开始拆分
            Long middle = (end + start) / 2;//计算的两个值的中间值
            ForkJoinWork right = new ForkJoinWork(start, middle);
            right.fork();//拆分，并压入线程队列
            ForkJoinWork left = new ForkJoinWork(middle + 1, end);
            left.fork();//拆分，并压入线程队列

            //合并
            return right.join() + left.join();
        }
    }
}
