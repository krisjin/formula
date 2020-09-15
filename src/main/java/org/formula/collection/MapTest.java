package org.formula.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author shijingui on 2019/5/10
 */
public class MapTest {

    Map map = new HashMap();
    Random random = new Random();
    Object obj = new Object();

    public class AccessMapThread implements Runnable {

        protected String name;

        AccessMapThread() {

        }

        public AccessMapThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {

        }


        public Object handleMap(int index) {
            map.put(random.nextInt(2000), obj);

            return map.get(index);
        }
    }
}
