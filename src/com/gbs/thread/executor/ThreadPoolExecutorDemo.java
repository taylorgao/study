package com.gbs.thread.executor;

import com.gbs.sleap.Sleap;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    static class Work implements Runnable {

        private String name;

        public Work(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            //System.out.println(name + " begins");
            Sleap.sleap(30);

            //System.out.println(name + " ends");
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(3
                ,5, 3, TimeUnit.SECONDS
                ,new ArrayBlockingQueue<Runnable>(3)
                , new ThreadPoolExecutor.DiscardOldestPolicy()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println(((Work)r).getName() + " begin");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println(((Work)r).getName() + " finished");
            }

            @Override
            protected void terminated() {
                System.out.println("finished");
            }
        };

        for (int i = 0; i < 12; i++) {
            threadPoolExecutor.execute(new Work("work No." + i));
            Sleap.sleap(1);
            /*
            * 通过调整休眠时间，完成了演示预期
            * corePoolSize = 3,前三个线程直接创建并执行任务0,1,2
            * ArrayBlockingQueue 容量是3，这样前六个任务中的后三个(3,4,5)会存放在阻塞队列中
            * 容器会启动新的线程执行任务6，7
            * 因为饱和策略是舍弃最老的任务，所以此时任务8冲掉了3，任务9冲掉了4，任务10冲掉了5，任务11冲掉了8
            * 所以有线程空闲出来后，一次从阻塞队列中取到了任务9，10，11
            * 任务3，4，5，8没有得到执行
            * */
        }

        threadPoolExecutor.shutdown();
    }
}
