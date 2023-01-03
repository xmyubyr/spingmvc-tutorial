package com.mashibing.mca.thread;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        SoftReference<byte[]> bt= new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(bt.get());
        System.gc();
        Thread.sleep(500);
        System.out.println(bt.get());
        byte[] b = new byte[1024*1024*15];
        System.out.println(bt.get());
    }
}
