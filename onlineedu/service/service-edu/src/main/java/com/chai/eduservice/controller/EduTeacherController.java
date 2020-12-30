package com.chai.eduservice.controller;


import com.chai.eduservice.entity.po.EduTeacher;
import com.chai.eduservice.service.EduTeacherService;
import com.chai.servicebase.utilbo.PageQuery;
import com.chai.servicebase.utilbo.ResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author chai
 * @since 2020-11-19
 */
@RestController
@RequestMapping("/eduservice")
//@CrossOrigin //跨域
@Slf4j
public class EduTeacherController {
	@Autowired
	private EduTeacherService eduTeacherService;
	@PostMapping("/getAllTeacher")
	public List<EduTeacher> getAllTeacher(){
		return eduTeacherService.list(null);
	}
	@GetMapping("/deleteById/{ids}")
	public boolean deleteById(@PathVariable("ids") String id){
		boolean b = eduTeacherService.removeById(id);
		return b;
	}
	@PostMapping("/getTeacherByPage")
	@ApiOperation("pagehelp 分页测试")
	public ResultUtil getTeacherByPage(@RequestBody PageQuery<EduTeacher> pageQuery){
		ResultUtil teacherByPage = eduTeacherService.getTeacherByPage(pageQuery);
		return teacherByPage;
	}
	@PostMapping("/removeTeacherById")
	@ApiOperation("删除教师")
	public ResultUtil removeTeacherById(@RequestBody EduTeacher pageQuery){
		ResultUtil teacherByPage = eduTeacherService.removeTeacherById(pageQuery);
		return teacherByPage;
	}
	@PostMapping("/saveOrUpdateTracher")
	@ApiOperation("新增或者修改教师信息")
	public ResultUtil saveOrUpdateTracher(@RequestBody EduTeacher pageQuery){
		ResultUtil teacherByPage = eduTeacherService.saveOrUpdateTracher(pageQuery);
		return teacherByPage;
	}
	@PostMapping("/getTeacherById")
	@ApiOperation("查询某一个教师")
	public ResultUtil getTeacherById(@RequestBody EduTeacher pageQuery){
		ResultUtil teacherByPage = eduTeacherService.getTeacherById(pageQuery);
		return teacherByPage;
	}
	@PostMapping("/getException")
	@ApiOperation("统一异常类测试")
	public ResultUtil getException(){
		int i = 5 /0;
		return ResultUtil.result(0,"异常");
	}
}

