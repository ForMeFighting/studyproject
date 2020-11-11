package com.chai;

import com.chai.dao.UserMapper;
import com.chai.bo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {
	@Autowired
	UserMapper userMapper;
	@Test
	void contextLoads() {
	}
	@Test
	void selectAll(){
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);
	}
}
