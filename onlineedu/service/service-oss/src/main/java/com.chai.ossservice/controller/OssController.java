package com.chai.ossservice.controller;

import com.chai.ossservice.service.OssService;
import com.chai.servicebase.utilbo.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 柴俊杰
 * @Description: 文件上传控制层
 * @Date: 2021/5/13 14:46
 */
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

	@Autowired
	private OssService ossService;
	//上传头像的方法
	@PostMapping("/uploadOssFile")
	public ResultUtil uploadOssFile(MultipartFile file){
		//获取要上传的头像 MultipartFile
		ResultUtil resultUtil = ossService.uploadFileAvatar(file);
		return resultUtil;
	}
}
