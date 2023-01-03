package com.mashibing.mca.thread;

public class Sleep_Yield_Join {
    public static void main(String[] args) {
        //testSleep();
        //testYield();
        testJoin();
    }
    static void testSleep(){
        new Thread(()->{
            for (int i=0;i<100;i++){
                System.out.println("A"+i);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
    static void testYield(){
        new Thread(()->{
            for (int i=0;i<100;i++){
                System.out.println("A"+i);
                if (i%10 == 0) Thread.yield();
            }
        }).start();
        new Thread(()->{
            for (int i=0;i<100;i++){
                System.out.println("__________B"+i);
                if (i%10 == 0) Thread.yield();
            }
        }).start();

    }
    static void testJoin(){
        Thread t1 = new Thread(()->{
            for (int i=0;i<100;i++){
                System.out.println("A"+i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i=0;i<100;i++){
                System.out.println("B"+i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t2.start();
        t1.start();
    }
}
