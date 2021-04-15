package com.chai.eduservice.controller;

import com.chai.servicebase.utilbo.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 柴俊杰
 * @Description: 登录接口
 * @Date: 2021/1/7 9:58
 */
@RestController
@RequestMapping("/user")
public class EduLoginController {
	@PostMapping("/login")
	public ResultUtil login(){
		return ResultUtil.result(0,"token","admin");
	}
	@PostMapping("/info")
	public ResultUtil info(){
		Map<String,String> map = new HashMap<>();
		map.put("roles","[admin]");
		map.put("name","admin");
		map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
		return ResultUtil.success(map);
	}
}
