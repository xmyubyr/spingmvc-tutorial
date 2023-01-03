package com.mashibing.mca.thread;

import java.util.concurrent.Semaphore;

public class TestSemaphore {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(3);//允许一个线程同时执行
        new Thread(()->{
            try {
                s.acquire();//阻塞方法
                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                s.release();
            }
        }).start();
        new Thread(()->{
            try {
                s.acquire();
                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                s.release();
            }
        }).start();
        new Thread(()->{
            try {
                s.acquire();
                System.out.println("T3 running...");
                Thread.sleep(200);
                System.out.println("T3 running...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                s.release();
            }
        }).start();
    }


}
