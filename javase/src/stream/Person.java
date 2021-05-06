package stream;

/**
 * @Author: 柴俊杰
 * @Description: stream流测试数据
 * @Date: 2021/4/28 9:50
 */
public class Person {
	// 姓名
	private String name;
	// 薪资
	private int salary;
	// 年龄
	private int age;
	//性别
	private String sex;
	// 地区
	private String area;

	// 构造方法
	public Person(String name, int salary, int age,String sex,String area) {
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.sex = sex;
		this.area = area;
	}
	// 省略了get和set，请自行添加

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "this.name"+this.name+",this.salary"+this.salary+",this.age"+this.age;
	}
}
