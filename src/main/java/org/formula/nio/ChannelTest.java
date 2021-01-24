package org.formula.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
        fileChannelTest();
//        writeTest();
    }


    public static void writeTest() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("/usr/local/tools/b.txt");
            ByteBuffer buffer1 = ByteBuffer.wrap("abcdef".getBytes("UTF-8"));
            ByteBuffer buffer2 = ByteBuffer.wrap("123456".getBytes("UTF-8"));

            FileChannel fileChannel = fos.getChannel();

            fileChannel.write(buffer1);

            buffer2.position(3);
            buffer2.limit(5);

            fileChannel.position(3);
            fileChannel.write(buffer2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileChannelTest() {
        RandomAccessFile raf = null;
        FileChannel fileChannel = null;
        try {
            raf = new RandomAccessFile("/usr/local/tools/a.txt", "rw");
            //创建一个RandomAccessFile对象，传入一个文件路径，支持读写模式

            //获取文件通道
            fileChannel = raf.getChannel();

            //创建字节缓冲区，用于读取数据和写入数据
            ByteBuffer buffer = ByteBuffer.allocate(48);

            //从文件读取输出控制台
            while (fileChannel.read(buffer) != -1) {
                buffer.flip();
                String str = new String(buffer.array(), buffer.position(), buffer.limit(), "utf-8");
                System.err.print(str);
                buffer.clear();
            }

            //写数据
            buffer.put("\n新信息！！!".getBytes("UTF-8"));
            //切换读模式
            buffer.flip();
            //通道写数据
            fileChannel.write(buffer);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
                fileChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
