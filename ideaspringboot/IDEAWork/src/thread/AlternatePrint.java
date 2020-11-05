package thread;

/**
 * @Auther: 柴俊杰
 * @Description: 使用线程交替执行输出相应的数据
 * @Date: 2020/5/23 16:45
 */
public class AlternatePrint {
	public static void main(String[] args) {
		Looper looper = new Looper(1, 3);
		new Thread(() -> {
			looper.print("min", 1, 2);
		}).start();
		new Thread(() -> {
			looper.print("mid", 2, 3);
		}).start();
		new Thread(() -> {
			looper.print("max", 3, 1);
		}).start();
	}
}

class Looper {
	private int flag;
	private int loopNum;

	public Looper(int flag, int loopNum) {
		this.flag = flag;
		this.loopNum = loopNum;
	}

	public void print(String str, int waitFlag, int nextFlag) {
		for (int i = 0; i < this.loopNum; i++) {
			synchronized (this) {
				while (flag != waitFlag) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print(str + ">> ");
				this.flag = nextFlag;
				this.notifyAll();
			}
		}
	}
}