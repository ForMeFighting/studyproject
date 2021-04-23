package StringTest;

/**
 * @Author: 柴俊杰
 * @Description: 字符串类比较
 * @Date: 2021/4/20 19:56
 */
public class StringTest {
	public static void main(String[] args) {
		String str = "dhaish";
		String str2 = "dhaish";
		System.out.println(str.equals(str2));
		StringBuilder stringBuilder = new StringBuilder(str);
		StringBuffer stringBuffer = new StringBuffer();
	}
}
