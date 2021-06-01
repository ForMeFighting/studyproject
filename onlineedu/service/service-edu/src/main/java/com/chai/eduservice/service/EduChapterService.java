package com.chai.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chai.eduservice.entity.chapter.ChapterVo;
import com.chai.eduservice.entity.po.EduChapter;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
public interface EduChapterService extends IService<EduChapter> {
	//课程大纲列表,根据课程id进行查询
	List<ChapterVo> getChapterVideoByCourseId(String courseId);

	//删除章节的方法
	boolean deleteChapter(String chapterId);
}