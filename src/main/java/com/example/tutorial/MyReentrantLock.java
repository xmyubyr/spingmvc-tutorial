package com.example.tutorial;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyReentrantLock implements Lock {
    private static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg){
            int state = getState();
            //如果state为0，表示无锁，反之有锁
            //第一次加锁
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            //如果当前线程与占用锁的线程一致，表明线程重入
            if(Thread.currentThread() == getExclusiveOwnerThread()){
                compareAndSetState(state,state+1);
                return true;
            }
            //返回false,该线程会加入到同步队列进行等待
            return false;
        }
        @Override
        protected boolean tryRelease(int arg){
            //这个方法只有拿到线程的锁会进入，也就是只有一个线程会进入此方法
            int state = getState();
            setState(state - 1);
            //如果为0，表示完全释放，把当前占用线程设置为空
            if(getState() == 0){
                setExclusiveOwnerThread(null);

            }
            return true;
        }
    }
    private Sync sync = new Sync();
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return tryLock();
    }

    @Override
    public void unlock() {
        sync.tryRelease(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
