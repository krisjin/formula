package org.formula.nio;

import java.util.Random;

/**
 * @author krisjin
 * @date 2021/1/26
 */
public class TT {

    public static void main(String[] args) {

    }

    public static void t(String[] args) {
        Random rnd = new Random();
        boolean toBe = rnd.nextBoolean();
        Number result = (toBe || !toBe) ?
                new Integer(3) : new Float(1);
        System.out.println(result);
    }
}
