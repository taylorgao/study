package com.gbs.thread.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/*
* 资源表示信号量或者令牌。State≤0表示没有令牌可用，所有线程都需要阻塞；
* 大于0表示有令牌可用，线程每获取一个令牌，State减1，线程每释放一个令牌，State加1。
*  */
public class StudySemaphore {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        //信号量(令牌)，一个定义了三块令牌，只允许3个线程同时拿到令牌，其他线程只能等待有线程释放令牌
        Semaphore semaphore = new Semaphore(3);

        for (int i=0;i<10;i++){
            final long num = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        semaphore.acquire();  //..内部.. semaphore--
                        //执行
                        System.out.println("Accessing: " + num);
                        Thread.sleep(new Random().nextInt(5000)); // 模拟随机执行时长
                        //释放
                        semaphore.release();  //..内部.. semaphore++
                        System.out.println("Release..." + num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
    }
}
