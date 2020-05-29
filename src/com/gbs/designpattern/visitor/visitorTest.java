package com.gbs.designpattern.visitor;

import com.gbs.designpattern.visitor.entry.Apple;
import com.gbs.designpattern.visitor.entry.Fruit;
import com.gbs.designpattern.visitor.entry.Orange;

import java.util.ArrayList;
import java.util.List;

public class visitorTest {
    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<Fruit>();
        list.add(new Apple());
        list.add(new Orange());

        int ttl = 0;
        for(Fruit fruit:list)
        {
            //overload 函数只能安装声明的类型进行匹配函数，不能按照实际类型。
            //visitor pattern可以有效解决这个问题。
            ttl += Visitor.Sell(fruit);
        }

        System.out.println(ttl);

        //------- visitor pattern
        ttl = 0;
        for(Fruit fruit:list)
        {
            ttl += fruit.sell();
        }

        System.out.println(ttl);


    }
}
