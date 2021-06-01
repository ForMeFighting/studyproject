package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 柴俊杰
 * @Description: 树形结构工具类
 * @Date: 2021/6/1 16:22
 */
public class TreeUtil {
	public static void main(String[] args) {
		List<TreeData> dataList = new ArrayList<>();
		TreeData treeData = new TreeData();
		treeData.setId("0");
		treeData.setName("父");
		treeData.setPid("0000");
		dataList.add(treeData);
		treeData = new TreeData();
		treeData.setId("1");
		treeData.setName("1");
		treeData.setPid("0");
		dataList.add(treeData);
		treeData = new TreeData();
		treeData.setId("2");
		treeData.setName("2");
		treeData.setPid("0");
		dataList.add(treeData);
		treeData = new TreeData();
		treeData.setId("3");
		treeData.setName("3");
		treeData.setPid("0");
		dataList.add(treeData);
		treeData = new TreeData();
		treeData.setId("11");
		treeData.setName("11");
		treeData.setPid("1");
		dataList.add(treeData);
		treeData = new TreeData();
		treeData.setId("22");
		treeData.setName("22");
		treeData.setPid("2");
		dataList.add(treeData);
		treeData = new TreeData();
		treeData.setId("33");
		treeData.setName("33");
		treeData.setPid("3");
		dataList.add(treeData);
		treeData = new TreeData();
		treeData.setId("12");
		treeData.setName("12");
		treeData.setPid("1");
		dataList.add(treeData);
		treeData = new TreeData();
		treeData.setId("23");
		treeData.setName("23");
		treeData.setPid("2");
		dataList.add(treeData);
		treeData = new TreeData();
		treeData.setId("32");
		treeData.setName("32");
		treeData.setPid("3");
		dataList.add(treeData);
		treeData = new TreeData();
		treeData.setId("12312");
		treeData.setName("313");
		treeData.setPid("1");
		dataList.add(treeData);

		List<TreeData> parent = dataList.stream().filter(check -> "0".equals(check.getId())).collect(Collectors.toList());
		if(parent != null && parent.size() > 0){
			for (TreeData td:parent) {
				td.setChild(getChild(td.getId(),dataList));
			}
		}
		System.out.println(parent);
	}

	private static List<TreeData> getChild(String id, List<TreeData> dataList) {
		List<TreeData> treeData = dataList.stream().filter(check -> id.equals(check.getPid())).collect(Collectors.toList());
		if(treeData != null && treeData.size() > 0){
			for (TreeData td:treeData) {
				td.setChild(getChild(td.getId(),dataList));
			}
		}else {
			return treeData;
		}
		return treeData;
	}
}
