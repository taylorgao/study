package com.gbs.thread.safe.singleton;

public class TestSingleton {

    public static void main(String[] args) {
        SingletonStarve singletonStarve = SingletonStarve.getSingletonStarve();
        int m = singletonStarve.xMulti(4);
        System.out.println(m);

        SingletonInnerClass singletonInnerClass = SingletonInnerClass.getInstance();
        int n = singletonInnerClass.xMulti(3);
        System.out.println(n);
    }
}
