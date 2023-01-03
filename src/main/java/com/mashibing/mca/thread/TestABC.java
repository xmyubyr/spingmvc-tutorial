package com.mashibing.mca.thread;
/*用三个线程，按顺序输出abc*/
public class TestABC {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{System.out.println(" A");},"A");
        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" B");},"B");
        Thread t3 =new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" C");},"C");
        t3.start();
        t2.start();
        t1.start();
    }
}
