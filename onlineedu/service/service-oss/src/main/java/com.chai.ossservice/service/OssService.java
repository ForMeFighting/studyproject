package com.chai.ossservice.service;

import com.chai.servicebase.utilbo.ResultUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 柴俊杰
 * @Description: 文件上传业务层
 * @Date: 2021/5/13 14:47
 */
public interface OssService {
	ResultUtil uploadFileAvatar(MultipartFile file);
}
