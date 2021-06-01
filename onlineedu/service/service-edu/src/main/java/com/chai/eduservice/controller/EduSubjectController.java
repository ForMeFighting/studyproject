package com.chai.eduservice.controller;



import com.chai.eduservice.entity.subject.OneSubject;
import com.chai.eduservice.service.EduSubjectService;
import com.chai.servicebase.utilbo.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-02-29
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    //添加课程分类
    //获取上传过来文件，把文件内容读取出来
    @PostMapping("addSubject")
    public ResultUtil addSubject(MultipartFile file) {
        //上传过来excel文件
        subjectService.saveSubject(file,subjectService);
        return ResultUtil.success();
    }
    //课程分类列表（树形）
    @GetMapping("getAllSubject")
    public ResultUtil getAllSubject() {
        //list集合泛型是一级分类
        List<OneSubject> list = subjectService.getAllOneTwoSubject();
        return ResultUtil.result(0,"list",list);
    }

}

