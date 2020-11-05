package jdknew;

/**
 * @Auther: 柴俊杰
 * @Description: jdknew
 * @Date: 2019/10/31 15:32
 * @version: 1.0
 */
public class Java8Tester {
	final static String str = "hello";

	public static void main(String args[]) {
		Java8Tester tester = new Java8Tester();

		// 类型声明
		MathOperation addition = (int a, int b) -> a + b;

		// 不用类型声明
		MathOperation subtraction = (a, b) -> a - b;

		// 大括号中的返回语句
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

		// 没有大括号及返回语句
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));

		// 不用括号
		GreetingService greetService1 = message ->
				System.out.println("Hello " + message);

		// 用括号
		GreetingService greetService2 = (message) ->
				System.out.println("Hello " + message);
		GreetingService greetingService = (message) ->
				System.out.println(str + "world");
		greetingService.sayMessage("Runoob");
		greetService2.sayMessage("Google");
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}
