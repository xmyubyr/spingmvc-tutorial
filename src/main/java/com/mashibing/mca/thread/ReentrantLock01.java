package com.mashibing.mca.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock01 extends Thread{
    private static ReentrantLock lock = new ReentrantLock();//true表示公平锁，FALSE表示非公平锁
    public void run(){
        for (int i=0;i<100;i++){
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + " get lock");
            }catch (Exception e){
                System.out.println("error!");
            }finally {
                lock.unlock();
            }

        }

    }

    public static void main(String[] args) {
        ReentrantLock01 r = new ReentrantLock01();
        new Thread(r).start();
        new Thread(r).start();
        new ReentrantLock01().start();
        new ReentrantLock01().start();
    }
}
