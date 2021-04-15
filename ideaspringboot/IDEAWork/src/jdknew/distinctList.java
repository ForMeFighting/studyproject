package jdknew;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: 柴俊杰
 * @Description: 按照某个字段去除重复的值并返回一个List
 * @Date: 2020/11/19 14:07
 */
public class distinctList {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		for(int i = 0;i< 1000;i++){
			Person p = new Person();
			p.setAddress("s"+i/2);
			p.setAge((i/2)+"");
			p.setEmail("2");
			p.setName(i+"");
			list.add(p);
		}

		ArrayList<Person> collect = list.stream().collect(Collectors.collectingAndThen(
				Collectors.toCollection(() -> new TreeSet<>(
						Comparator.comparing(
								Person::getAge))), ArrayList::new));
//		System.out.println(collect.size());
		ArrayList<Person> collect1 = list.stream().collect(Collectors.collectingAndThen(
				Collectors.toCollection(() -> new TreeSet<>(
						Comparator.comparing(
								person -> person.getAge() + ";" + person.getAddress()))), ArrayList::new));
		Map<String, List<Person>> collect2 = list.stream().collect(Collectors.groupingBy(Person::getEmail));
		for (Map.Entry<String,List<Person>> map: collect2.entrySet()) {
			System.out.println(map.getKey());
			System.out.println(collect2.size());
		}
//		System.out.println(collect1.size());
	}
}
class Person{
	private String name;
	private String age;
	private String address;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
