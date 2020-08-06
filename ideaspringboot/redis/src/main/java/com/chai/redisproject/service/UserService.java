package com.chai.redisproject.service;

import com.chai.redisproject.bo.User;

/**
 * @Auther: 柴俊杰
 * @Description: service
 * @Date: 2020/3/20 13:32
 */
public interface UserService {
	public String getString(String key);

	User getUserInfo();
}
