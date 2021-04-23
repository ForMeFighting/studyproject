package StringTest;

import java.util.Scanner;

/**
 * @Author: 柴俊杰
 * @Description: 判断一个字符串中是否包含子串
 * @Date: 2021/4/23 10:34
 */
public class ParentIncludeChild {
	public static void main(String[] args) {
		System.out.println("请输入父串：");
		Scanner scanner = new Scanner(System.in);
		String parent = scanner.nextLine();
		System.out.println("请输入子串");
		String child = scanner.nextLine();
		if(parent.contains(child)){

		}
	}
}
