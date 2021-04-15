package string;

/**
 * @Author: 柴俊杰
 * @Description: 字节数组的长度测试
 * @Date: 2021/2/25 10:40
 */
public class ByteLength {
	public static void main(String[] args) {
		String str = "方向";
		System.out.println(str.getBytes().length*2*256);
	}
}
