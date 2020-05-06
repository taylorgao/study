package com.gbs.thread.safe.singleton;

public class SingletonStarve {
    private static SingletonStarve singletonStarve = new SingletonStarve();

    private static int x = 3;

    private SingletonStarve() {
    }

    public static SingletonStarve getInstance() {
        return singletonStarve;
    }

    public int xMulti(int input)
    {
        return input * x;
    }


}


