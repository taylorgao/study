package com.gbs.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
/*
* CountDownLatch首先定义任务次数，并调用await()方法等待任务完成。
* 调用countDown()方法表明已经完成一项任务，当任务全部完成后，继续await()方法后的任务。
* */
public class CountDownLatchThread extends Thread {
    CountDownLatch countDownLatch;

    public CountDownLatchThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(currentThread().getName() + " start");
            Thread.sleep(1000);
            countDownLatch.countDown();
            System.out.println(currentThread().getName() + " end");
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 0; i < countDownLatch.getCount(); i++) {
            new CountDownLatchThread(countDownLatch).start();
        }

        System.out.println(Thread.currentThread().getName() + " start");
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " end");

    }
}
