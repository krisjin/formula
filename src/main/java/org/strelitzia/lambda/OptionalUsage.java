package org.strelitzia.lambda;

import org.strelitzia.lambda.domain.OrderDomain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 空指针异常是导致Java应用程序失败的最常见原因。以前，为了解决空指针异常，Google公司著名的Guava项目引入了Optional类，Guava通过使用检查空值的方式来防止代码污染，
 * 它鼓励程序员写更干净的代码。受到Google Guava的启发，Optional类已经成为Java 8类库的一部分。Optional实际上是个容器：它可以保存类型T的值，
 * 或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测
 * User:shijingui
 * Date:2018/12/30
 */
public class OptionalUsage {

    public static void main(String[] args) {


        test1();
        testIterator();

        test2();
    }

    private static void test1() {

        //Optional.of()或者Optional.ofNullable()：创建Optional对象，差别在于of不允许参数是null，而ofNullable则无限制。
        OrderDomain orderDomain = new OrderDomain();
//        Optional.of(null);//运行报错
        orderDomain.setAccount("d");
        boolean s = Optional.ofNullable(orderDomain.getAccount()).filter(v -> v == null).isPresent();

        System.out.println(s);
    }


    private static void testIterator() {
        List<Integer> number = new ArrayList<>();
        number.add(12);
        number.forEach(integer ->
                System.out.println(integer)
        );
    }

    private static void test2() {
        InputStream is = null;
        try {
            is = OptionalUsage.class.getClassLoader().getResourceAsStream("a.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            List<String> strList = new ArrayList<>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                strList.addAll(Arrays.asList(line.split(" ")));
            }

            strList.forEach(str -> System.out.println(str));
            long count = strList.parallelStream().filter(w -> w.length() > 12).count();
            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException("init properties error...", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {

            }
        }

    }

}
