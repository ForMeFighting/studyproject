package com.chai.eduservice.controller;


import com.chai.eduservice.entity.po.EduTeacher;
import com.chai.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class EduTeacherController {
	@Autowired
	private EduTeacherService eduTeacherService;
	@GetMapping("/getAllTeacher")
	public List<EduTeacher> getAllTeacher(){
		return eduTeacherService.list(null);
	}
	@GetMapping("/deleteById/{ids}")
	public boolean deleteById(@PathVariable("ids") String id){
		boolean b = eduTeacherService.removeById(id);
		return b;
	}
}

