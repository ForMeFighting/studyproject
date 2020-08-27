package javabase;

/**
 * @Auther: 柴俊杰
 * @Description: 流程控制的测试
 * @Date: 2020/8/26 15:51
 */
public class ProcessControllerTest {
	public static void main(String[] args) {
		int a = 3;
		//switch后面的括号里面只能是byte，char，int，short，String，枚举类型
		switch (a){
			case 3:
				System.out.println("sss");
				break;
			case 5:
				break;
			default:
				System.out.println("ccc");
		}
	}
}
