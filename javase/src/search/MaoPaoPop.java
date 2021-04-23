package search;

import java.util.Arrays;

/**
 * @Author: 柴俊杰
 * @Description: 冒泡排序
 * @Date: 2021/4/19 14:45
 */
public class MaoPaoPop {
	public static void main(String[] args) {
		int[] arr = new int[]{123,564,8,7,987,9,68,69,72,98,73,6111};
		arr = MaoPaoPop(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] MaoPaoPop(int[] arr){
		if(arr.length <= 1){
			return arr;
		}
		for (int i = 0; i < arr.length-1; i++) {

			for (int j = 0; j < arr.length - 1 - i; j++) {
				int temp;
				if(arr[j] > arr[j + 1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
}
