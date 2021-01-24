### NIO-channel简介



一个channel(通道)表示一个连接，一个channel可以表示一个底层的文件描述符，比如有硬件设备、文件、网络套接字，或者是执行IO的读写操作。在Java NIO中有不同的Channel实现。



#### 有哪些Channel实现



NIO中主要的channel实现如下：



- FileChannel：文件通道，用于文件数据的读写。
- DatagramChannel：数据报通道，可以通过UDP协议读取网络中的数据。
- SocketChannel：套接字通道，用于Socket套接字TCP网络连接的数据读写。
- ServerSocketChannel：服务器监听通道，可以监听TCP连接请求，对每个监听进来的连接都创建一个SocketChannel套接字通道。



#### FileChannel示例



```java
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
```



要注意的是在ByteBuffer的模式切换，新创建的ByteBuffer模式是写模式。如果这时想从通道读数据，可以作为参数传进去，从通道读取的数据写入到ByteBuffer。

在往通道写数据时，需要将ByteBuffer切换为读模式，作为参数传入输出Channel，从ByteBuffer读取数据写入输出Channel。









