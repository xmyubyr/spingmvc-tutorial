package com.mashibing.mca.thread;

import java.util.concurrent.*;

public class HowToCreateThread {
    static class Mythread extends Thread{
        @Override
        public void run(){
            System.out.println("Hello Mythread!"+Thread.currentThread().getName());
        }
    }
    static class MyRun implements Runnable{

        @Override
        public void run() {
            System.out.println("Hello MyRun!"+Thread.currentThread().getName());
        }
    }
    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("Hello MyCallable!");
            return "A returns";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Mythread().start();
        new Thread(new MyRun()).start();
        new Thread(()->{
            System.out.println("Hello Lambda!"+Thread.currentThread().getName());
        }).start();
        ExecutorService executorService=Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        System.out.println(future.get());
    }
}
