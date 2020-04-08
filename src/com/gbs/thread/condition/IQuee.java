package com.gbs.thread.condition;

public interface IQuee<T> {
    void put(T x) throws InterruptedException;
    T take() throws InterruptedException;
}
