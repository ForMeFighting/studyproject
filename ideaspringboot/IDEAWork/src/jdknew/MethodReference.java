package jdknew;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 柴俊杰
 * @Description: jdknew LamBda表達式的方法引用    ::後面必須是方法
 * @Date: 2019/10/31 16:48
 * @version: 1.0
 */
public class MethodReference {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("aaaaaa");
		list.add("bbbbbbbb");
		list.add("ccccccc");
		list.add("dddddddd");
		list.add("eeeeeee");
		list.forEach(s -> System.out.println(s));
		list.forEach(System.out::println);
	}
}
