package thread;

import java.util.concurrent.*;

/**
 * @Auther: 柴俊杰
 * @Description: 线程池测试
 * @Date: 2020/5/28 10:31
 */
public class ThreadPoolTest {
	ExecutorService executorService = new ThreadPoolExecutor(5, 10, 1000,
			TimeUnit.SECONDS, new LinkedBlockingDeque(), r -> new Thread(r, "ts"));
}
