package org.formula;

/**
 * Java中的String字符使用双引号定义的，
 *
 * @author krisjin
 * @date 2020/11/22
 */
public class StringDemo {

    public static void main(String[] args) {
        test1();

    }

    /**
     *
     */
    public static void test1() {
        String hello = "Hello", lo = "lo";
        System.out.println((hello == "Hello"));
        System.out.println(Other.hello == hello);
        System.out.println(Other.hello == hello);
        System.out.println(hello == ("Hel" + "lo"));
        System.out.println(hello == ("Hel" + lo));
        System.out.println(hello == ("Hel" + lo).intern());
        System.out.println(hello == new String("hello"));


    }

    /**
     * String传参不可变
     */
    public static String test2(String s) {
        s += ",abc";
        return s;
    }

    /**
     * StringBuilder可变
     *
     * @param sb
     * @return
     */
    public static StringBuilder test4(StringBuilder sb) {
        return sb.append(",abc");
    }


    /**
     * 测试final关键字的不可变性
     */
    public static void test3() {
        final int[] i1 = {1, 2, 3};
        int[] i2 = {3, 2, 1};
//        i1 = i2; //编译器报错，final修饰的变量引用不可变，但可以修改数组中的元素

        i1[0] = 0;//修改数组元素值
    }

    static class Other {
        static String hello = "Hello";

        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
    }

    static class StrTest {
        String s = "abc";
        String s1 = "abc";

    }
}
