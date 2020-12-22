package com.chai.servicebase.utilbo;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Auther: 柴俊杰
 * @Description: 分页查询参数
 * @Date: 2020/12/22 9:28
 */
@Data
public class PageQuery<T> {

	@Valid
	@NotNull(message = "查询参数对象不能为空")
	private T data;
	@Valid
	@NotNull(message = "分页查询参数不能为空")
	private PageInfo pageInfo;

	public PageQuery() {
	}

	public T getData() {
		return this.data;
	}

	public PageInfo getPageInfo() {
		return this.pageInfo;
	}

	public void setData(final T data) {
		this.data = data;
	}

	public void setPageInfo(final PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	@Override
	public boolean equals(final Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof PageQuery)) {
			return false;
		} else {
			PageQuery<?> other = (PageQuery)o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				Object this$data = this.getData();
				Object other$data = other.getData();
				if (this$data == null) {
					if (other$data != null) {
						return false;
					}
				} else if (!this$data.equals(other$data)) {
					return false;
				}

				Object this$pageInfo = this.getPageInfo();
				Object other$pageInfo = other.getPageInfo();
				if (this$pageInfo == null) {
					if (other$pageInfo != null) {
						return false;
					}
				} else if (!this$pageInfo.equals(other$pageInfo)) {
					return false;
				}

				return true;
			}
		}
	}

	protected boolean canEqual(final Object other) {
		return other instanceof PageQuery;
	}

	@Override
	public int hashCode() {
		boolean PRIME = true;
		int result = 1;
		Object $data = this.getData();
		result = result * 59 + ($data == null ? 43 : $data.hashCode());
		Object $pageInfo = this.getPageInfo();
		result = result * 59 + ($pageInfo == null ? 43 : $pageInfo.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "PageQuery(data=" + this.getData() + ", pageInfo=" + this.getPageInfo() + ")";
	}
}
