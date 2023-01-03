package com.example.tutorial;

import java.util.concurrent.Semaphore;

//三个线程交替执行
public class OrderThread2 {
    private static Semaphore s1 =new Semaphore(1);
    private static Semaphore s2 =new Semaphore(1);
    private static Semaphore s3 =new Semaphore(1);
    public static void main(String[] args) {
        try {
            s1.acquire();
            s2.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(()->{
            while(true){
                try {
                    s1.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("A");
                s2.release();
            }
        }).start();
        new Thread(()->{
            while(true){
                try {
                    s2.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("B");
                s3.release();
            }
        }).start();
        new Thread(()->{
            while(true){
                try {
                    s3.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("A");
                s1.release();
            }
        }).start();

    }
}
