package com.mashibing.mca.thread;

import java.util.concurrent.TimeUnit;

public class WhatIsThread {
    private static class T1 extends Thread{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        //new T1().run();
        new T1().start();
        for(int i=0;i<10;i++){
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("main");
        }
    }
}
