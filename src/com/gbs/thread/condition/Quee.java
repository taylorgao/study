package com.gbs.thread.condition;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Quee<T> implements IQuee<T> {
    private List<T> quee = new LinkedList<>();
    private final int limit;

    public Quee(int limit) {
        this.limit = limit;
    }

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    @Override
    public void put(T x) throws InterruptedException {
        lock.lock();
        try {
            while(quee.size() == limit)
                notFull.await();

            quee.add(x);
            notEmpty.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public T take() throws InterruptedException {
        return null;
    }
}
