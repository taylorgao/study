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
            System.out.println("sum is " + sum);
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
            futureTask.cancel(true);
            System.out.println("I want cancel");
            Integer rtn = futureTask.get();
            System.out.println(rtn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
