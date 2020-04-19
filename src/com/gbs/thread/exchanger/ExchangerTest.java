package com.gbs.thread.exchanger;



import com.gbs.sleap.Sleap;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        new Thread(new Producer(exchanger)).start();
        new Thread(new Customer(exchanger)).start();
    }
}

class Producer implements Runnable
{
    private Exchanger<Integer> exchanger;
    private Integer data = 0;

    public Producer(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }


    @Override
    public void run() {
        for(int i = 0;i < 3; i ++) {
            Sleap.sleap(100);
            //开始生产
            data++;
            try {
                System.out.println("before exchange,producer data = " + data);
                data = exchanger.exchange(data);
                System.out.println("after exchange,producer data = " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class Customer implements Runnable
{
    private Exchanger<Integer> exchanger;
    private Integer data = 0;

    public Customer(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }


    @Override
    public void run() {
        for(int i = 0;i < 3; i ++) {
            Sleap.sleap(100);
            try {
                System.out.println("before exchange,Customer data = " + data);
                data = exchanger.exchange(data);
                System.out.println("after exchange,Customer data = " + data);
                //开始消费
                data --;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}