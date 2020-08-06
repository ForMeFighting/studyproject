package com.chai.redislettuce.service.impl;

import com.chai.redislettuce.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Auther: 柴俊杰
 * @Description: service实现类
 * @Date: 2020/3/20 13:32
 */
@Service
@Log
public class UserServiceImpl implements UserService {
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@Override
	public String getString(String key) {
		System.out.println(redisTemplate);
		System.out.println("redisTemplate测试===》");
		if(redisTemplate.hasKey("chai")){

		}else{
			redisTemplate.opsForValue().set("chai","chhchchc");//保存String类型的数据
			redisTemplate.opsForValue().get("");//得到值
			redisTemplate.opsForValue().setIfPresent("","");//表示的是如果不存在（setnx）
			redisTemplate.opsForHash().hasKey("chai","");//表示的是hash里面是否有该key
			redisTemplate.opsForHash().put("","","");//表示往hash里面添加值
			redisTemplate.opsForList().set("",5,"");
			redisTemplate.opsForList().index("",5);
//			redisTemplate.opsForSet().
		}
		return null;
	}
}
