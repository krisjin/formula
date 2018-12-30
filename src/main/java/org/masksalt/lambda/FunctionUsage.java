package org.masksalt.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * User:shijingui
 * Date:2018/12/30
 *  
 */
public class FunctionUsage {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(12, 11, 14, 15);
//        int retVal = totalSelectedValues(nums, i -> i % 2 == 0); //第一个参数集合，第二个是函数
        //一个函数接收另一个函数
        int retVal = totalSelectedValues(nums, Util::isEven);

        System.out.println(retVal);
    }


    public static int totalSelectedValues(List<Integer> values, Predicate<Integer> selector) {
        return values.stream()
                .filter(selector)
                .reduce(0, Integer::sum);
    }


    static class Util {
        public static Predicate<Integer> preFunc() {
            Predicate<Integer> check = (Integer number) -> number % 2 != 0;
            return check;
        }

        private static boolean isEven(int i) {
            boolean check = (i % 2 != 0);
            return check;
        }


        /**
         * 一个返回函数的函数，创建并返回 Predicate 来验证给定值是否为奇数的函数：
         *
         * @return
         */
        public static Predicate<Integer> createIsOdd() {
            Predicate<Integer> check = (Integer number) -> number % 2 != 0;
            return check;
        }
    }
}
