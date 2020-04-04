package com.gbs.thread.forkjoin.taskwithpool;

import com.gbs.sleap.Sleap;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {
    private  int threshold ;
    private static final int segmentation = 10;

    private int[] src;

    private int fromIndex;
    private int toIndex;
    /*
     * start is inclusive
     * end is exclusive
     * */
    public SumTask(int formIndex,int toIndex,int[] src){
        this.fromIndex = formIndex;
        this.toIndex = toIndex;
        this.src = src;
        this.threshold = src.length/segmentation;
    }

    @Override
    protected Integer compute() {
        if((toIndex - fromIndex)<=threshold ){
            System.out.println(Thread.currentThread().getName());
            int Ttl = 0;
            System.out.println(" from index = "+fromIndex
                    +" toIndex="+toIndex);
            for(int i = fromIndex;i<toIndex;i++){
                Ttl+=src[i];
            }
            Sleap.sleap(100);
            return Ttl;
        }else{
            int mid = (fromIndex+toIndex)/2;
            SumTask left =  new SumTask(fromIndex,mid,src);
            SumTask right = new SumTask(mid,toIndex,src);
            invokeAll(left,right);
            return left.join()+right.join();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        ForkJoinPool forkJoinPool= new ForkJoinPool();
        SumTask sumTask  = new SumTask(0,array.length,array);

        long start = System.currentTimeMillis();

        forkJoinPool.invoke(sumTask);
        //invoke是同步方法，执行完所有子任务前不会执行下边的语句。
        System.out.println("main is working");
        System.out.println("The count is "+sumTask.join()
                +" spend time:"+(System.currentTimeMillis()-start)+"ms");

    }
}
