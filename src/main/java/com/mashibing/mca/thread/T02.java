package com.mashibing.mca.thread;

public class T02 {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + "m1 start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "m1 end.");
    }
    public void m2(){
        System.out.println(Thread.currentThread().getName() + "m2.");
    }

    public static void main(String[] args) {
        T02 t = new T02();
        new Thread(t::m1,"t1").start();
        new Thread(t::m2,"t2").start();
    }
}
