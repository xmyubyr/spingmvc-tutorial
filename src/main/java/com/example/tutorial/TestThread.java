package com.example.tutorial;

public class TestThread {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        MyThread2 mt = new MyThread2();
        new Thread(mt).start();
        new Thread(mt).start();
    }
}
