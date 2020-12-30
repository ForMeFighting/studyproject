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
import org.apache.commons.lang3.StringUtils;
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
	/**
	* @author:         柴俊杰
	* @Description:    分页查询所有教师的信息
	* @date:           2020/12/29 15:57
	*/
	@Override
	public ResultUtil getTeacherByPage(PageQuery<EduTeacher> pageQuery) {
		EduTeacher data = pageQuery.getData();
		PageInfo pageInfo = pageQuery.getPageInfo();
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<EduTeacher> teacherByPage = eduTeacherMapper.getTeacherByPage(data);
		return ResultUtil.success(new PageInfo<>(teacherByPage));
	}
	/**
	* @author:         柴俊杰
	* @Description:    根据教师id删除教师信息
	* @date:           2020/12/29 15:57
	*/
	@Override
	public ResultUtil removeTeacherById(EduTeacher eduTeacher) {
		if(StringUtils.isEmpty(eduTeacher.getId())){
			return ResultUtil.result(0,"教师id不能为空");
		}
		int i = eduTeacherMapper.deleteById(eduTeacher.getId());
		return ResultUtil.result(0,"删除成功",i);
	}
	/**
	* @author:         柴俊杰
	* @Description:    新增或修改教师信息
	* @date:           2020/12/29 15:58
	*/
	@Override
	public ResultUtil saveOrUpdateTracher(EduTeacher eduTeacher) {
		if(StringUtils.isEmpty(eduTeacher.getId())){
			int insert = eduTeacherMapper.insert(eduTeacher);
			return ResultUtil.result(0,"添加成功",insert);
		}
		int i = eduTeacherMapper.updateById(eduTeacher);
		return ResultUtil.result(0,"修改成功",i);
	}
	/**
	* @author:         柴俊杰
	* @Description:    根据教师id得到教师的信息
	* @date:           2020/12/29 15:59
	*/
	@Override
	public ResultUtil getTeacherById(EduTeacher eduTeacher) {
		List<EduTeacher> list = eduTeacherMapper.getTeacherByPage(eduTeacher);
		return ResultUtil.result(0,"查询成功",list);
	}
}
