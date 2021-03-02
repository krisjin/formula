package org.formula.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 是线程安全的HashMap实现。
 * <p/>
 * User: krisin
 * Date: 2016/10/23
 */
public class ConcurrentHashMapAnalyze {
    /**
     * 创建一个Map实现，初始大小16，loadFactor0.75,concurrencyLevel为16
     */
    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    public static void main(String[] args) {
        test();
    }


    public Object put(Object key, Object value) {
        return concurrentHashMap.put(key, value);
    }

    public static void test() {

        /**
         * Mask value for indexing into segments. The upper bits of a
         * key's hash code are used to choose the segment.
         */
        final int segmentMask;

        /**
         * Shift value for indexing within segments.
         */
        final int segmentShift;
        int sshift = 0;
        int ssize = 1;
        while (ssize < 16) {
            ++sshift;
            ssize <<= 1;
        }
        segmentShift = 32 - sshift;
        segmentMask = ssize - 1;

    }
}
