package com.gbs.thread.forkjoin.mergesort;

import com.gbs.sleap.Sleap;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MergeSort extends RecursiveTask<Integer> {
    Integer[] src,obj;
    int start,end;
    static int linearSeconds = 0;
    Object lockObject;

    /*
    * start is inclusive
    * end is exclusive
    * */
    public MergeSort(Integer[] src,int start,int end,Integer[] obj,Object lockObject) {
        this.src = src;
        this.start = start;
        this.end = end;
        this.obj = obj;

        this.lockObject = lockObject;
    }

    @Override
    protected Integer compute() {
        if (end - start > 1) {
            int mid = (start + end) / 2;
            //此处调转obj和
            MergeSort left = new MergeSort(obj, start, mid, src,lockObject);
            MergeSort right = new MergeSort(obj, mid, end, src,lockObject);
            invokeAll(left, right);
            left.join();
            right.join();
            System.out.println(Thread.currentThread().getName());
            Sleap.sleap(1000);

            //线性计时
            synchronized (lockObject) {
                linearSeconds++;
            }

            int i = start, j = mid, n = start;
            while (true) {
                //此处一定要把j == end 放在前边，否则数组朝边界错误。
                if (i < mid && (j == end || src[i] <= src[j])) {
                    obj[n++] = src[i++];
                } else {
                    if (j < end) {
                        obj[n++] = src[j++];
                    } else
                        break;
                }
            }
        }

        return start;
    }

    public static void main(String[] args) {
        //定义一个对象锁，用来保证线程线性用时累加安全。
        Object lockObject = new Object();
        //源数组
        Integer []src = {10,32,7,99,80,60,40,41,40,40,48,22,3,9};
        //目标数组
        Integer []obj = new Integer[src.length];
        for (int i = 0; i < src.length; i++) {
            obj[i] = src[i];
        }
        //线程池，参数parallelism似乎没必要指定，JVM会根据cpu核心数确定
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        MergeSort task = new MergeSort(src,0,src.length,obj,lockObject);

        //开始计时
        long time1 = System.currentTimeMillis();
        forkJoinPool.invoke(task);
        task.join();
        //结束计时
        long time2 = System.currentTimeMillis();

        System.out.println("线性耗时：" + linearSeconds + "秒");
        System.out.println("耗时：" + (time2 - time1) / 1000 + "秒");

        for (int i = 0; i < src.length; i++) {
            System.out.println(obj[i]);
        }

    }

}
