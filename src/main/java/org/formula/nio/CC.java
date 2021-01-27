package org.formula.nio;

/**
 * @author krisjin
 * @date 2021/1/26
 */
public class CC {


    public static Integer parseInt(String s) {
        return (s == null) ? (Integer) null : Integer.parseInt(s);
    }

    public static void main(String[] args) {

        Integer.parseInt(null);

    }
}
