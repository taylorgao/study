package com.gbs.designpattern.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        System.out.println(new Context(new Add()).executeStrategy(7,3));
        System.out.println(new Context(new Subtract()).executeStrategy(7,3));
        System.out.println(new Context(new Multiple()).executeStrategy(7,3));
    }
}
