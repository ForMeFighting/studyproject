/**
 * @Auther: 柴俊杰
 * @Description: redis操作
 * @Date: 2019/12/31 14:47
 */

import redis.clients.jedis.Jedis;

public class redis {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		//查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
		//操作字符串
		jedis.set("chai", "测试");
		System.out.println(jedis.get("chai"));
	}
}
