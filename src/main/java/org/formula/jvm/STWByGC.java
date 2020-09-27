package org.formula.jvm;

import java.util.HashMap;

/**
 * -Xmx512m -Xms512m -XX:+UseSerialGC -Xloggc:/usr/local/test/gc.log -XX:+PrintGCDetails
 */
public class STWByGC {

    public static class SampleThread implements Runnable {
        HashMap map = new HashMap<>();

        public void run() {
            try {
                while (true) {
                    if (map.size() * 512 / 1024 / 1024 >= 400) {
                        map.clear();
                    }
                    byte[] bytes;
                    for (int i = 0; i < 100; i++) {
                        bytes = new byte[512];
                        map.put(System.nanoTime(), bytes);
                    }
                    Thread.sleep(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class PrintTimeThread implements Runnable {
        public static final long st = System.currentTimeMillis();

        public void run() {
            try {
                while (true) {
                    long end = System.currentTimeMillis() - st;
                    System.out.println(end / 1000 + " ." + end % 1000);
                    Thread.sleep(100);
                }
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        Thread st = new Thread(new SampleThread());
        Thread pt = new Thread(new PrintTimeThread());
        st.start();
        pt.start();
    }

}
