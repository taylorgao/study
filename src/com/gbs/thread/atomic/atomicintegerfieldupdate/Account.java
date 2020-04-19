package com.gbs.thread.atomic.atomicintegerfieldupdate;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

//账户信息，
public class Account {
    private String name;
    private volatile int money = 0;

    private static final AtomicIntegerFieldUpdater<Account> updater = AtomicIntegerFieldUpdater.newUpdater(Account.class,"money");


    public Account(String name) {
        this.name = name;
    }
    //存钱进来
    public void deposit(int depositAmount)
    {
        //money = money + depositAmount;  //不保证线程安全
        updater.addAndGet(this,depositAmount);
        /*
        * AtomicIntegerFiledUpdater的引入，
        * 使得我们可以在不修改用户代码（调用方）的情况下，就能实现并发安全性。
        *这也是AtomicXXXFieldUpdater引入的一个重要原因，单纯从功能上来讲，
        * 能用AtomicXXXFieldUpdater实现的并发控制，同步器和其它原子类都能实现，
        * 但是使用AtomicXXXFieldUpdater，符合面向对象设计的一个基本原则——开闭原则，尤其是对一些遗留代码的改造上。
        *使用AtomicXXXFieldUpdater，不需要进行任何同步处理，单纯的使用CAS+自旋操作就可以实现同步的效果。
        * 这也是整个atomic包的设计理念之一。
        * */
    }

    public int getMoney() {
        return money;
    }
}
