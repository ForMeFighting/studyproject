package math;

import java.math.BigDecimal;

/**
 * @Author: 柴俊杰
 * @Description: 将有小数点的数字加1
 * @Date: 2021/3/2 14:09
 */
public class CeilAddOne {
	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal(-0.123);
		bigDecimal = bigDecimal.setScale(0,BigDecimal.ROUND_UP);
//		System.out.println(bigDecimal);
		BigDecimal bigDecimal1 = new BigDecimal(0.000000);
		System.out.println(bigDecimal1);
	}
}
