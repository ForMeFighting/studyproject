package thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: 柴俊杰
 * @Description: 使用park和unPark来交替执行
 * @Date: 2020/5/23 17:03
 */
public class OtherAlternatePrint {
	static Thread t1;
	static Thread t2;
	static Thread t3;

	public static void main(String[] args) {
		ParkUnPark parkUnPark = new ParkUnPark(3);
		t1 = new Thread(() -> {
			parkUnPark.print("min", t2);
		});
		t2 = new Thread(() -> {
			parkUnPark.print("mid", t3);
		});
		t3 = new Thread(() -> {
			parkUnPark.print("max", t1);
		});
		t1.start();
		t2.start();
		t3.start();
		LockSupport.unpark(t1);
	}
}

class ParkUnPark {
	private int loopNum;

	public ParkUnPark(int loopNum) {
		this.loopNum = loopNum;
	}

	public void print(String str, Thread next) {
		for (int i = 0; i < this.loopNum; i++) {
			LockSupport.park();
			System.out.print(str + ">> ");
			LockSupport.unpark(next);
		}
	}
}
