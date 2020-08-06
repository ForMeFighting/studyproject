package com.chai.redislettuce;

import com.chai.redislettuce.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedislettuceApplicationTests {
	@Autowired
	private UserService userService;
	@Test
	void contextLoads() {
		userService.getString("chai");
	}

}
