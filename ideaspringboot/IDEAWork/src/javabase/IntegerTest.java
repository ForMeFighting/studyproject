package javabase;

/**
 * @Auther: 柴俊杰
 * @Description: 整数型测试
 * @Date: 2020/12/3 8:53
 */
public class IntegerTest {
	public static void main(String[] args) {
		String startTime = "05:30";
		String endTime = "09:00";
		System.out.println(Integer.parseInt(endTime.substring(0,2)) - Integer.parseInt(startTime.substring(0,2)));
	}
}
