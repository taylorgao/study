package com.gbs.jvm;

/*
* String.intern()是一个Native方法，底层调用C++的 StringTable::intern方法实现。
* 当通过语句str.intern()调用intern()方法后，JVM 就会在当前类的常量池中查找是否存在与str等值的String，
* 若存在则直接返回常量池中相应Strnig的引用；若不存在，则会在常量池中创建一个等值的String，
* 然后返回这个String在常量池中的引用。
 * */
public class InternTest {
    public static void main(String[] args) {
        String s = "good";
        String t = "good";
        String k = "go";
        k = k + "od";
        String w = new String("good");
        System.out.println(s == t);
        System.out.println(s == k.intern());
        System.out.println(s == w.intern());
    }
}
