package string;

/**
 * @Auther: 柴俊杰
 * @Description: String字符串截取测试
 * @Date: 2020/11/11 10:16
 */
public class StringSubStirngTest {
	public static void main(String[] args) {
		String marketId = "PXBSX";
		System.out.println(marketId.substring(3,5));
		String str = "0";
		System.out.println(str.substring(0,str.length()-1));
		System.out.println((short)Float.parseFloat(str));
		System.out.println("DDDDaassdwe".equalsIgnoreCase("ddddaassdwe"));
	}
}
