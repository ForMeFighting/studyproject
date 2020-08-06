package thread;

/**
 * @Auther: 柴俊杰
 * @Description: threadlocal测试
 * @Date: 2020/6/5 13:51
 */
public class ThreadLocalTest {
	public static void main(String[] args) {
		Thread thread = new Thread();
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		threadLocal.set("ddd");
		threadLocal.get();
	}
}
