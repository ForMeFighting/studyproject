package thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: 柴俊杰
 * @Description: park和UNpark的实例
 * @Date: 2020/5/23 16:28
 */
public class ParkAndUnPark {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			LockSupport.park();//当前线程进入阻塞
			System.out.println("1");
		}, "t1");
		t1.start();
		new Thread(() -> {
			System.out.println("2");
			LockSupport.unpark(t1);//相当于唤醒t1线程
		}).start();
	}
}
