package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 柴俊杰
 * @Description: 测试wait
 * @Date: 2021/5/10 16:35
 */
public class TestWait {
	public static void main(String[] args) throws InterruptedException {
		Lock lock = new ReentrantLock();
		TestWait testWait = new TestWait();
		synchronized (testWait){
			testWait.wait();
		}
	}

}
