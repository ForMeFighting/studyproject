package com.chai.redisproject.service.impl;

import com.chai.redisproject.bo.User;
import com.chai.redisproject.config.JedisConfig;
import com.chai.redisproject.service.UserService;
import lombok.extern.java.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * @Auther: 柴俊杰
 * @Description: service实现类
 * @Date: 2020/3/20 13:32
 */
@Service
@Log
public class UserServiceImpl implements UserService {
	@Autowired
	private JedisPool jedisPool;
	@Resource
	private RedisTemplate redisTemplate;
	@Override
	public String getString(String key) {
		Jedis jedis = jedisPool.getResource();
		String val = "";
		System.out.println(jedis.get("chai"));
		if(jedis.exists("chai")){
			val = jedis.get("chai");
			System.out.println("redis");
		}else{
			System.out.println("mysql");
			jedis.set("chai","chai");
			val = jedis.get("chai");
		}
		redisTemplate.opsForValue().set("ccc","ds");
		System.out.println(redisTemplate.opsForValue().get("chai"));
		return val;
	}

	@Override
	public User getUserInfo() {
		User user = new User();
		user.setAge(18);
		user.setId("1111");
		user.setName("chaijunjie");
		redisTemplate.opsForValue().set("user1",user);
		User user1 = (User)redisTemplate.opsForValue().get("user1");
		return user1;
	}
}
