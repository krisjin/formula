package org.masksalt.collection;

import java.util.Stack;

/**
 * Stack继承于Vector,在其基础上实现了Stack所要求的后进先出（LIFO）的弹出及压入操作，其提供了
 * 主要的push、pop、peek三个主要方法:
 * push是通过Vector的addElement来完成。
 * pop通过peek来获取元素，并同时删除数组的最后一个元素。
 * peek操作通过获取当前Object数组的大小，并获取数组上的最后一元素
 * <p/>
 * User: shijingui
 * Date: 2016/10/23
 */
public class StackAnalyze {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("push");
        stack.pop();
        stack.peek();


    }
}
