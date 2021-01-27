package org.formula.nio;

/**
 * @author krisjin
 * @date 2021/1/26
 */
public class Test {


    /**
     * Returns Integer corresponding to s, or null if s is null.
     *
     * @throws NumberFormatException if s is nonnull and
     *                               doesn't represent a valid integer
     */
    public static Integer parseInt(String s) {
        return (s == null) ? (Integer) null : 1133;

    }

    public static void main(String[] args) {

        System.out.println(parseInt(null));

//        System.out.println(parseInt("-1") + " " + parseInt(null) + " " + parseInt("1"));
//        System.out.println(parseInt("-1") + " " + parseInt(null) + " " + parseInt("1"));
//        t1();
    }


    public static void t1() {
        Object s = null;
        Integer i = (Integer) s;

//        Integer dd = Integer.parseInt(null);

        if (s == null) {
            Integer aa = (Integer) s;
            System.err.println(aa);
        }


    }


}
