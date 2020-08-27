package javabase;

import java.util.Scanner;

/**
 * @Auther: 柴俊杰
 * @Description: 使用Scanner从键盘获取输入的值
 * @Date: 2020/8/26 15:43
 */
public class ScannerTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(scanner.nextInt());//1
		System.out.println(scanner.next());//"dddd"
		System.out.println(scanner.nextDouble());//"1.32"
		System.out.println(scanner.nextFloat());//"1.34"

	}
}
