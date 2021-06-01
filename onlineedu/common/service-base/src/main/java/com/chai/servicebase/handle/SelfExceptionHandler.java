package com.chai.servicebase.handle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 柴俊杰
 * @Description: 自定义异常类
 * @Date: 2021/5/6 15:21
 */
@Data
@AllArgsConstructor //生成有参构造方法
@NoArgsConstructor  //生成无参构造方法
public class SelfExceptionHandler extends Exception{
	//状态码
	private Integer code;
	//异常信息
	private String msg;
}
