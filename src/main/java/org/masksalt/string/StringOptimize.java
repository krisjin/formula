package org.masksalt.string;

/**
 * @author shijingui on 2017/3/31
 */
public class StringOptimize {

    static class HugeStr {

        private String string = new String(new char[10000]);

        public String getSubString(int begin, int end) {
            return string.substring(begin, end);
        }

    }

    static class ImproveHugeStr {

        private String string = new String(new char[10000]);

        public String getSubString(int begin, int end) {
            return new String(string.substring(begin, end));
        }
    }

}
