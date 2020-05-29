package com.gbs.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Customer implements Observer {
    String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Mongo)
            System.out.println("dear " + name + ", mongo is arrived!");
    }
}
