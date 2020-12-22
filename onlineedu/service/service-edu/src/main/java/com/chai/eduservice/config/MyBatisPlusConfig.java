package com.chai.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Auther: 柴俊杰
 * @Description: SpringBoot配置类
 * @Date: 2020/11/27 9:20
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.chai.eduservice.mapper")
public class MyBatisPlusConfig {
	/**
	* @author:         柴俊杰
	* @Description:    配置SQL执行性能分析插件
	 * 				  开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长
	* @date:           2020/11/27 9:22
	*/
	@Bean
	@Profile({"dev","test"})
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		performanceInterceptor.setMaxTime(1000);//ms，超过此处设置的ms则sql不执行
		performanceInterceptor.setFormat(true);
		return performanceInterceptor;
	}
	/**
	* @author:         柴俊杰
	* @Description:    配置逻辑删除插件
	* @date:           2020/11/27 9:57
	*/
	@Bean
	public ISqlInjector sqlInjector() {
		return new LogicSqlInjector();
	}
	/**
	* @author:         柴俊杰
	* @Description:    配置mybatis-plus分页插件  暂时只配置，不使用
	* @date:           2020/12/22 14:56
	*/
	/**
	 * 分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
}
