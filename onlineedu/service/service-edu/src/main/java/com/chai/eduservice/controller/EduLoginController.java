package com.chai.eduservice.controller;

import com.chai.servicebase.utilbo.ResultUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 柴俊杰
 * @Description: 登录接口
 *	什么是跨域？
 *	当通过一个地址去访问另一个地址时，如果以下三个地方有一个地方不一样，则会出现跨域问题
 *	1.访问协议：http，HTTPS
 *	2.访问地址
 *	3.端口号
 *
 * @Date: 2021/1/7 9:58
 */
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin//解决跨域，后续会加入网关解决跨域
public class EduLoginController {
	@PostMapping("/login")
	public ResultUtil login(){
		return ResultUtil.result(0,"token","admin");
	}
	@PostMapping("/info")
	public ResultUtil info(){
		Map<String,Object> map = new HashMap<>();
		String[] roles = new String[]{"admin"};
		map.put("roles","admin");
		map.put("name","admin");
		map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
		return ResultUtil.success(map);
	}
}
