package com.mashibing.mca.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*AtomicXXX类本身方法都是原子性的，但不能保证多个方法连续调用是原子性的*/
public class AtomicInteger01 {
    //volatile int count =0;
    AtomicInteger count = new AtomicInteger(0);
    void m(){
        for (int i=0; i<10000;i++){
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        AtomicInteger01 t = new AtomicInteger01();
        List<Thread> threads = new ArrayList<>();
        for(int i=0;i<10;i++){
            threads.add(new Thread(t::m,"thread-"+i));
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
