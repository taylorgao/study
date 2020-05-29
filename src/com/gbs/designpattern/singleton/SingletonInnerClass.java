package com.gbs.designpattern.singleton;

public class SingletonInnerClass {
    private static int x = 3;

    private SingletonInnerClass() {
    }

    public static SingletonInnerClass getInstance() {
        return Inner.instance;
    }

    private static class Inner{
        private static final SingletonInnerClass instance = new SingletonInnerClass();
    }

    public int xMulti(int input)
    {
        return input * x;
    }
}
