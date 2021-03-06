package com.gbs.thread;

import com.gbs.sleap.Sleap;

public class ThreadDemo extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is working");
            Sleap.sleap(1000);
        }
    }

    public static void main(String[] args) {
        ThreadDemo work1 = new ThreadDemo();
        ThreadDemo work2 = new ThreadDemo();

        work1.setName("first");
        work2.setName("second");

        work1.start();
        Sleap.sleap(500);
        work2.start();
    }
}
