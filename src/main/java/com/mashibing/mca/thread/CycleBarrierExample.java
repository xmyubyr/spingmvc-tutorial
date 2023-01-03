package com.mashibing.mca.thread;

import java.util.concurrent.*;

public class CycleBarrierExample {
    private static final int threadCount = 20;
    final static CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
        System.out.println("----达到数量，开会===");
    });
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for(int i =0;i<threadCount;i++){
            final int thradNum = i;
            Thread.sleep(1000);
            threadPool.execute(()->{
                try {
                    test(thradNum);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException | TimeoutException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        threadPool.shutdown();

    }
    public static void test(int threadNum) throws InterruptedException, BrokenBarrierException, TimeoutException {

        System.out.println("threadNum: "+threadNum+" ready");
        cyclicBarrier.await(60,TimeUnit.SECONDS);
        System.out.println("Thread number: " + threadNum + " finished");
    }
}
