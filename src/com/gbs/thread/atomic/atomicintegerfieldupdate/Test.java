package com.gbs.thread.atomic.atomicintegerfieldupdate;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account("gbs");
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Task(account));
            t.start();
            list.add(t);
        }
        // 等待所有线程执行完成
        for(Thread t:list)
        {
            t.join();
        }
        System.out.println(account.getMoney());
    }
}
