package com.chai.eduservice.mapper;

import com.chai.eduservice.entity.po.EduTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author chai
 * @since 2020-11-19
 */
@Mapper
public interface EduTeacherMapper extends BaseMapper<EduTeacher> {

	List<EduTeacher> getTeacherByPage();
}
