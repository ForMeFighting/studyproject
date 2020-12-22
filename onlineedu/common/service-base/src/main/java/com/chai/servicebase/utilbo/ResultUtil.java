package com.chai.servicebase.utilbo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 柴俊杰
 * @Description: 统一结果返回类
 * @Date: 2020/12/22 9:41
 */
@Data
public class ResultUtil<T> implements Serializable {
	private static final long serialVersionUID = 2120267584344923858L;
	private Integer status = 0;

	private String message = "Success";

	private T data = null;

	public ResultUtil() {

	}

	public ResultUtil(Integer status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public static <T> ResultUtil<T> success() {
		return new ResultUtil();
	}

	public static <T> ResultUtil<T> success(T data) {
		ResultUtil<T> resultUtil = new ResultUtil();
		resultUtil.setData(data);
		return resultUtil;
	}

	public static <T> ResultUtil<T> result(String message) {
		ResultUtil<T> resultUtil = new ResultUtil();
		resultUtil.setMessage(message);
		return resultUtil;
	}

	public static <T> ResultUtil<T> result(Integer status, String message) {
		ResultUtil<T> resultUtil = new ResultUtil();
		resultUtil.setStatus(status);
		resultUtil.setMessage(message);
		return resultUtil;
	}

	public static <T> ResultUtil<T> result(Integer status, String message, T data) {
		ResultUtil<T> resultUtil = new ResultUtil();
		resultUtil.setStatus(status);
		resultUtil.setMessage(message);
		resultUtil.setData(data);
		return resultUtil;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultUtil{" +
				"status=" + status +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}
}
