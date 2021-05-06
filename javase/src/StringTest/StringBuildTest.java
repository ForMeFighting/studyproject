package StringTest;

/**
 * @Author: 柴俊杰
 * @Description:
 * @Date: 2021/4/26 16:40
 */
public class StringBuildTest {
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		if(stringBuilder != null && stringBuilder.length() > 0){
			stringBuilder.insert(1,"/"+"/0");
		}else {
			stringBuilder.append("/"+"/0");
		}
		stringBuilder.insert(1,"/0");
		stringBuilder.insert(1,"249");
		System.out.println(stringBuilder.toString());
	}
}
