package com.chai.eduservice.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chai.eduservice.entity.bo.CoursePublishVo;
import com.chai.eduservice.entity.po.EduCourse;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
	public CoursePublishVo getPublishCourseInfo(String courseId);
}
