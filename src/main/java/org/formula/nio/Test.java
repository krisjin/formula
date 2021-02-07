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

//        System.out.println(parseInt(null));
        ddd();
//        System.out.println(parseInt("-1") + " " + parseInt(null) + " " + parseInt("1"));
//        System.out.println(parseInt("-1") + " " + parseInt(null) + " " + parseInt("1"));
//        t1();
    }


    public static void t1() {
        Object s = null;
        Integer i = (Integer) s;
        if (s == null) {
            Integer aa = (Integer) s;
            System.err.println(aa);
        }
    }


    public static void ddd() {
        String aa = "eature_tpl (2).json";
//        aa = aa.replaceAll("\\s+", "").replaceAll("\\(", "").replaceAll("\\)", "");

        aa =aa.substring(aa.lastIndexOf("."));

        System.err.println(aa);
    }


}
