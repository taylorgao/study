package com.gbs.designpattern.visitor;

import com.gbs.designpattern.visitor.entry.Apple;
import com.gbs.designpattern.visitor.entry.Fruit;
import com.gbs.designpattern.visitor.entry.Orange;

public class Visitor {
    public static int Sell(Apple apple)
    {
        return 50;
    }

    public static int Sell(Orange orange)
    {
        return 30;
    }

    public static int Sell(Fruit fruit)
    {
        return 10;
    }
}
