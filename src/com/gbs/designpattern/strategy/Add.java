package com.gbs.designpattern.strategy;

public class Add implements Strategy {
    @Override
    public int Calulate(int x, int y) {
        return x + y;
    }
}
