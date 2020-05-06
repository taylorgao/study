package com.gbs.collection;

import com.gbs.demo.Student;

import java.util.*;

public class TypeTransStudy {
    public static void main(String[] args) {

        // equal() hashcode()
        Student s1 = new Student(19,"sam",13);
        Student s2 = new Student(19,"sam",13);
        System.out.println("equal:"  + s1.equals(s2));
        // test set
        Set<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        System.out.println("set size =  " + set.size());  // 2 if you haven't overwrite hashcode of Student.
        // test map key
        Map<Student,Integer> map = new HashMap<>();
        map.put(s1,13);
        map.put(s2,14);
        System.out.println("map size = " + map.size()); // 2 if you haven't overwrite hashcode of Student.
        map.forEach((key,value) -> System.out.println(key + " : " + value));
        for (Map.Entry<Student,Integer> item:map.entrySet()
             ) {
            System.out.println(item.getKey() + " ::: " + item.getValue());
        }

        System.out.println("-----Arraylist----");
        // ArrayList subList
        ArrayList<Integer> arrayList = new ArrayList(3);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(3);
        System.out.println(" arraylist.sublist");
        List<Integer> integers = arrayList.subList(1, 3);
        System.out.println(integers);
        System.out.println( "ArrayList to Array" );
        Integer[] intArr = arrayList.toArray(new Integer[0]);
        for (Integer tmp : intArr)
            System.out.println(tmp);
        System.out.println("Array ot Arraylist");
        List<Integer> newAarryList = Arrays.asList(intArr);
        newAarryList.forEach((Integer) ->System.out.println(Integer));
        System.out.println(" ArrayList to Set 去重");
        // 利用set去重
        Set<Integer> set1 = new HashSet<>(arrayList);
        set1.forEach((Integer)  -> System.out.println(Integer));

        System.out.println("----Array-----");
        //Array;
        String[] strArr = {"abd","bbc"};
        List<String> strList = Arrays.asList(strArr);
        System.out.println(strList);
        strArr[0] = "xyz";
        System.out.println(strList);

    }
}
