package com.gbs.thread.producer_customer;

import com.gbs.sleap.Sleap;

public class Customer implements Runnable {
    Basket basket;

    public Customer(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {

        while(true)
        {
            synchronized (basket)
            {
                while(basket.getCount() == 0)
                {
                    try {
                        basket.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                int nCnt = basket.getCount();
                basket.setCount(nCnt - 1);
                System.out.println(Thread.currentThread().getName() + "消费了1个面包。");
                basket.notifyAll();
            }
            Sleap.sleap(200);

        }
    }
}
