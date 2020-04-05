package com.gbs.thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    public static class Person{
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "name = " + name + "; age = " + age;
        }
    }

    public static void main(String[] args) {
        Person person = new Person(44,"Taylor");
        //此处不会new一个新的person,只是引用指向。
        AtomicReference<Person> atomicReferencePerson = new AtomicReference<>(person);
        //测试上条注释
        person.age = 45;
        System.out.println(person);
        System.out.println(atomicReferencePerson.get());

        System.out.println("原子操作测试");
        //原子操作
        Person person1 = new Person(46,"T.G.");
        //改了应用指向
        atomicReferencePerson.compareAndSet(person,person1);
        System.out.println(atomicReferencePerson.get());

    }
}
