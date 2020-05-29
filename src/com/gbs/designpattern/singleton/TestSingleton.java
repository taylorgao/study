package com.gbs.designpattern.singleton;

public class TestSingleton {

    public static void main(String[] args) {
        //饿汉模式，线程安全。类创建时立即初始化对象，拿空间换时间。
        SingletonStarve singletonStarve = SingletonStarve.getInstance();
        int m = singletonStarve.xMulti(4);
        System.out.println(m);

        //内部类模式，没有问题，可以保证首次访问时创建对象。
        SingletonInnerClass singletonInnerClass = SingletonInnerClass.getInstance();
        int n = singletonInnerClass.xMulti(3);
        System.out.println(n);

        //***********  注意  **********
        //1.5之后提了volatile,volatile + dcl(Double-Checked Locking)为懒汉模式提供了最佳的解决方案
        SingletonVolatile singletonVolatile = SingletonVolatile.getInstance();
        int k = singletonVolatile.mulit(3,2);
        System.out.println(k);



    }
}
