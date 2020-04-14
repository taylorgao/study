package com.gbs.demo;

import java.util.ArrayList;
import java.util.List;
/*
* 泛型 问号的作用
* 生命泛型对象变量时，？确定了一个可以接受的元素的范围
* */
class A1{}
class A2{}
class A3{}
class A4{}

class B1 extends A1{}
class B2 extends A1{}
class B3 extends A3{}
class B4 extends A4{}

class C1 extends B2{
    @Override
    public String toString() {
        return "I am B2";
    }
}
class C2 extends B2{
    @Override
    public String toString() {
        return "I am C2";
    }
}
class C3 extends B3{}

class D1 extends C1{}
class D2 extends C2{
    @Override
    public String toString() {
        return "I am D2";
    }
}

class E1 extends D1{}
class E2 extends D1{}
class E3 extends D2{

}
class E4 extends D2{}

public class Generics {



    public static void main(String args[]) {
        /********************************************
         * 此处 extends 表示 有上界的统配符 ?，上界为  C2
         * 由此定义的引用 listUpper可以作为
         * 接下来的 7 种 子泛型类型的 ArrayList 的引用来使用。
         **********************************************/
        List<? extends C2> listUpper;//统配符 ? 的上界为  C2
        listUpper = new ArrayList<C2>();//能存储 C2 D2 E3 E4
        listUpper = new ArrayList<D2>();//能存储 D2 E3 E4
        listUpper = new ArrayList<E3>();
        listUpper = new ArrayList<E4>();
        /*************************************************
         * super 表示有下界的统配符 ? ，下界为  C2 ，
         * 由此定义的引用 listLower 可以作为
         * 接下来的 7 种 子泛型类型的 ArrayList 的引用来使用。
         ***************************************************/
        List<? super C2> listLower;
        listLower = new ArrayList<A1>(); //能存储 A1 B1 B2 C1 C2    D1 D2 E1 E2 E3 E4
        listLower = new ArrayList<B2>(); //能存储 B2       C1 C2    D1 D2 E1 E2 E3 E4
        listLower = new ArrayList<C2>();// 能存储 C2 D2 E3 E4

        listLower.add(new C2());
        listLower.add(new D2());


        System.out.println(listLower);

    }
}
