package com.gbs.designpattern.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        Context cx = new Context();
        cx.SetStrategy(new Multiple());
        int result = cx.Calculate(3,5);
        System.out.println(result);

        cx.SetStrategy(new Add());
        result = cx.Calculate(3,5);
        System.out.println(result);
    }
}
