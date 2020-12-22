package com.chai.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chai.eduservice.entity.po.EduTeacher;
import com.chai.servicebase.utilbo.PageQuery;
import com.chai.servicebase.utilbo.ResultUtil;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author chai
 * @since 2020-11-19
 */
public interface EduTeacherService extends IService<EduTeacher> {

	ResultUtil getTeacherByPage(PageQuery<EduTeacher> pageQuery);
}
