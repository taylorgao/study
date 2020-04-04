package com.gbs.thread.forkjoin.nopool;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

/*
*  exercise by T.G.
* */
public class MultiCalculate extends RecursiveTask<Integer> {

    int start,end,mid;
    int threshold;
    int []a;
    /*
    * start is inclusive
    * end is exclusive
    * */
    public MultiCalculate(int start, int end, int[] a) {
        this.start = start;
        this.end = end;
        threshold = a.length / 10;
        this.a = a;
    }

    @Override
    protected Integer compute() {

        if(end - start <= threshold)
        {
            int sum = 0;
            for (int i = start; i < end ; i++) {
                sum += a[i];
            }
            System.out.println(Thread.currentThread().getName() + " from " + start + " to " + (end - 1) + " is " + sum);
            return sum;
        }
        else
        {
            int mid = (end + start) / 2;
            MultiCalculate left = new MultiCalculate(start,mid,a);
            MultiCalculate right = new MultiCalculate(mid,end,a);
            left.fork();
            right.fork();
            return left.join() + right.join();
        }
    }
    /*
    * 无线程池，但存使用fork， join
    * */
    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;

        }
        MultiCalculate multiCalculate = new MultiCalculate(0, a.length, a);
        multiCalculate.fork();
        //未使用线程池，异步调用，所有不等自任务完成，main会继续工作
        System.out.println("main is working");

        System.out.println(multiCalculate.join());

    }
}
