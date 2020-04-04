package com.gbs.thread.producer_customer;

import com.gbs.sleap.Sleap;

public class Basket {
    int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public static void main(String[] args) {
        Basket basket = new Basket();
        Producer producer = new Producer(basket);
        Customer customer1 = new Customer(basket);
        Customer customer2 = new Customer(basket);
        Customer customer3 = new Customer(basket);

        Thread thp = new Thread(producer);
        Thread thc1 = new Thread(customer1);
        thc1.setName("1号消费者");
        Thread thc2 = new Thread(customer2);
        thc2.setName("2号消费者");
        Thread thc3 = new Thread(customer3);
        thc3.setName("3号消费者");

        thp.start();
        thc1.start();
        Sleap.sleap(50);
        thc2.start();
        Sleap.sleap(50);
        thc3.start();

    }
}
