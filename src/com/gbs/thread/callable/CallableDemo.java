package com.gbs.thread.callable;

import com.gbs.sleap.Sleap;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
            //System.out.println("sum is " + sum);
            Sleap.sleap(3);
            if(Thread.interrupted())
                break;
        }
        System.out.println("Sum result is " + sum);
        return sum;
    }

    public static void main(String[] args) {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> futureTask = new FutureTask<>(callableDemo);
        new Thread(futureTask).start();

        try {
            Sleap.sleap(1);
            /*futureTask.cancel(true); //因为这个线程一生成就启动了，无法cancel了
            System.out.println("I want cancel");*/
            long l = System.currentTimeMillis();
            Integer rtn = futureTask.get();
            long l1 = System.currentTimeMillis();
            long lMinus = (long)((l1 - l) / 1000);
            System.out.println("为了等待计算结果，主线程阻塞了" + lMinus + "秒");
            System.out.println(rtn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
