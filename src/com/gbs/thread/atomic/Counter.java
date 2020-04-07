package com.gbs.thread.atomic;

import com.gbs.sleap.Sleap;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    AtomicInteger nCount = new AtomicInteger(0);
    int nTmp = 0; //仅用来比较，非原子操作的不安全

    public void increase() {
        while(true) {
            Integer nCurrent = nCount.get();
            if(nCount.compareAndSet(nCurrent,nCurrent + 1))
                break;
        }
        nTmp ++;
    }

    public Integer get()
    {
        return nCount.get();
    }

    public int getnTmp()
    {
        return nTmp;
    }

    public static void main(String[] args) {

        Counter atomicIntegerDemo = new Counter();

        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 100000; j ++) {  //循环次数要足够多，才能看出比较结果
                        atomicIntegerDemo.increase();
                    }
                }
            }).start();

        }

        Sleap.sleap(1000);

        System.out.println("atomic:" + atomicIntegerDemo.get());
        System.out.println("ordinary:" + atomicIntegerDemo.getnTmp());

    }


}
