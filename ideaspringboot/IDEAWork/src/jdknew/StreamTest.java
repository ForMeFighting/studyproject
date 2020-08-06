package jdknew;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: 柴俊杰
 * @Description: jdknew Stream流的操作
 * @Date: 2019/10/31 17:52
 * @version: 1.0
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ads");
        list.add("dasdacasads");
        list.add("adsfewrwerfsvsdd");
        list.add("adsrwerdas");
        list.add("3aasdaddas");
        list.add("2ddd222222aasdaddas");
        long intd = list.stream().filter((s)->s.length()>10).count();
        System.out.println(intd);
        System.out.println("=======================");
        List<String> list2 = list.stream().filter((s)->s.length()>10).collect(Collectors.toList());
        list2.forEach(System.out::println);
        System.out.println("=======================");
        //如果有一个函数可以将一种类型的值转换成另外一种类型
        //map 操作就可以使用该函数，将一个流中的值转换成一个新的流
        List<String> list3 = list.stream().map((s)->s.toUpperCase()).collect(Collectors.toList());
        list3.forEach(System.out::println);
        System.out.println("=======================");

        //获取以数字开头的字符串
        List<String> list4 = list.stream().filter((s)->Character.isDigit(s.charAt(0))).collect(Collectors.toList());
        list4.forEach(System.out::println);
        //获取以a开头的字符的长度集合
        System.out.println("=======================");
        List<Integer> list5 = Stream.of("abc", "b", "a", "abcd").filter((s) -> s.startsWith("a")).map((s) -> s.length())
                .collect(Collectors.toList());
        System.out.println(list5);

    }
}
