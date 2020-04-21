package com.gbs.collection.basic.linkedlist;


public class LinkedListTest {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rtn = null,rtnCur = null;
        ListNode a,b;
        a = l1;
        b = l2;
        while(a != null || b != null) {
            while (a != null && (b == null || a.val <= b.val)) {
                if (rtn == null) {
                    rtn = new ListNode(a.val);
                    rtnCur = rtn;
                } else {
                    rtnCur.next = new ListNode(a.val);
                    rtnCur = rtnCur.next;
                }
                ;
                a = a.next;
            }

            while (b != null && (a == null || b.val < a.val)) {
                if (rtn == null) {
                    rtn = new ListNode(b.val);
                    rtnCur = rtn;
                } else {
                    rtnCur.next = new ListNode(b.val);
                    rtnCur = rtnCur.next;
                }
                ;
                b = b.next;
            }
        }
        return rtn;
    }



    public static void main(String[] args) {
        LinkedListTest  llt = new LinkedListTest();
        int[] a = {1,3,5,7,8};
        int[] b = {2,3,7,9};
        ListNode l1 = ListNode.creat(a);
        ListNode l2 = ListNode.creat(b);
        ListNode rtn = llt.mergeTwoLists(l1,l2);
        System.out.println(ListNode.toPrint(rtn));
    }
}
