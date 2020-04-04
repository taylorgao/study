package com.gbs.sleap;

public class Sleap {
    public static void sleap(int millisecond)
    {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
