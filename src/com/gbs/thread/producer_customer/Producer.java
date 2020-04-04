package com.gbs.thread.producer_customer;

public class Producer implements Runnable {
    Basket basket;

    public Producer(Basket basket) {
        this.basket = basket;
    }


    @Override
    public void run() {
        while (true)
        {
            synchronized (basket) {
                while (basket.getCount() > 0)
                {
                    try {
                        basket.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                basket.setCount(2);
                System.out.println("+++++生产了2个面包。");
                basket.notifyAll();
            }
        }
    }
}
