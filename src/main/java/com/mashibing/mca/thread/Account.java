package com.mashibing.mca.thread;

import java.util.concurrent.TimeUnit;

public class Account {
    String name;
    double balance;
    public void set(String name,double balance){
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.name = name;
        this.balance = balance;
    }
    public double getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        Account a = new Account();
        new Thread(()->{
            a.set("zhangsan",100.0);
        }).start();
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println(a.getBalance("zhangsan"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(a.getBalance("zhangsan"));
    }
}
