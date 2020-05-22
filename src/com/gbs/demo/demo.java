package com.gbs.demo;

import java.math.BigDecimal;

public class demo {
    public static void main(String[] args) {
        assert(-11 == Math.round(-11.5));  //result:11  add 0.5 then floor

        short s1 = 1;
        s1 = (short)(s1 + 1);  //s1 = s1 + 1 报错，因为返回int
        s1 += 1; //这个没问题

        double d = 3.4;
        float f = 3.4f;  //或者f = (float)3.4
        BigDecimal bd = new BigDecimal(3.4); //不要用这个构造重载，不稳定
        System.out.println(bd);
        BigDecimal bds = new BigDecimal("3.4"); //用这个
        System.out.println(bds);


        //java只有值传递，没有引用传递
        int a = 0;
        f1(a);
        assert a == 0;

        String s = "abc";
        f2(s);
        assert s.equals("abc");
    }

    static void f1(int a)
    {
        a = a + 1;
    }

    static void f2(String s)
    {
        s = s + " appended";
    }
}
