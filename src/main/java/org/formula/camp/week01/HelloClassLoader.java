package org.formula.camp.week01;

import java.io.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class HelloClassLoader extends ClassLoader {

    private static final String CLZ_PATH = "/usr/local/gitrep/formula/src/main/java/org/formula/camp/week01/Hello.xlass";

    public static void main(String[] args) {
        try {
            HelloClassLoader helloClassLoader = new HelloClassLoader();
            Class<?> helloClz = helloClassLoader.findClass("Hello");

            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodHandle helloFunc = lookup.findVirtual(helloClz, "hello", MethodType.methodType(void.class));
            helloFunc.invoke(helloClz.newInstance());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] bytes = readClx();
            return defineClass(name, decode(bytes), 0, bytes.length);
        } catch (IOException ex) {
            throw new ClassNotFoundException(name);
        }
    }

    private byte[] readClx() throws IOException {
        File clxFile = new File(CLZ_PATH);
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream((int) clxFile.length());
             BufferedInputStream in = new BufferedInputStream(new FileInputStream(clxFile))) {
//            BufferedInputStream in = new BufferedInputStream(new FileInputStream(clxFile));
            int buf = 1024;
            byte[] buffer = new byte[buf];
            int len;

            while (-1 != (len = in.read(buffer, 0, buf))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        }
    }

    private byte[] decode(byte[] clazz) {
        byte[] decodeClazz = new byte[clazz.length];
        for (int i = 0; i < clazz.length; i++) {
            decodeClazz[i] = (byte) (255 - clazz[i]);
        }
        return decodeClazz;
    }
}
