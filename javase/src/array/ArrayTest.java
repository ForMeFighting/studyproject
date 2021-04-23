package array;

import java.util.ArrayList;

/**
 * @Author: 柴俊杰
 * @Description: 数组测试
 * @Date: 2021/4/16 16:38
 */
public class ArrayTest {
	public static void main(String[] args) {
		int[] sourceOne = {1,2,3,4,5};
		int[] traget = new int[12];
		System.arraycopy(sourceOne,0,traget,5,sourceOne.length);
//		System.out.println(traget[6]);
		for (int i = 0; i < traget.length; i++) {
			System.out.println(traget[i]);
		}
	}
}
