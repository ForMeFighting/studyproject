package com.chai.eduservice.service.impl;

import com.chai.eduservice.entity.po.EduTeacher;
import com.chai.eduservice.mapper.EduTeacherMapper;
import com.chai.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chai.servicebase.utilbo.PageQuery;
import com.chai.servicebase.utilbo.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author chai
 * @since 2020-11-19
 */
@Slf4j
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
	@Resource
	private EduTeacherMapper eduTeacherMapper;
	@Override
	public ResultUtil getTeacherByPage(PageQuery<EduTeacher> pageQuery) {
		EduTeacher data = pageQuery.getData();
		PageInfo pageInfo = pageQuery.getPageInfo();
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<EduTeacher> teacherByPage = eduTeacherMapper.getTeacherByPage();
		return ResultUtil.success(new PageInfo<>(teacherByPage));
	}
}
