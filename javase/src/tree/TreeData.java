package tree;

import java.util.List;

/**
 * @Author: 柴俊杰
 * @Description: 树形结构实体类
 * @Date: 2021/6/1 16:21
 */
public class TreeData {
	private String id;
	private String pid;
	private String name;
	private List<TreeData> child;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TreeData> getChild() {
		return child;
	}

	public void setChild(List<TreeData> child) {
		this.child = child;
	}


}
