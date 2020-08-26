package javabase;

/**
 * @Auther: 柴俊杰
 * @Description: 标识符测试
 * @Date: 2020/8/26 10:03
 */
public class IdentiferTest {
	public static void main(String[] args) {
		/**
		 * 标识符是由数字，字母，_和$构成
		 * 数字不能开头，不能是关键字，但是可以包含关键字
		 * 区分大小写，长度没有限制，但建议取有意义的单词，
		 * 标识符不能包含空格
		 */
		String 柴 = "sss";//汉字也可以作为一个标识符，但是极不推荐
		String $s = "";
		//char只能定义一个字母或者一个汉字
		char cr = 's';
		char cs = '是';
		char sd = '\n';//表示的是换行符
//		char ct = 'sd';//这种是错误的
	}
}
