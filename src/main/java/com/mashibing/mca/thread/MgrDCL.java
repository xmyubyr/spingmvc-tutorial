package com.mashibing.mca.thread;

public class MgrDCL {
    private static volatile MgrDCL INSTANCE;
    private MgrDCL(){};
    public static MgrDCL getInstance(){
        if(INSTANCE == null){
           synchronized (MgrDCL.class){
               if (INSTANCE == null){
                   try {
                       Thread.sleep(1);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   INSTANCE = new MgrDCL();
               }
           }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
           new Thread(()->{
               System.out.println(MgrDCL.getInstance().hashCode());
           }).start() ;
        }
    }
}
