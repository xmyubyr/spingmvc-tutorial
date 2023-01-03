package com.example.tutorial;

import java.util.concurrent.CountDownLatch;
//三个线程同时执行
public class ThreadInSameTime {
    public static void main(String[] args) throws InterruptedException {
        int size =3;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for(int i=0;i<size;i++){
            new Thread(()->{
                try {
                    countDownLatch.await();
                    System.out.println(System.currentTimeMillis());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        Thread.sleep(5000);
        countDownLatch.countDown();
    }
}
