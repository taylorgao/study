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
            while(quee.size() == limit) {
                System.out.println(Thread.currentThread().getName() + ",put is waiting");
                notFull.await();
            }
            System.out.println(Thread.currentThread().getName() + ",put " + x);

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
        lock.lock();
        T t = null;
        try {
            while(quee.isEmpty()){
                System.out.println(Thread.currentThread().getName() + ",take is waiting");
                notEmpty.await();}
            t = (T)quee.remove(0);
            notFull.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) throws Exception {
        Quee<String> quee = new Quee<>(4);

            new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        for(int j = 1; j < 10; j ++)
                        quee.put("good" + j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < 10; i++) {

                            String s = quee.take();
                            System.out.println(s);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

    }
}
