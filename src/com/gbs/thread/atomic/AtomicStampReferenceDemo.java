package com.gbs.thread.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampReferenceDemo {
    public static void main(String[] args) {
        AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("Taylor",0);
        //这里旧值匹配，更新成功
        System.out.println(atomicStampedReference.compareAndSet(
                "Taylor","Sam",0,1));
        //这里旧值不匹配，更新失败
        System.out.println(atomicStampedReference.compareAndSet(
                "Sam","May",0,1));


        System.out.println(atomicStampedReference.getReference());
    }
}
