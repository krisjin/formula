### NIO-channel简介



一个channel(通道)表示一个连接，一个channel可以表示一个底层的文件描述符，比如有硬件设备、文件、网络套接字，或者是执行IO的读写操作。在Java NIO中有不同的Channel实现。



![image-20210124171420406](/Users/shijingui/Library/Application Support/typora-user-images/image-20210124171420406.png)



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





#### SocketChannel套接字通道



NIO中的SocketChannel是一个连接到TCP网络套接字的通道。可以通过以下2种方式创建SocketChannel，打开一个SocketChannel并连接到互联网上的某台服务器，一个新连接到达ServerSocketChannel时，会创建一个SocketChannel。



ServerSocketChannel用于服务器端，SocketChannel同时用于服务端和客户端，换句话说，对应一个连接，两端都有一个负责传输的SocketChannel传输通道。



SocketChannel支持阻塞和非阻塞模式，通过socketChannel.configureBlocking(true)设置，默认是非阻塞的。在阻塞模式下, Socket Channel通道的 connect、read、 write操作，都是同步的和阻塞式的，在效率上与Java旧的OIO的面向流的阻塞式读写操作相同。



Java NIO中的 ServerSocketChannel 是一个可以监听新进来的TCP连接的通道, 就像标准IO中的ServerSocket一样。ServerSocketChannel类在 java.nio.channels包中。



**创建连接通道**



```java
//获得一个通道
SocketChannel socketChannel = SocketChannel.open();
//设置非阻塞模式
socketChannel.configureBlocking(true);
//发起连接
socketChannel.connect(new InetSocketAddress("127.0.0.1", 8888));

//在阻塞模式下可能还没有建立连接，一直不挺的自旋
while (!socketChannel.finishConnect()) {

}
```



**SocketChannel写数据**



```java
String newData = "abcde" + System.currentTimeMillis();

ByteBuffer buf = ByteBuffer.allocate(48);
buf.put(newData.getBytes());

buf.flip();
while(buf.hasRemaining()) {
    socketChannel.write(buf);
}
```



**SocketChannel读取数据**



```java
ByteBuffer buf1 = ByteBuffer.allocate(48);
int bytesRead = socketChannel.read(buf1);
```

读取是异步的，因此我们必须检查read的返回值，以便判断当前是否读取到了数据。 read()方法的返回值，是读取的字节数。如果返回-1，那么表示读取到对方的输出结束标志，对方已经输出结束，准备关闭连接。实际上在读取数据时还是需要Selector选择器。





**关闭SocketChannel**



在关闭 Socketchannel传输通道前，如果传输通道用来写入数据，建议调用一次 shutdownOutput终止输出方法，向对方发送一个输出的结束标志-1。然后调用 socketchannel.close()方法，关闭套接字连接。



```java
//输出结束标识
socketChannel.shutdownOutput();
//关闭套接字
socketChannel.close();
```







#### DatagramChannel数据报通道

NIO中的DatagramChannel是一个能收发UDP包的通道。因为UDP是无连接的网络协议，所以不能像其它通道那样读取和写入。它发送和接收的是数据包。使用 DatagramChannel数据报通道来处理UDP协议的数据传输。



**打开通道**



打开的 DatagramChannel可以在UDP端口9000上接收数据包

```java
//打开一个数据报通道
DatagramChannel datagramChannel = DatagramChannel.open();
//非阻塞配置
datagramChannel.configureBlocking(false);
//绑定接收数据的端口
datagramChannel.socket().bind(new InetSocketAddress(9000));
```



**从数据报通道读取数据**



可以从DatagramChannel通道读取数据，和前面的 Socketchannel的读取方式不同，不是调用read方法，而是调用receive( Byte Bufferbuf)方法将数据从 Datagramchannel读入，再写入到ByteBuffer缓冲区中。

```java
ByteBuffer buf2 = ByteBuffer.allocate(48);
buf2.clear();
datagramChannel.receive(buf2);
```



**写数据到数据报通道**



向 DatagramChannel发送数据，和向 SocketChannel通道发送数据的方法也是不同的。这里不是调用 write方法,而是调用send方法。

```java
String strData = "New String to write to file..." + System.currentTimeMillis();

ByteBuffer buf3 = ByteBuffer.allocate(48);
buf3.put(newData.getBytes());
//切换读模式
buf3.flip();
datagramChannel.send(buf, new InetSocketAddress("127.0.0.1", 9000));
```

UDP是面向非连接的协议，因此，在调用send方法发送数据的时候，需要指定接收方的地址(IP和端口)。

