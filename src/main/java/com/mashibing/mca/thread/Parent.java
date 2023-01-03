package com.mashibing.mca.thread;
/*锁重入*/
public class Parent {
    synchronized void m(){
        System.out.println("m start...");
        System.out.println("m end...");
    }

    public static void main(String[] args) {
        new child().m();
    }
}
class child extends Parent{
    @Override
    synchronized void m(){
        System.out.println("child m start...");
        super.m();
        System.out.println("child m end...");
    }
}