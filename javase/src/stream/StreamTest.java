package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author: 柴俊杰
 * @Description: stream流
 * @Date: 2021/4/28 9:53
 */
public class StreamTest {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
		List<String> asList = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
		//并行流 第一种
		list.parallelStream().forEach(obj->{
//			System.out.println("并行流第一种"+obj);
		});
		//并行流第二种
		list.stream().parallel().forEach(obj->{
//			System.out.println("并行流第二种"+obj);
		});
		//遍历输出符合条件的数据
//		list.stream().filter(x->x>5).forEach(System.out :: println);
		//匹配第一个
		Optional<Integer> first = list.stream().filter(x -> x > 5).findFirst();
		//判断是否能够匹配到  true表示能匹配到  false表示的匹配不到
//		System.out.println(first.isPresent());
		//如果不能匹配到，即x>15，first的值为Optional.empty，如果能匹配到,即x>5，first的值Optional[7]
//		System.out.println("first"+first);
		//如果first的值为Optional.empty，调用方法会报错java.util.NoSuchElementException: No value present
//		Integer integer = first.get();
//		System.out.println("integer"+integer);
		//匹配任意一个（适用于并行流）
		Optional<Integer> any = list.stream().filter(x -> x > 7).findAny();
//		System.out.println(any.isPresent());
//		System.out.println("any==>"+any);
//		Integer integer = any.get();
//		System.out.println("integer==>"+integer);

		//匹配任意一个满足条件的数据 如果有则返回true
		boolean anyMatch = list.stream().anyMatch(x -> x > 6);
//		System.out.println(anyMatch);
		//集合中所有的数据都必须满足该条件，只要有一个不满足则返回false
		boolean allMatch = list.stream().allMatch(x -> x > 0);
//		System.out.println(allMatch);

		//获取String集合中最长的元素
		Optional<String> max = asList.stream().max(Comparator.comparing(String::length));
		if(max.isPresent()){
//			System.out.println(max.get());
		}
		//获取Integer中最大的值 第一种方法
		Optional<Integer> max1 = list.stream().max(Comparator.comparing(Integer::intValue));
//		System.out.println(max1.get());
		//获取Integer中最大的值 第二种方法
		Optional<Integer> max2 = list.stream().max(Integer::compareTo);
//		System.out.println(max2.get());
		//自定义排序
		Optional<Integer> max3 = list.stream().max(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
//		System.out.println(max3.get());
		//计算Integer集合中大于6的元素的个数
		long count = list.stream().filter(x -> x > 3).count();
//		System.out.println("大于6的元素的个数"+count);

		//将数组中的元素全部改成大写
		List<String> collect = asList.stream().map(String::toUpperCase).collect(Collectors.toList());
//		collect.stream().forEach(System.out::println);
		//将数组中的数字加1
		List<Integer> integers = list.stream().map(integer -> integer.intValue() + 3).collect(Collectors.toList());
//		System.out.println(integers);


		// 求和方式1
		Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
		// 求和方式2
		Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
		// 求和方式3
		Integer sum3 = list.stream().reduce(0, Integer::sum);

		// 求乘积
		Optional<Integer> product = list.stream().reduce((x, y) -> x * y);

		// 求最大值方式1
		Optional<Integer> maxsss = list.stream().reduce((x, y) -> x > y ? x : y);
		// 求最大值写法2
		Integer max2sss = list.stream().reduce(1, Integer::max);

		System.out.println("list求和：" + sum.get() + "," + sum2.get() + "," + sum3);
		System.out.println("list求积：" + product.get());
		System.out.println("list求和：" + maxsss.get() + "," + max2sss);
	}
}
