package com.mashibing.mca.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/*volatile保证线程可见性，禁止指令重排序,但是它不能保证原子性
* synchronized可以保证线程的可见性，原子性，不能保证有序性*/
public class TestVolatile {
    /*volatile boolean running = true;*/
    volatile int count =0;
   /* void m(){
        System.out.println("m start");
        while (running){

        }
        System.out.println("m end");
    }*/
    synchronized void n(){
        for (int i =0;i<10000;i++){
            count ++;
        }
    }

    public static void main(String[] args) {
        TestVolatile t = new TestVolatile();
        /*new Thread(t::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t.running = false;*/
        List<Thread> threads = new ArrayList<>();
        for(int i=0;i<10;i++){
            threads.add(new Thread(t::n,"thread-"+i));
        }
        threads.forEach((o)->{
            o.start();
        });
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(t.count);
    }

}
