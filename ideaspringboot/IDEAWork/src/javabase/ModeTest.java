package javabase;

/**
 * @Auther: 柴俊杰
 * @Description: 测试%除
 * @Date: 2020/12/3 14:31
 */
public class ModeTest {
	public static void main(String[] args) {
		int sum = 100;
		int count = sum / 2000;
		if(count % 2000 > 0){
			count+=1;
		}
		System.out.println(sum % 2000);
		System.out.println(count);
	}
}
