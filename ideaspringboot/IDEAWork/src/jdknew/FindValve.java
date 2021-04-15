package jdknew;

import newpackage.javase.ComparebleAndComparetor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: 柴俊杰
 * @Description: 查找list中是否存在某个值
 * @Date: 2021/2/2 15:36
 */
public class FindValve {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("20200201");
		list.add("20200204");
		list.add("20200202");
		list.add("20200205");
		list.add("20200203");
		list.add("20200207");
		list.add("20200206");
		list.add("20200209");
		list.add("20200208");
		boolean b = list.stream().allMatch(task -> task.equals("20200210"));
		boolean present = list.stream().filter(t -> "20200210".equals(t)).findAny().isPresent();
		List<String> collect = list.stream().sorted(Comparator.comparing(s -> s)).collect(Collectors.toList());
		for (String s: collect) {
			System.out.println(s);
		}
//		list.stream().findAny()
//		System.out.println(b);
//		System.out.println(present);

	}
}
