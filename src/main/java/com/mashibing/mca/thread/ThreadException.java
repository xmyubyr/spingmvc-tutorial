package com.mashibing.mca.thread;
/*在程序执行过程中，如果出现异常，默认情况下锁会被释放。*/
public class ThreadException {
    int count = 0;
    synchronized void m(){
        System.out.println(Thread.currentThread().getName()+" m start...");
        for (int j = 0;j <100;j++){
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            if (count == 5){
                try{
                    int i =1/0;//此处抛出异常，锁将被释放，要想不被释放，可以在这里进行catch,然后让循环继续
                    System.out.println(i);
                }catch (Exception e){

                }


            }
        }
    }

    public static void main(String[] args) {
        ThreadException t = new ThreadException();
       /* Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };*/
        new Thread(t::m,"t1").start();
        new Thread(t::m,"t2").start();
    }
}
