package com.chai.servicebase.utilbo;

import com.chai.servicebase.handle.SelfExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: 柴俊杰
 * @Description: 统一异常返回类
 * @Date: 2020/12/22 15:02
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	//全局异常
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResultUtil error(Exception e){
		log.error(e.getMessage());
		e.printStackTrace();
		return ResultUtil.result(500,"捕获异常成功",e.getMessage());
	}

	//自定义异常
	@ExceptionHandler(SelfExceptionHandler.class)
	@ResponseBody
	public ResultUtil selfException(SelfExceptionHandler e){
		log.error(e.getMessage());
		e.printStackTrace();
		return ResultUtil.result(e.getCode(),e.getMsg(),e.getMessage());
	}
}
