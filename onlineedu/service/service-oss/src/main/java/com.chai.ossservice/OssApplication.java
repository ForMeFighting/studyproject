package com.chai.ossservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: 柴俊杰
 * @Description: springboot启动类
 * @Date: 2020/11/27 9:24
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.chai"})
public class OssApplication {
	public static void main(String[] args) {
		SpringApplication.run(OssApplication.class, args);
	}
}
