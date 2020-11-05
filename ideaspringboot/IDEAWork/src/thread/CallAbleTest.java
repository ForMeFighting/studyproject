package thread;

import java.util.UUID;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.*;

/**
 * @Auther: 柴俊杰
 * @Description: 创建线程的第三种方式
 * @Date: 2019/11/18 10:01
 */
public class CallAbleTest implements Callable<Integer> {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService es = newFixedThreadPool(2);
		es.submit(new CallAbleTest());
		es.submit(new CallAbleTest());
		FutureTask<String> futureTask = new FutureTask<>(() -> UUID.randomUUID().toString());
		Thread thread = new Thread(futureTask, "ss");
		thread.join();
		TimeUnit.SECONDS.sleep(1);
		thread.start();
		String sum = futureTask.get();
	}

	@Override
	public Integer call() throws Exception {
		return 1;
	}
}
