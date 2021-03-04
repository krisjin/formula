package org.formula.nio.base;

import java.nio.channels.SelectionKey;

/**
 * @author krisjin
 * @date 2021/1/25
 */
public class SelectorTest {

    public static void main(String[] args) {

    }

    public static void tt() {

        //选择器监控通道的IO事件类型
        int connect = SelectionKey.OP_CONNECT;
        int accept = SelectionKey.OP_ACCEPT;
        int read = SelectionKey.OP_READ;
        int write = SelectionKey.OP_WRITE;
    }
}
