package com.gbs.demo;

import java.util.concurrent.locks.StampedLock;

public class Test {
    public static void main(String[] args) {
        StampedLock sl = new StampedLock();
        long stamp = sl.tryOptimisticRead();
        System.out.println(stamp);
        long stamp1 = sl.tryOptimisticRead();
        System.out.println(stamp1);
        if(!sl.validate(stamp)) {
            stamp = sl.tryReadLock();
            try {
                System.out.println("readLock stamp " + stamp);
            }
            finally {
                sl.unlockRead(stamp);
            }
        }

    }
}
