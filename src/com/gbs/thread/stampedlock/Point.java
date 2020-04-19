package com.gbs.thread.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class Point {
    private double x, y;
    private final StampedLock sl = new StampedLock();

    void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();    //涉及对共享资源的修改，使用写锁-独占操作
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    /**
     * 使用乐观读锁访问共享资源
     * 注意：乐观读锁在保证数据一致性上需要拷贝一份要操作的变量到方法栈，并且在操作数据时候可能其他写线程已经修改了数据，
     * 而我们操作的是方法栈里面的数据，也就是一个快照，所以最多返回的不是最新的数据，但是一致性还是得到保障的。
     *
     * @return
     */
    double distanceFromOrigin() {
        // 使用乐观读锁（T.G. : 如果此时已经被其他写锁互斥占用，则返回0）
        //T.G. : 看得出来，乐观读锁不需要释放
        long stamp = sl.tryOptimisticRead();
        // 拷贝共享资源到本地方法栈中
        //T.G. : 拿到锁后，无论是否成功，先读取资源。
        double currentX = x, currentY = y;
        // 如果有写锁被占用，可能造成数据不一致，所以要切换到普通读锁模式
        //T.G. : 读取资源后，再来校验开始拿到的锁是否已经成功（非0），或者成功拿锁后是否被其他线程拿了写锁（数据可以不一致了）
        //T.G. : 无论是上述那种情况都，都无法通过校验
        if (!sl.validate(stamp)) {
            stamp = sl.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    void moveIfAtOrigin(double newX, double newY) { // upgrade
        // Could instead start with optimistic, not read mode
        long stamp = sl.readLock();
        try {
            while (x == 0.0 && y == 0.0) {
                long ws = sl.tryConvertToWriteLock(stamp);  //读锁转换为写锁
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }
}
