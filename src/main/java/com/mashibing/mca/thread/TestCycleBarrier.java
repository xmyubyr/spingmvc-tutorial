package com.mashibing.mca.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCycleBarrier {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(5,()->{System.out.println("all people here.");});
        for(int i=0;i<4;i++){
            new Thread(()->{
                try {
                    Thread.sleep((long) (Math.random()*5000));
                    System.out.println(Thread.currentThread().getName() + " arrived.");
                    cb.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
