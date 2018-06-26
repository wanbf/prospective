package com.prospective.guava.concurrency;

import com.google.common.util.concurrent.*;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class ListenableFutureTest {
    ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
    final ListenableFuture<Integer> listenableFuture = executorService.submit(() -> {
        TimeUnit.MILLISECONDS.sleep(1);
        return 1;
    });
    final ListenableFuture<Integer> listenableFuture1 = executorService.submit(() -> {
        TimeUnit.MILLISECONDS.sleep(1);
        return 2;
    });

    @Test
    public void test() {
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("get listenable future's result with callback " + result);
                assertEquals(Integer.valueOf(1), result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Test
    public void test1() {
        listenableFuture1.addListener(() -> {
            try {
                System.out.println("get listenable future's result with callback " + listenableFuture1.get());
                assertEquals(Integer.valueOf(2), listenableFuture1.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }, executorService);
    }
}
