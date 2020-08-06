package sort;

import java.util.Arrays;

/**
 * @Auther: 柴俊杰
 * @Description: 选择排序
 * @Date: 2020/7/10 14:17
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
		// 只需要修改成对应的方法名就可以了
		selectSort(array);

		System.out.println(Arrays.toString(array));
	}

	private static void selectSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i+1; j < array.length; j++) {
				if(array[j] < array[minIndex]){
					minIndex = j;
				}
			}
			if(minIndex != i){
				swap(array, minIndex, i);
			}
		}
	}
	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
