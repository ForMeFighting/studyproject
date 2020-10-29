package set;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: 柴俊杰
 * @Description: HashSet测试
 * @Date: 2020/10/21 15:31
 */
public class HashSetTest {
	public static void main(String[] args) {
		Set<String> stringSet = new HashSet<>();
		boolean add1 = stringSet.add("1");
		boolean add2 = stringSet.add("1");
		boolean add3 = stringSet.add("2");
		boolean add4 = stringSet.add("3");
		System.out.println(add1);
		System.out.println(add2);
		System.out.println(add3);
		System.out.println(add4);
	}
}
