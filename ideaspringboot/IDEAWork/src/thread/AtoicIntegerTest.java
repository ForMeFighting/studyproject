package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: 柴俊杰
 * @Description: 原子整数测试
 * @Date: 2020/5/27 10:11
 */
public class AtoicIntegerTest {
	public AtoicIntegerTest(Integer integer) {
		atomicInteger = new AtomicInteger(integer);
	}
	private Integer integer;
	private AtomicInteger atomicInteger;
	Lock lock = new ReentrantLock();
	public void getAtomicInteger(){
		synchronized (atomicInteger){

		}
//		if(atomicInteger.compareAndSet())
		System.out.println(atomicInteger.get());
	}


}
