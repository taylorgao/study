package com.gbs.designpattern.chain;

public class FullDiscount implements ChainNode {
    ChainNode next;

    public FullDiscount(ChainNode next) {
        this.next = next;
    }

    @Override
    public int Calulate(int money) {
        if(money > 200)
            money = money - 20;
        if(next != null)
            next.Calulate(money);
        return money;
    }
}
