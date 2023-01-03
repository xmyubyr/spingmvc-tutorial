package com.mashibing.mca.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownExample {
    private static final int threadCount = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(50);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for(int i =0;i<threadCount;i++){
            final int thradNum = i;
            threadPool.execute(()->{
                try {
                    test(thradNum);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    countDownLatch.countDown();//表示一个请求已经被完成
                }
            });
        }
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("finished");

    }
    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Thread number: " + threadNum);
        Thread.sleep(1000);
    }
}
