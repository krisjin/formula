package org.formula.nio;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author krisjin
 * @date 2021/1/26
 */
public class DD {



    public static void main(String[] args) {
        Map map = new IdentityHashMap<>();
        map.put(1, "Hello");
        map.putIfAbsent(1, "World");
        print(map.get(1));
        print(map.size());
        Integer i =1024;
        map.put(i, "A");
        map.putIfAbsent(1024, "B");
        print(map.get(i));
        print(map.size());


    }

    private static void print(Object object) {
        System.out.print(object + " ");


//        IdentityHashMap map = new IdentityHashMap<>();
//
//        map.put(new String("aaa"),"aaa");
//        map.put(new String("aaa"),"ccc");
//        System.out.println(map.get("abc"));
    }
}
