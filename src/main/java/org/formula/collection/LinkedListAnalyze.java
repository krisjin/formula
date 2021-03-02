package org.formula.collection;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * LinkedList是List的实现，LinkedList是基于双向链表机制，所谓双向链表机制就是集合中的每个元素都知道其前一个元素及其后后一个
 * 元素的位置。在LinkedList中，以一个内部的Entry类来代表集合中的元素，元素的值赋给element属性，Entry中的next属性指向元素的
 * 后一个元素，Entry中的previous属性指向元素的前一个位置，基于这样的机制可以快速实现集合中元素的移动。
 * <p/>
 * 总结：
 * 1.LinkedList是基于双向链表实现机制
 * 2.LinkedList在插入元素时，须创建一个Node对象并追加到链表末尾
 * 3.LinkedList是非线程安全的。
 * <p/>
 * <p/>
 * User: krisin
 * Date: 2016/10/22
 */
public class LinkedListAnalyze {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.add("firstName");
        linkedList.add("lastName");
        linkedList.add("country");
        linkedList.add("address");

        //获取第一个元素
        Object firstEle = linkedList.getFirst();
        Object lastEle = linkedList.getLast();
        linkedList.remove(2);

        Iterator inter = linkedList.iterator();

//        linkedLis

//        linkedList.


    }
}
