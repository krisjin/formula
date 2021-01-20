package org.formula.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author krisjin
 * @date 2021/1/17
 */
public class ChannelTest {

    public static void main(String[] args) {
        channelTest();
    }

    public static void channelTest() {
        RandomAccessFile raf = null;
        try {
//            String t = "666666\n";
            //创建一个RandomAccessFile（随机访问文件）对象，
            raf = new RandomAccessFile("/usr/local/tools/a.txt", "rw");

            //通过RandomAccessFile对象的getChannel()方法。FileChannel是抽象类。
            FileChannel inChannel = raf.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);

            for (int i = 0; i < 30; i++) {
                byteBuffer.put((i + "").getBytes("UTF-8"));
            }

//            byteBuffer.put(t.getBytes("UTF-8"));
            byteBuffer.flip();
            inChannel.write(byteBuffer);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
