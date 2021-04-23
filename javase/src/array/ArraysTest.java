package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: 柴俊杰
 * @Description: 测试工具类Arrays的使用
 * @Date: 2021/4/16 16:48
 */
public class ArraysTest {
	public static void main(String[] args) {
		int[] arr = {10,54,24,354,12,465,7,98,46,4,67,89,};
//		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		int i = Arrays.binarySearch(arr, 7);
//		System.out.println(arr[i]);
		Man[] men = {
				new Man("aaa",10),
				new Man("bbb",18),
				new Man("xxx",12),
				new Man("ccc",16)
		};
		Arrays.sort(men);
		for (int j = 0; j < men.length; j++) {
			System.out.println(men[j].getAge());
		}
		System.out.println(Arrays.toString(men));
	}
}
class Man implements Comparable{
	public String name;
	public int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Man(String name, int age){
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Object o) {
		Man man = (Man)o;
		if(this.age < man.age){
			return -1;
		}
		if(this.age > man.age){
			return 1;
		}
		return 0;
	}
}
