package thread;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: 柴俊杰
 * @Description: 测试interrupt和isinterrupt
 * @Date: 2020/6/1 15:23
 */
public class InterruptTest {


	public static void main(String[] args) {
		System.out.println("主线程开始。。。。");
		Threads thread = new Threads();
		thread.start();
		System.out.println(thread.getName()+"的打断前的打断标记为"+thread.isInterrupted());//Thread-0的打断前的打断标记为false
		thread.interrupt();
		System.out.println(thread.getName()+"的打断后的打断标记为"+thread.isInterrupted());//Thread-0的打断后的打断标记为true
		System.out.println("主线程结束了、。。。。。。。。。。。");
	}
}
class Threads extends java.lang.Thread{
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			//java.lang.InterruptedException: sleep interrupted
			//	at java.lang.Thread.sleep(Native Method)
			//	at java.lang.Thread.sleep(Thread.java:340)
			//	at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
			//	at thread.Threads.run(InterruptTest.java:27)
			e.printStackTrace();
			Thread.currentThread().interrupt();//如果在睡眠中被打断则会抛出异常，所以需要在异常中再次打断，否则
//			Thread.currentThread().isInterrupted()为false,则会陷入死循环
		}
		System.out.println(Thread.currentThread().getName()+"开始运行");
		System.out.println(Thread.currentThread().getName()+"的打断后的打断标记为"
				+Thread.currentThread().isInterrupted());//Thread-0的打断后的打断标记为true
		while (!Thread.currentThread().isInterrupted()){
			System.out.println(Thread.currentThread().getName()+"被中断了。。。。。"+Thread.currentThread().isInterrupted());
		}
	}
}
