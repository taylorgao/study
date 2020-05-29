package com.gbs.designpattern.strategy;

public class Multiple implements Strategy {
    @Override
    public int Calulate(int x, int y) {
        return x * y;
    }
}
