package org.formula.camp.week01;

import java.io.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class T2 extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = System.getProperty("user.dir") + "/src/main/java/org/formula/camp/week01/Hello.xlass";

        File file = new File(path);
        int length = (int) file.length();
        byte[] bytes = new byte[length];
        try {
            new FileInputStream(file).read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }

        for (int index = 0; index < bytes.length; index++) {
            bytes[index] = (byte) (255 - bytes[index]);
        }

        return defineClass(name, bytes, 0, length);
    }


    public static void main(String[] args) {
        try {
            T2 helloClassLoader = new T2();
            Class<?> helloClz = helloClassLoader.findClass("Hello");

            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodHandle helloFunc = lookup.findVirtual(helloClz, "hello", MethodType.methodType(void.class));
            helloFunc.invoke(helloClz.newInstance());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
