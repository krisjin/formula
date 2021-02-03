package org.formula.nio;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author krisjin
 * @date 2021/1/26
 */
public class TT {

    public static void main(String[] args) {
        t();
    }

    public static void t() {
        Random rnd = new Random();
        boolean toBe = rnd.nextBoolean();
        Number result = (toBe || !toBe) ? new Integer(3) : new Float(1);
        System.out.println(result);
    }


    public static void tt(String[] args) {
        Map map = new IdentityHashMap<>();
        map.put(1, "Hello");
        map.putIfAbsent(1, "World");
        print(map.get(1));
        print(map.size());
        Integer i = 1024;
        map.put(i, "A");
        map.putIfAbsent(1024, "B");
        print(map.get(i));
        print(map.size());


    }


    private static void print(Object object) {
        System.out.print(object + " ");
    }

    public static Integer parseInt(String s) {
        return (s == null) ? (Integer) null : Integer.parseInt(s);
    }
}
