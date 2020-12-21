package com.chai.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: 柴俊杰
 * @Description: springboot启动类
 * @Date: 2020/11/27 9:24
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.chai"})
public class EduApplication {
	public static void main(String[] args) {
		SpringApplication.run(EduApplication.class, args);
	}
}
