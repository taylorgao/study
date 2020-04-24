package com.gbs.collection.senior;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(3);
        l.add(5);
        //迭代器
        Iterator<Integer> i = l.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("--------");
        //迭代器，可以指定开始位置
        Iterator<Integer> li = l.listIterator(1);
        while(li.hasNext()) {
            System.out.println(li.next());
        }
        System.out.println("--------");
        //反向迭代器是Deque接口的
        //反向迭代器，因为不是继承于List接口的，所以需要类型转化。可以转化成Deque,也可以转化为LinkedList
        //因为可以反向迭代，所以LinkedList是个双向链表。
        Iterator <Integer> di = ((Deque<Integer>)l).descendingIterator(); //((LinkedList<Integer>)l).descendingIterator();
        while(di.hasNext()) {
            System.out.println(di.next());
        }

    }
}
