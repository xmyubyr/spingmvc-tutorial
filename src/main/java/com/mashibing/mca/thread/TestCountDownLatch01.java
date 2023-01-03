package com.mashibing.mca.thread;

import org.springframework.core.task.support.ExecutorServiceAdapter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch01 {
    public static void main(String[] args) {
        ExecutorService service =Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(3);
        for(int i=0;i<4;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " ready.");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " arrived.");
                    latch.countDown();
                }
            };
            service.execute(runnable);
        }
        try {
            latch.await();
            System.out.println(Thread.currentThread().getName() + " get core.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
