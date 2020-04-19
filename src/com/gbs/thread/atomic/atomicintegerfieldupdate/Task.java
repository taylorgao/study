package com.gbs.thread.atomic.atomicintegerfieldupdate;

public class Task implements Runnable {
    Account account;

    public Task(Account account) {
        this.account = account;
    }


    @Override
    public void run() {
        account.deposit(2);
    }
}
