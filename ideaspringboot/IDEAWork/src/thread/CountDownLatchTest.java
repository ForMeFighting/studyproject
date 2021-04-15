package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: 柴俊杰
 * @Description: CountDownLatch测试
 * @Date: 2021/1/21 10:53
 */
public class CountDownLatchTest {
	public static void main(String[] args) throws Exception {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		String type = "1";
		if("1".equals(type)){
			getString(countDownLatch);
			if("1".equals(type)){
				Thread.sleep(3000);
				System.out.println("ccccccccccccccccccccccccccccc");
			}
		}
		countDownLatch.await();
		System.out.println(countDownLatch.getCount());
		System.out.println("fffffffffffffffffffffff");
	}
	public static String getString(CountDownLatch countDownLatch) throws InterruptedException {
		countDownLatch.countDown();
		return "getString";
	}
}
