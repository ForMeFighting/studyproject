package stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: 柴俊杰
 * @Description: bo类流
 * @Date: 2021/4/28 9:56
 */
public class PersonStream {
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Tom", 8900,15, "male", "New York"));
		personList.add(new Person("Jack", 7000,16, "male", "Washington"));
		personList.add(new Person("Lily", 7800,17, "female", "Washington"));
		personList.add(new Person("Anni", 8200,18, "female", "New York"));
		personList.add(new Person("Owen", 9500,25, "male", "New York"));
		personList.add(new Person("Alisa", 7900,35, "female", "New York"));

		//筛选员工中工资高于8000的人，并形成新的集合。 形成新集合依赖collect（收集）,返回泛型为Person的集合
		List<Person> salary = personList.stream().filter(check -> check.getSalary() > 8000).collect(Collectors.toList());

		//筛选员工中工资高于8000的人，并形成新的集合。 形成新集合依赖collect（收集）,返回泛型为String的集合
		List<String> name = personList.stream().filter(check -> check.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());

		//筛选员工中年龄最大的
		Optional<Person> maxAge = personList.stream().max(Comparator.comparing(Person::getAge));
		if(maxAge.isPresent()){
//			System.out.println("年龄最大的人的名字是："+maxAge.get().getName());
		}

		Optional<Person> maxAge2 = personList.stream().max((o1,o2) ->{
				return Integer.compare(o1.getAge(),o2.getAge());
		});
		Optional<Person> maxAge3 = personList.stream().max(Comparator.comparingInt(Person::getAge));

//		System.out.println("maxAge2=====>"+maxAge2.get());

		//求员工中年龄大于20的人的个数
		long count = personList.stream().filter(check -> check.getAge() > 20).count();
//		System.out.println("员工中年龄大于20的人的个数"+count);
		//将所有员工年龄大于15的工资加10000
		List<Integer> sala = personList.stream().filter(check -> check.getAge() > 15).map(person -> person.getSalary() + 10000).collect(Collectors.toList());
//		sala.stream().forEach(System.out::println);
		List<Person> collect = personList.stream().filter(check -> check.getAge() > 15).map(person -> {
			Person personNew = new Person(person.getName(), 0, 0, null, null);
			personNew.setSalary(person.getSalary() + 10000);
			return personNew;
		}).collect(Collectors.toList());
		collect.stream().forEach(obj->{
//			System.out.println(obj.toString());
		});
		List<Person> collect2 = personList.stream().filter(check -> check.getAge() > 15).map(person -> {
			person.setSalary(person.getSalary() + 10000);
			return person;
		}).collect(Collectors.toList());
		collect2.stream().forEach(obj->{
//			System.out.println(obj.toString());
		});
		//求工资之和方式1
		Integer integer = personList.stream().map(Person::getSalary).reduce((x, y) -> x + y).get();
//		System.out.println(integer);
		//求工资之和方式2
		Integer integer1 = personList.stream().map(Person::getSalary).reduce(Integer::sum).get();
//		System.out.println(integer1);
		//求员工的总数
		long counts = personList.stream().count();
//		System.out.println("员工的总数"+counts);
		Long collect1 = personList.stream().collect(Collectors.counting());
//		System.out.println("员工的总数"+collect1);
		Double aDouble = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
//		System.out.println("平均工资double类型"+aDouble);
		Double aInt = personList.stream().collect(Collectors.averagingInt(Person::getSalary));
//		System.out.println("平均工资Int类型"+aInt);
		Double aLong = personList.stream().collect(Collectors.averagingLong(Person::getSalary));
//		System.out.println("平均工资Long类型"+aLong);
		//求最高工资
		Optional<Integer> optionalInteger = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compareTo));
		System.out.println(optionalInteger);
		// 求工资之和
		Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
		// 一次性统计所有信息
		DoubleSummaryStatistics doubleSummaryStatistics = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));

		//分组
		Map<Boolean, List<Person>> collect3 = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
//		System.out.println("员工按薪资是否大于8000分组情况：" + collect3.toString());

		List<String> collect4 = personList.stream().distinct().map(Person::getSex).collect(Collectors.toList());

		System.out.println(collect4.size());

	}
}




































