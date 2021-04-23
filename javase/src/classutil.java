import java.util.Random;

/**
 * @Author: 柴俊杰
 * @Description: 公共类测试
 * @Date: 2021/4/21 15:59
 */
public class classutil {
	public static void main(String[] args) {
		double random = Math.random();
//		System.out.println(random);
//		System.out.println(Math.random()*10+1);
		Random random1 = new Random();
		int i = random1.nextInt();
		System.out.println(i);
	}
}
