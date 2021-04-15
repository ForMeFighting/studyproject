package thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 柴俊杰
 * @Description: 线程condition测试
 * @Date: 2021/3/31 11:07
 */
public class ConditonTest {
	public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock();
		Condition condition = reentrantLock.newCondition();
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

	}
}
