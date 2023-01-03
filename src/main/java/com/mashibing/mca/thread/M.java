package com.mashibing.mca.thread;

public class M {
    @Override
    protected void finalize() throws Throwable{
        System.out.println("finalize");
    }
}
