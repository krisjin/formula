package org.formula.collection;

import java.util.Vector;

/**
 * Vector是基于Object数组的方式实现的。
 * Vector是基于Synchronized实现的线程安全的ArrayList,但在插入元素时容量扩充的机制和ArrayList稍有不同，并可
 * 通过传入capacityIncrement来控制容量的扩充。
 * User: krisin
 * Date: 2016/10/23
 */
public class VectorAnalyze {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add("name");
    }
}
