package com.gbs.designpattern.strategy;

/**
 * 应用场景举例：顾客结算时可以使用不同种类的优惠券（多选一）
 */
public class Context {
    Strategy strategy;

    public Context() {

    }

    public void SetStrategy(Strategy stategy)
    {
        this.strategy = stategy;
    }

    public int Calculate(int x,int y)
    {
        return strategy.Calulate(x,y);
    }
}
