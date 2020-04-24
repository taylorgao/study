package com.gbs.collection.senior;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {

        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"a");
        hashMap.put(2,"b");
        hashMap.put(66,"c");


        int h;
        Object key;
        String s = "yab";
        key = s;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(hash);
        System.out.println(hash & 15);  // 11
        System.out.println(hash & 31);  // 27


//        System.out.println(hashMap.containsValue("b"));
//
//        System.out.println("-------for each-------  ");
//        hashMap.put(1,"aa");
//
//        for (Map.Entry<Integer,String> e:hashMap.entrySet()
//             ) {
//            System.out.println(e);
//        }
//
//        System.out.println("--------Iterator hashcode------");
//        Iterator<Map.Entry<Integer,String>> iterator = hashMap.entrySet().iterator();
//        while (iterator.hasNext())
//        {
//            System.out.println(iterator.next().getKey().hashCode());
//        }
//        System.out.println("entrySet.size : " + hashMap.entrySet().size());
//
//        System.out.println("-------for each-------");
//        for (Integer key:hashMap.keySet()
//        ) {
//            System.out.println(key);
//        }
//
//        System.out.println("--------Iterator------");
//        Iterator<Integer> iterator1 = hashMap.keySet().iterator();
//        while (iterator1.hasNext())
//        {
//            Integer key = iterator1.next();
//            System.out.println(key + ":" + hashMap.get(key));
//        }

        //System.out.println(hashMap);
    }
}
