package org.formula.nio.base;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SocketChannel;

/**
 * @author krisjin
 * @date 2021/1/24
 */
public class SocketChannelTest {


    public static void main(String[] args) {

    }

    public static void socketChannel() throws IOException {
        //获得一个通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞模式
        socketChannel.configureBlocking(true);
        //发起连接
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8888));

        //在阻塞模式下可能还没有建立连接，一直不停的自旋
        while (!socketChannel.finishConnect()) {

        }


        String newData = "abcde" + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.put(newData.getBytes());

        buf.flip();
        while (buf.hasRemaining()) {
            socketChannel.write(buf);
        }


        ByteBuffer buf1 = ByteBuffer.allocate(48);
        int bytesRead = socketChannel.read(buf1);

        //输出结束标识
        socketChannel.shutdownOutput();
        //关闭套接字
        socketChannel.close();

        //打开一个数据报通道
        DatagramChannel datagramChannel = DatagramChannel.open();
        //非阻塞配置
        datagramChannel.configureBlocking(false);
        //绑定接收数据的端口
        datagramChannel.socket().bind(new InetSocketAddress(9000));


        ByteBuffer buf2 = ByteBuffer.allocate(48);
        buf2.clear();
        datagramChannel.receive(buf2);


        String strData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf3 = ByteBuffer.allocate(48);
        buf3.put(newData.getBytes());
        //切换读模式
        buf3.flip();
        datagramChannel.send(buf, new InetSocketAddress("127.0.0.1", 9000));
    }
}
