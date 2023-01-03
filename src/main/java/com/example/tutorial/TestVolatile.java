package com.example.tutorial;

public class TestVolatile {
    public static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("enter thread...");
            while(flag){

            }
            System.out.println("Thread end...");
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("turn off flag");
        flag = false;
    }
}
