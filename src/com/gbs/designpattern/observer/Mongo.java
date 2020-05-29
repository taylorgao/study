package com.gbs.designpattern.observer;

import java.util.Observable;

public class Mongo extends Observable {

    public void perform()
    {
        this.setChanged();
        this.notifyObservers();
    }
}
