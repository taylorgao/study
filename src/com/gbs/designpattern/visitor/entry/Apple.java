package com.gbs.designpattern.visitor.entry;

import com.gbs.designpattern.visitor.Visitor;

public class Apple implements Fruit {
    private int price;
    private String name;

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int sell() {
        return Visitor.Sell(this);
    }
}
