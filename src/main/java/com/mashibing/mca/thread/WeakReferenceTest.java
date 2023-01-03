package com.mashibing.mca.thread;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
        ThreadLocal<M> t1 = new ThreadLocal<>();
        t1.set(new M());
        t1.remove();
    }
}
