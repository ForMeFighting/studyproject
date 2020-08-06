package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: 柴俊杰
 * @Description: lock锁
 * @Date: 2020/5/23 14:57
 */
public class ReenTrantLockTest {
	private static ReentrantLock reentrantLock = new ReentrantLock();
	public static void main(String[] args) {
		Thread thread = new Thread(()->{
			try {
				//尝试获取锁，如果这个锁被其他的线程已经获取，则进入阻塞，可以被其他的线程打断，
				// 如果没有其他的线程获取该锁，则获取到锁
//				reentrantLock.lockInterruptibly();

				//尝试获取锁
				if(!reentrantLock.tryLock(1, TimeUnit.SECONDS)){
					System.out.println("获取不到锁");
				}
				try {
					System.out.println("获取到锁");
				}finally {
					reentrantLock.unlock();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			try {
				System.out.println("获取到锁");
			}finally {
				reentrantLock.unlock();
			}
			},"t1");
//		reentrantLock.lock();
		thread.start();  //上下两句注释，则能成功获取锁，如果不注释，则获取锁失败，抛出异常
//		thread.interrupt();
	}
}
