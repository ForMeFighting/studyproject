package search;

/**
 * @Author: 柴俊杰
 * @Description: 二分查找
 * @Date: 2021/4/19 14:58
 */
public class ERFENSearch {
	public static void main(String[] args) {
		int[] arr = new int[]{7, 8, 9, 68, 69, 72, 73, 98, 123, 564, 987, 6111};
		int num = erFenSearch(arr,74);
		System.out.println(num);
	}

	private static int erFenSearch(int[] arr,int num) {
		if(arr.length == 0){
			return -1;
		}
		if(arr.length == 1){
			return arr[0] == num ? 0 : -1;
		}
		int low = 0;
		int high = arr.length-1;

		while(low<=high){
			int mid = (low + high)/2;
			if(arr[mid] == num){
				return mid;
			}
			if(arr[mid] < num){
				low = mid + 1;
			}
			if(arr[mid] > num){
				high = mid - 1;
			}
		}
		return -1;
	}
}
