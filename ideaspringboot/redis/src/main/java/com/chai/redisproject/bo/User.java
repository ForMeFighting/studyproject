package com.chai.redisproject.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 柴俊杰
 * @Description: user实体类
 * @Date: 2020/3/19 15:57
 */
@Data
public class User implements Serializable {
	private String id;
	private String name;
	private Integer age;

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
