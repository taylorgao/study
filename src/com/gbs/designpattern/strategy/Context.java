package com.gbs.designpattern.strategy;

public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int x,int y)
    {
        return strategy.operation(x,y);
    }
}
