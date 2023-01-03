package com.mashibing.mca.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportSample02 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(i);
                if (i==5){
                    LockSupport.park();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        LockSupport.unpark(t);
    }
}
