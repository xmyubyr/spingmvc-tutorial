package com.mashibing.mca.thread;
/*饿汉式
* 类加载到内存后，就实例一个单例，JVM保证线程安全
* 简单使用，推荐使用
* 唯一缺点：不管用不用到。类加载器时就会完成实例化*/
public class Singleton {
    private static final Singleton s = new Singleton();
    private Singleton(){};
    public static Singleton getInstance(){
        return s;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
