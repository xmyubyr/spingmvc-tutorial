package com.mashibing.mca.thread;

public class ThreadLocalTest {
    static ThreadLocal<String> s = new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(()->{
            s.set("1");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(s.get());
        }).start();
        new Thread(()->{
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(s.get());
        }).start();
    }
}
