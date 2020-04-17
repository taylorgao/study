package com.gbs.thread.futruetask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskStudy {
    //使用FutureTask封装Runnable()工作类时，正常执行后，参数rusult会成为返回值。
    //可以据此判断是否正常执行。
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer rtn = 33;
        FutureTask<Integer> fr = new FutureTask<>(new Runnable(){
            @Override
            public void run() {
                int a = 1;
            }
        },rtn);

        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(fr);
        Integer rtnReal = fr.get();
        System.out.println(rtnReal);
    }

}
