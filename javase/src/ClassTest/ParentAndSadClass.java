package ClassTest;

/**
 * @Author: 柴俊杰
 * @Description: 父类和子类的静态代码块和构造方法执行顺序测试
 * @Date: 2021/4/16 9:36
 */
public class ParentAndSadClass extends Parent{
	public ParentAndSadClass(){
		System.out.println("子类构造方法");
	}
	static {
		System.out.println("子类静态代码块");
	}

	public static void main(String[] args) {
		new Thread(()->{

		}).start();
		Parent parentAndSadClass = new ParentAndSadClass();
		/**
		 * 父类静态代码块
		 * 子类静态代码块
		 * 父类构造方法
		 * 子类构造方法
		 */
	}
}
class Parent{
	static {
		System.out.println("父类静态代码块");
	}
	public Parent(){
		System.out.println("父类构造方法");
	}
}
