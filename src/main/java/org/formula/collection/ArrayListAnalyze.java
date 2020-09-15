package org.formula.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList 剖析
 * 总结：
 * 对于ArrayList而言，需要注意的有一下几点：
 * 1.ArrayList是基于数组方式实现，无容量的限制。
 * 2.ArrayList在执行插入元素时可能要扩容，在删除元素时并不会减小数组的容量（如希望相应的缩小数组容量，可以调用ArrayList 的trimToSize）,
 * 在查找元素时要遍历数组，对于非null的元素采用equals的方式寻找；
 * 3.ArrayList是非线程安全的。
 *
 * @see java.util.List
 * User: krisibm@163.com
 * Date: 2016/10/19
 */
public class ArrayListAnalyze {


    public static void main(String[] args) {
        //创建一个ArrayList对象实例，可以执行初始容量的大小，在构造函数中初始化了Object数组,并将
        //此数组赋给了当前实例的elementData属性，由此可以知道ArrayList是使用数组的方式来存放对象。
        List arrayList = new ArrayList();

        arrayList.add("name");
        arrayList.add("age");
        arrayList.add("sex");

        long time = System.nanoTime();
        arrayList.remove("1111");
        System.out.println("ArrayList remove(Object) costTime: " + (System.nanoTime() - time) + " ns");

        time = System.nanoTime();
        arrayList.remove(0);
        System.out.println("ArrayList remove(index) costTime: " + (System.nanoTime() - time) + " ns");

        //判断对象是否存在，做法是遍历整个ArrayList已有对象，如果为对象为null,则直接判断是否null
        //如果对象不为null，则通过判断equals和元素是否相等。
        boolean isContain = arrayList.contains("sex");
        System.out.println(isContain);


    }


}
