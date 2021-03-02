package org.formula.base;

/**
 * java移位运算符
 * <<  : 左移运算符，num << 1,相当于num乘以2
 * >>  : 右移运算符，num >> 1,相当于num除以2
 * >>> : 无符号右移，忽略符号位，空位都以0补齐
 * User: krisin
 * Date: 2016/10/23
 */
public class ShiftOperator {

    public static void main(String[] args) {
        System.out.println(1 << 4);
        System.out.println(2 >> 5);

    }
}
