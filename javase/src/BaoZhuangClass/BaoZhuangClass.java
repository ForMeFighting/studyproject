package BaoZhuangClass;

/**
 * @Author: 柴俊杰
 * @Description: 包装类的测试
 * @Date: 2021/4/19 15:30
 */
public class BaoZhuangClass {
	public static void main(String[] args) {
		//将基本类型转换成包装类型
		Integer integer = new Integer(1);
		Integer integer1 = Integer.valueOf(3);
		//将包装类型转换成基本类型
		int i1 = integer.intValue();
		double v = integer.doubleValue();
		//包装类最大值和最小值
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		//将字符串转换成基本类型
		int i = Integer.parseInt("1");

		//自动装箱拆箱
		Integer integer2 = 3;//编译器会调用Integer.valueOf(3)
		int i2 = integer2;//编译器会调用integer.intValue()
//		byte bo = 1;
//		Byte b = new Byte(bo);
//		Float f = new Float(1.23);
	}
}
