package org.formula.nio;


import org.formula.io.IOUtil;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;


public class NIOSendClient {
    private Charset charset = Charset.forName("UTF-8");

    public void sendFile() {
        try {
            String sourcePath = "/system.properties";
            String srcPath = IOUtil.getResourcePath(sourcePath);
            System.out.println("srcPath=" + srcPath);

            String destFile = "system.dest.properties";
            System.out.println("destFile=" + destFile);

            File file = new File(srcPath);
            if (!file.exists()) {
                System.out.println("文件不存在");
                return;
            }

            FileChannel fileChannel = new FileInputStream(file).getChannel();

            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.socket().connect(new InetSocketAddress("127.0.0.1", 9999));
            socketChannel.configureBlocking(false);
            System.out.println("Client 成功连接服务端");

            while (!socketChannel.finishConnect()) {
                //不断的自旋、等待，或者做一些其他的事情
            }

            //文件名称
            ByteBuffer fileNameByteBuffer = charset.encode(destFile);

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //发送文件名称长度
            int fileNameLen = fileNameByteBuffer.capacity();
            buffer.putInt(fileNameLen);
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
            System.out.println("Client 文件名称长度发送完成:" + fileNameLen);

            //发送文件名称
            socketChannel.write(fileNameByteBuffer);
            System.out.println("Client 文件名称发送完成:" + destFile);
            //发送文件长度
            buffer.putLong(file.length());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
            System.out.println("Client 文件长度发送完成:" + file.length());


            //发送文件内容
            System.out.println("开始传输文件");
            int length = 0;
            long progress = 0;
            while ((length = fileChannel.read(buffer)) > 0) {
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
                progress += length;
                System.out.println("| " + (100 * progress / file.length()) + "% |");
            }

            if (length == -1) {
                IOUtil.closeQuietly(fileChannel);
                socketChannel.shutdownOutput();
                IOUtil.closeQuietly(socketChannel);
            }
            System.out.println("======== 文件传输成功 ========");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        NIOSendClient client = new NIOSendClient();
        client.sendFile();
    }

}
