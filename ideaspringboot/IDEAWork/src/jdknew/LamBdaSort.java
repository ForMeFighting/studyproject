package jdknew;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: 柴俊杰
 * @Description: jdknew   对字符串数组按字符串长度排序
 * @Date: 2019/10/31 15:48
 * @version: 1.0
 */
public class LamBdaSort {
	public static void main(String[] args) {
		String[] arrs = {"adasd", "dd", "dwefvasca", "d", "chiyiurkjkjadnakjdh"};
		Arrays.sort(arrs, new Comparator<String>() {
			@Override
			public int compare(String s, String t1) {
                /*if(s.length() - t1.length()>0){
                    return -1;
                }*/
				return Integer.compare(s.length(), t1.length());
			}
		});
		for (String str : arrs
		) {
			System.out.println(str);
		}
		Arrays.sort(arrs, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
		for (String str : arrs
		) {
			System.out.println(str);
		}
	}
}
