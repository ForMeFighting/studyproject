package jdknew;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Auther: 柴俊杰
 * @Description: jdknew 給定一個字符串，返回字符串的長度
 * @Date: 2019/10/31 16:21
 * @version: 1.0
 */
public class GetLength {
	public static void main(String[] args) {
		String str = "sdasdnmaklsjfdoaj";
		Integer length = testFun(str, (st) -> st.length());
		System.out.println(length);
		System.out.println("=======================");
		testOut(str, (s) -> System.out.println(s));
		System.out.println("=======================");
		String s = testSup(() -> str);
		System.out.println(s);
	}

	/**
	 * 功能描述: Function<String,Integer> String 表示的是輸入的參數，Integer代表的是輸出的參數
	 *
	 * @param: String
	 * @return: int
	 * @auther:
	 * @date:
	 */

	public static int testFun(String str, Function<String, Integer> fun) {
		//執行方法apply
		Integer length = fun.apply(str);
		return length;
	}

	/**
	 * 功能描述: 輸出字符串,沒有返回值
	 *
	 * @param:String
	 * @return:
	 * @auther:
	 * @date:
	 */
	public static void testOut(String str, Consumer<String> con) {
		con.accept(str);
	}

	/**
	 * 功能描述:沒有參數，有一個返回值
	 *
	 * @param:
	 * @return:
	 * @auther:
	 * @date:
	 */
	public static String testSup(Supplier<String> str) {
		String s = str.get();
		return s;
	}
}
