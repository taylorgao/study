package com.gbs.thread.cyclicbarrier;

import com.gbs.sleap.Sleap;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread extends Thread {
    CyclicBarrier cyclicBarrier;
    private static ConcurrentHashMap<String,Long> resultMap
            = new ConcurrentHashMap<>();//存放子线程工作结果的容器



    public CyclicBarrierThread(CyclicBarrier cyclicBarrier) {

        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " start.");
            resultMap.put(Thread.currentThread().getName(),Thread.currentThread().getId());
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " begins working again");
            Thread.sleep(100);
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " begins working again");
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //调用方法1
        /*CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 3; i++) {  //此处启动6个或者9个都可以（3的倍数）
            new CyclicBarrierThread(cyclicBarrier).start();
            //Sleap.sleap(1000);
        }
*/
        //调用方法2
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {  //await()执行后，会优先执行这里
                Sleap.sleap(1300);
                System.out.println("此处统计处理业务线程处理结果" + resultMap);
            }
        });
        for (int i = 0; i < 3; i++) {
            new CyclicBarrierThread(barrier).start();
            Sleap.sleap(200);
        }
    }
}
