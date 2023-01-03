package com.mashibing.mca.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreSample {
    private static final int threadCount = 500;
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(50);
        final Semaphore semaphore = new Semaphore(20);
        for(int i = 0; i <threadCount;i++ ){
            final int threadNum = i;
            threadPool.execute(()->{
                try {
                    semaphore.acquire();//获取一个许可，所以可运行的线程数量是20/1=20
                    test(threadNum);
                    semaphore.release();//释放一个许可
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        threadPool.shutdown();
        System.out.println("finished");

    }
    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Thread number: " + threadNum);
        Thread.sleep(1000);
    }
}
