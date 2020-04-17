package com.gbs.thread.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public final class UnsafeStudy {
    private int a = 1;
    private int b = 16;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        int old = this.a;
        UNSAFE.compareAndSwapInt(this, offsetA, old, a);
    }

    public void setB(int b) {
        int old = this.b;
        UNSAFE.compareAndSwapInt(this, offsetB, old, b);
    }

    public static void main(String[] args)  {

        UnsafeStudy unsafeStudy = new UnsafeStudy();

        unsafeStudy.setA(3);
        System.out.println("a = " + unsafeStudy.getA());

        unsafeStudy.setA(6);
        System.out.println("a = " + unsafeStudy.getA());

    }

    // Unsafe mechanics
    private static final Field getUnsafe;
    private static final sun.misc.Unsafe UNSAFE;
    private static final long offsetA;
    private static final long offsetB;
    static {
        try {
            getUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            getUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) getUnsafe.get(null);
            Class<?> k = UnsafeStudy.class;
            offsetA = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("a"));
            offsetB = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("b"));

            System.out.println("offsetA = " + offsetA);
            System.out.println("offSetB = " + offsetB);


        } catch (Exception e) {
            e.printStackTrace();
            //静态代码块中初始化final变量必须抛出异常.
            //存在异常时，初始化未必成功，所以必须抛出。
            //如果注释下边这句，则编译异常。
            throw new Error(e);
        }
    }

}
