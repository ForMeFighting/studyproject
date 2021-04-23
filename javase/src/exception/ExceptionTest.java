package exception;

/**
 * @Author: 柴俊杰
 * @Description: 异常类的测试
 * @Date: 2021/4/22 11:13
 */
public class ExceptionTest {
	public static void main(String[] args) {
		try {
			add();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void add() throws Exception {
		throw new SelfException();
	}
}
