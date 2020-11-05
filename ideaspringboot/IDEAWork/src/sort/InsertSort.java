package sort;

import java.util.Arrays;

/**
 * @Auther: 柴俊杰
 * @Description: 插入排序
 * @Date: 2020/7/18 10:35
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
		// 只需要修改成对应的方法名就可以了
		insertSort(array);

		System.out.println(Arrays.toString(array));
	}

	private static void insertSort(int[] array) {
		int preIndex = 0;
		int current = 0;
		for (int i = 1; i < array.length; i++) {
			preIndex = i - 1;//1
			current = array[i];//38
			while (preIndex >= 0 && array[preIndex] > current) {
				array[preIndex + 1] = array[preIndex];
				preIndex--;
			}
			array[preIndex + 1] = current;
		}
	}

	public final void aa() {
	}

	public final void aa(int a) {
	}
}
