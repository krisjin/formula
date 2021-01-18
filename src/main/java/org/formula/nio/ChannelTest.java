package org.formula.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author krisjin
 * @date 2021/1/17
 */
public class ChannelTest {


    public static void main(String[] args) {

    }


    public static void channelTest() {

        RandomAccessFile raf = null;
        try {
            //创建一个RandomAccessFile（随机访问文件）对象，
            raf = new RandomAccessFile("D:\\test.txt", "rw");

            //通过RandomAccessFile对象的getChannel()方法。FileChannel是抽象类。
            FileChannel inChannel = raf.getChannel();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
