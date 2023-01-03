package com.mashibing.mca.thread;

public class T03 {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + " m1 start...");
      /*  try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        m2();
        System.out.println(Thread.currentThread().getName() + " m1 end.");
    }
    public synchronized void m2(){
        System.out.println(Thread.currentThread().getName() + " m2.");
    }

    public static void main(String[] args) {
        new T03().m1();
    }
}
