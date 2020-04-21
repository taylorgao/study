package com.gbs.collection.basic.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode creat(int[] a)
    {
        ListNode rtn = null, rtnCur = null;
        for(int i = 0; i < a.length; i ++)
        {
            if(rtn == null)
            {
                rtn = new ListNode(a[i]);
                rtnCur = rtn;
            }
            else {
                rtnCur.next = new ListNode(a[i]);
                rtnCur = rtnCur.next;
            }
        }
        return rtn;
    }

    public static String toPrint(ListNode ln)
    {
        String rtn = "";
        ListNode a = ln;
        while(a != null)
        {
            if(rtn != "")
                rtn = rtn + ",";
            rtn = rtn + a.val;
            a = a.next;
        }
        return rtn;
    }
}
