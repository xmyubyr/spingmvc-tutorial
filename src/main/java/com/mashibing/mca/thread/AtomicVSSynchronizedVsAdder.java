package com.mashibing.mca.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class AtomicVSSynchronizedVsAdder {
    static long count2 = 0;
    static AtomicInteger count1 = new AtomicInteger(0);
    static LongAdder count3 = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[1000];
        for(int i = 0; i<threads.length;i++){
            threads[i] = new Thread(()->{
                for (int k = 0; k<100000;k++){
                    count1.incrementAndGet();
                }
            });
        }
        long start = System.currentTimeMillis();
        for(Thread t:threads){
            t.start();
        }
        for(Thread t:threads){
            t.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("Atomic: " +count1.get() +" times "+(end-start));

        Object lock = new Object();
        for(int i =0 ; i< threads.length;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k = 0; k<100000;k++){
                        synchronized (lock){count2 ++;}
                    }
                }
            });
        }
        start = System.currentTimeMillis();
        for(Thread t:threads){
            t.start();
        }
        for(Thread t:threads){
            t.join();
        }
        end = System.currentTimeMillis();
        System.out.println("Synchronized: " +count2 +" times "+(end-start));
        for(int i = 0; i<threads.length;i++){
            threads[i] = new Thread(()->{
                for (int k = 0; k<100000;k++){
                    count3.increment();
                }
            });
        }
        start = System.currentTimeMillis();
        for(Thread t:threads){
            t.start();
        }
        for(Thread t:threads){
            t.join();
        }
        end = System.currentTimeMillis();
        System.out.println("LongAdder: " +count3.longValue() +" times "+(end-start));
    }
}
