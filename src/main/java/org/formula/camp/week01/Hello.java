package org.formula.camp.week01;

/**
 * 自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后
 * 自己分析一下对应的字节码，有问题群里讨论。
 */
public class Hello {
    public static void main(String[] args) {
        int i = 5;
        double d = 6;
        short s = 7;
        long l = 8;

        for (int index = 0; index < i; ++index) {
            d = d / i;
            s = (short) (s * i);
            l = l + i;
            i = i - 1;
        }
        if (i < d) {
            System.out.println("i < d");
        }
    }
}
