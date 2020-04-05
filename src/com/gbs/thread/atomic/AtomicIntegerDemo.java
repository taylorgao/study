package com.gbs.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Integer a = atomicInteger.incrementAndGet();
        System.out.println(a);

        Integer b = atomicInteger.getAndIncrement();
        System.out.println(b);
        System.out.println(atomicInteger.get());
    }
}
