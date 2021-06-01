package com.chai.ossservice.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.chai.ossservice.service.OssService;
import com.chai.ossservice.util.ConstantPropertiesUtil;
import com.chai.servicebase.utilbo.ResultUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @Author: 柴俊杰
 * @Description: 文件上传业务实现层
 * @Date: 2021/5/13 14:47
 */
@Service
public class OssServiceImpl implements OssService {
	@Override
	public ResultUtil uploadFileAvatar(MultipartFile file) {
		//根据配置文件获取值
		String endpoint = ConstantPropertiesUtil.END_POINT;
		String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
		String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
		String bucketName = ConstantPropertiesUtil.BUCKET_NAME;

		// 创建OSSClient实例。
		OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

		// 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
		InputStream inputStream = null;
		try {
			inputStream = file.getInputStream();
			String originalFilename = file.getOriginalFilename();
			//1 在文件名称里面添加随机唯一的值
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			// yuy76t5rew01.jpg
			originalFilename = uuid+originalFilename;

			//2 把文件按照日期进行分类
			//获取当前日期
			//   2019/11/12
			String datePath = new DateTime().toString("yyyy/MM/dd");
			//拼接
			//  2019/11/12/ewtqr313401.jpg
			originalFilename = datePath+"/"+originalFilename;
			ossClient.putObject(bucketName, originalFilename, inputStream);
			// 关闭OSSClient。
			ossClient.shutdown();
			String url = "https://"+bucketName+"."+endpoint+"/"+originalFilename;
			return ResultUtil.success(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 填写Bucket名称和Object完整路径。Object完整路径中不能包含Bucket名称。

		return null;
	}
}
