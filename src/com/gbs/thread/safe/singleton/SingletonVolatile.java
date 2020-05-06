package com.gbs.thread.safe.singleton;

public class SingletonVolatile {
    private static volatile SingletonVolatile instance;

    private SingletonVolatile() {}

    public static SingletonVolatile getInstance()
    {
        if(instance == null)
        {
            synchronized (SingletonVolatile.class)
            {
                if(instance == null)
                {
                    instance = new SingletonVolatile();
                }
            }
        }
        return instance;
    }

    public int mulit(int a,int b)
    {
        return a * b;
    }
}
