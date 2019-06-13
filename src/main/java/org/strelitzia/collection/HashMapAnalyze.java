package org.strelitzia.collection;

import java.util.HashMap;

/**
 * HashMap是非线程安全的。
 * HashMap 采用数组的方式存储Key,Value构成的Entry对象，无容量限制。
 * HashMap基于Key hash 寻找Entry对象存放到数组的位置，对于Hash冲突采用链表的方式解决。
 * HashMap在插入元素时可能要扩大数组的容量，在扩大容量时须要重新计算hash，并复制对象到新的数组中。
 * <p/>
 * <p/>
 * User: krisibm@163.com
 * Date: 2016/10/23
 */
public class HashMapAnalyze extends HashMap {

    /**
     * 将loadFactor设置为0.75，threshold设置12，并创建一个大小为16的Entry对象数组。
     * 可通过调用HashMap的另外两个构造器来控制初始的容量值及loadFactor,至于创建的Entry对象数组的大小并非传入的初始容量值，
     * 而是采用如下方法来决定：
     */
    public HashMapAnalyze() {
        super();
    }

    /**
     * 对可以进行hashcode 在做hash和按位与操作找到其对应的存储位置。
     * @param key
     * @return
     */
    public Object getValue(Object key) {
        return get(key);
    }
}
