package com.example.tutorial;

public class MyThread2 implements Runnable{
    private int ticket = 5;
    @Override
    public void run() {
        while (true){
            System.out.println("Thread ticket = " + ticket--);
            if(ticket < 0){
                break;
            }
        }
    }
}
