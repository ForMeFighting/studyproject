package com.chai.eduservice.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.chai.eduservice.entity.bo.CourseInfoVo;
import com.chai.eduservice.entity.bo.CoursePublishVo;
import com.chai.eduservice.entity.po.EduCourse;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
public interface EduCourseService extends IService<EduCourse> {


    //添加课程基本信息的方法
    String saveCourseInfo(CourseInfoVo courseInfoVo);

    //根据课程id查询课程基本信息
    CourseInfoVo getCourseInfo(String courseId);

    //修改课程信息
    void updateCourseInfo(CourseInfoVo courseInfoVo);

    //根据课程id查询课程确认信息
    CoursePublishVo publishCourseInfo(String id);
}