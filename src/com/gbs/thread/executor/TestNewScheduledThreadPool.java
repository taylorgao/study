package com.gbs.thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TestNewScheduledThreadPool {
    public static void main(String[] args) {

        ScheduledExecutorService schedual = Executors.newScheduledThreadPool(1);
        final ScheduledFuture<?> scheduledFuture = schedual.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +  " beep!");
            }
        }, 1, 1, TimeUnit.SECONDS);

        final ScheduledFuture<?> scheduledFuture1 = schedual.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +  " test!");
            }
        }, 1, 1, TimeUnit.SECONDS);

        schedual.schedule(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName() +  " will control!");

                scheduledFuture.cancel(true);
                System.out.println("Beep work has been Canceled");
                /*schedual.shutdown();
                System.out.println("isShutdown = " + schedual.isShutdown());*/
            }
        },5,TimeUnit.SECONDS);
    }
}
