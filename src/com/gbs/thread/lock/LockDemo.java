package com.gbs.thread.lock;


import com.gbs.sleap.Sleap;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockDemo implements Runnable{
    static Integer n = 0;
    Lock lock;
    CountDownLatch countDownLatch;


    public LockDemo(Lock lock,CountDownLatch countDownLatch) {
        this.lock = lock;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            lock.lock();
            try {
                n ++;
                System.out.println(Thread.currentThread().getName() + " running");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            Sleap.sleap(1);
        }
        System.out.println(Thread.currentThread().getName() + " finished");
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Lock lock = new ReentrantLock();

        LockDemo lockDemo1 = new LockDemo(lock,countDownLatch);
        LockDemo lockDemo2 = new LockDemo(lock,countDownLatch);

        new Thread(lockDemo1).start();
        new Thread(lockDemo1).start();
        countDownLatch.await();
        System.out.println("n = " + n);
    }
}
