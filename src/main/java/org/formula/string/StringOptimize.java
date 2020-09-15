package org.formula.string;

/**
 * @author krisibm@163.com on 2017/3/31
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
            //截取字符串并重新生成
            return new String(string.substring(begin, end));
        }
    }


    public static void strSplit() {
        String string = "a;b,c:d";
        String[] strArr = string.split("[;|,|;]");
        System.out.println(strArr);
    }

    public static void main(String[] args) {
        strSplit();
    }

}
