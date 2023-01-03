package com.mashibing.mca.thread;

import java.util.concurrent.CountDownLatch;

public class TestCountdownLatch {
    public static void main(String[] args) {
        usingCountdownLatch();
    }
    private static void usingCountdownLatch(){
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(()->{
                int result = 0;
                for(int j=0;j<10000;j++){
                    result += j;
                }
                latch.countDown();
            });
        }
        for(int i=0;i< threads.length;i++){
            threads[i].start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end latch");
    }
}
