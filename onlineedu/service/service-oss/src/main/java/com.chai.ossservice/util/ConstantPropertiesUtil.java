package com.chai.ossservice.util;


import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: 柴俊杰
 * @Description: 读取配置文件中的值
 * @Date: 2021/5/13 13:48
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "aliyun.oss.file",ignoreInvalidFields = true)
public class ConstantPropertiesUtil implements InitializingBean {

	private String endpoint;
	private String keyId;
	private String keysecret;
	private String bucketname;

	public static String END_POINT;
	public static String ACCESS_KEY_ID;
	public static String ACCESS_KEY_SECRET;
	public static String BUCKET_NAME;



	//当bean初始化完成后，会执行afterPropertiesSet方法
	@Override
	public void afterPropertiesSet() {

		END_POINT = endpoint;
		ACCESS_KEY_ID = keyId;
		ACCESS_KEY_SECRET = keysecret;
		BUCKET_NAME = bucketname;
	}
}
