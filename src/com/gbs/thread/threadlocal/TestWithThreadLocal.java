package com.gbs.thread.threadlocal;

import com.gbs.sleap.Sleap;

import java.util.concurrent.*;

public class TestWithThreadLocal implements Runnable {
    //定义ThreadLocal静态变量，线程安全
    private static ThreadLocal<String> msg = new ThreadLocal<String>(){};
    //定义普通静态变量，没线程安全。
    private static String staticMsg;
    //定义普通变量, 如果每个线程都加载一个新的runnable类实例，那么类私有变量就是线程安全的
    //如果每个线程都加载同一个runnable类实例，那么类私有变量就不是线程安全的。
    private String commonMsg;

    public void setMsg(String msg)
    {
        TestWithThreadLocal.msg.set(msg);
    }

    public String getMsg()
    {
        return TestWithThreadLocal.msg.get();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            setMsg(Thread.currentThread().getName());
            commonMsg = staticMsg = Thread.currentThread().getName();
            Sleap.sleap(10);
            //threadlocal 变量，无线程安全问题，结果体现：Thread b -- Thread b 或者 Thread a -- Thread a
            System.out.println("ThreadLocal:" + getMsg() + " -- " + Thread.currentThread().getName());
            //普通静态变量，会出现线程安全问题，结果体现：Thread b ^^ Thread a
            System.out.println("StaticString:" + staticMsg + " ^^ " + Thread.currentThread().getName());
            //普通变量，会出现线程安全问题，结果体现：Thread b ** Thread a
            System.out.println("CommonString:" + commonMsg + " ** " + Thread.currentThread().getName());
        }
        if (msg != null)
            msg.remove();
    }

    public static void main(String[] args) {
        TestWithThreadLocal work = new TestWithThreadLocal();
//        Thread t1 = new Thread(work);
//        t1.setName("Thread a");
//        t1.start();
//
//        Thread t2 = new Thread(work);
//        t2.setName("Thread b");
//        t2.start();


        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5,10,3, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3));
        for (int i = 0 ; i < 13; i ++)
           tpe.execute(new Thread(() -> System.out.println(Thread.currentThread().getName())));
    }

}



