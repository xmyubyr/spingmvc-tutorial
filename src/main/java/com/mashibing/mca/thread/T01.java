package com.mashibing.mca.thread;

public class T01 {
    private int count = 10;
    private Object o = new Object();
    public T01(){
        m();
        n();
    }
    public void m(){
        synchronized (o){
            count --;
            System.out.println(Thread.currentThread().getName() + ",count = " +count);
        }
    }
    public void n(){
        for(int i =0;i<10;i++){
            new Thread(()->{
                m();
            }).start();
        }

    }

    public static void main(String[] args) {
        new T01();

    }
}
