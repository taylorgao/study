package com.gbs.designpattern.strategy;

public class Multiple implements Strategy {
    @Override
    public int operation(int x, int y) {
        return x * y;
    }
}
