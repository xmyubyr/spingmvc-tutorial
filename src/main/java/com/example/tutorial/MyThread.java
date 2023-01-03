package com.example.tutorial;

public class MyThread extends Thread{
    public static int ticket = 5;
    public void run(){
        while (true){
            System.out.println("Thread ticket = " + ticketReduce());
            if(ticket < 0){
                break;
            }
        }
    }
    public int ticketReduce(){
        return ticket --;
    }

}
