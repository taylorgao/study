package com.gbs.collection.basic.generic;

public class GenericTest {
    /*
    * 为什么定义返回类型会有两个T
    * <T>代表方法是泛型方法，必须写，否则报错
    * T代表方法的返回值类型
    * */
    public static <T> T test(T x)
    {
        return x ;
    }

    public static void main(String[] args) {
        String s = test("abc");
        System.out.println(s);
    }
}
