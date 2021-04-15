import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 柴俊杰
 * @Description:
 * @Date: 2021/3/30 16:20
 */
class SuperClass{
	public int a;
	public SuperClass(){
		a=1;
		System.out.println("a is"+a);
	}
	public int getA(){
		return a;
	}
}
public class Test extends SuperClass{
	public int a = 2;
	public Test(){
		System.out.println("a is "+a);
	}
	@Override
	public int getA(){
		return a;
	}

	public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock();
//		Condition
		SuperClass superClass = new SuperClass();
		SuperClass test = new Test();
		System.out.println("num1 is"+(superClass.a + test.a));
		System.out.println("num2 is"+(superClass.getA() + test.getA()));
		System.out.println("num3 is"+(superClass.a + test.getA()));
		System.out.println("num4 is"+(superClass.getA() + test.a));
	}
}
