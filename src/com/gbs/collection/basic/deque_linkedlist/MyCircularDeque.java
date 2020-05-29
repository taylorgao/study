package com.gbs.collection.basic.deque_linkedlist;
/*
*
设计实现双端队列。
你的实现需要支持以下操作：

MyCircularDeque(k)：构造函数,双端队列的大小为k。
insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
isEmpty()：检查双端队列是否为空。
isFull()：检查双端队列是否满了。
示例：

MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
circularDeque.insertLast(1);			        // 返回 true
circularDeque.insertLast(2);			        // 返回 true
circularDeque.insertFront(3);			        // 返回 true
circularDeque.insertFront(4);			        // 已经满了，返回 false
circularDeque.getRear();  				// 返回 2
circularDeque.isFull();				        // 返回 true
circularDeque.deleteLast();			        // 返回 true
circularDeque.insertFront(4);			        // 返回 true
circularDeque.getFront();				// 返回 4
*
*
* */
public class MyCircularDeque {
    Node front,last;

    /** Initialize your data structure here. Set the size of the deque_linkedlist to be k. */
    public MyCircularDeque(int k) {
        //一共开辟k + 1个节点空间，last指针总是指向空节点。这样就有一个节点无法使用。
        front = new Node();
        last = front;
        for(int i = 0; i < k; i ++)
        {
            Node tmp = new Node();
            tmp.pre = last;
            last.next = tmp;
            last = last.next;
        }
        last.next = front;
        front.pre = last;
        last = front; //此时为空；
    }

    /** Adds an item at the front of Deque. Return true if the Calulate is successful. */
    public boolean insertFront(int value) {
        //按照队列规则，队列满时，last指向最后一个空节点，不能继续插入。
        if(last.next == front)
            return false;
        front = front.pre;
        front.value = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the Calulate is successful. */
    public boolean insertLast(int value) {
        if(last.next == front)
            return false;
        last.value = value;
        last = last.next;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the Calulate is successful. */
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        front = front.next;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the Calulate is successful. */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        last = last.pre;
        return true;
    }

    /** Get the front item from the deque_linkedlist. */
    public int getFront() {
        if(isEmpty())
            return -1;
        return front.value;
    }

    /** Get the last item from the deque_linkedlist. */
    public int getRear() {
        if(isEmpty())
            return -1;
        return last.pre.value;
    }

    /** Checks whether the circular deque_linkedlist is empty or not. */
    public boolean isEmpty() {
        return front == last;
    }

    /** Checks whether the circular deque_linkedlist is full or not. */
    public boolean isFull() {
        return last.next == front;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));			        // 返回 true
        System.out.println(circularDeque.insertLast(2));			        // 返回 true
        System.out.println(circularDeque.insertFront(3));			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
        System.out.println(circularDeque.getRear());  				// 返回 2
        System.out.println(circularDeque.isFull());				        // 返回 true
        System.out.println(circularDeque.deleteLast());			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 返回 true
        System.out.println(circularDeque.getFront());				// 返回 4
    }
}

class Node{
    int value;
    Node pre;
    Node next;
}
