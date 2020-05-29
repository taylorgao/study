package com.gbs.designpattern.observer;

public class ObserverTest {
    public static void main(String[] args) {
        Mongo mongo = new Mongo();

        mongo.addObserver(new Customer("Sam"));
        mongo.addObserver(new Customer("May"));

        mongo.perform();
    }

}
