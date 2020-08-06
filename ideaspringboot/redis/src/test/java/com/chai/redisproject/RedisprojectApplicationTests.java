package com.chai.redisproject;

import com.chai.redisproject.bo.User;
import com.chai.redisproject.config.JedisConfig;
import com.chai.redisproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SpringBootTest
class RedisprojectApplicationTests {

	@Autowired
	private JedisConfig jedisConfig;
	@Autowired
	private JedisPool jedisPool;
	@Autowired
	private UserService userService;
	@Test
	void contextLoads() {
		System.out.println(jedisPool);
	}
	@Test
	void t1(){
		String val = userService.getString("chai");
		System.out.println(val);
//		Jedis jedis = new Jedis("192.168.2.132",6379);
//		jedis.auth("lu520");
//		System.out.println(jedis.ping());
//		jedis.close();
	}
	@Test
	void t2(){
		User user = userService.getUserInfo();
		System.out.println(user.toString());
	}

}
