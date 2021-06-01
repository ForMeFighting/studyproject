package com.chai.servicebase.utilclass;

import com.chai.servicebase.utilbo.TreeData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeUtil {
//    private static String PID = "000000";

	/**
	 * 将平行的树，转化为一颗有层级关系的树
	 * @param list
	 * @param pId
	 * @return
	 */
	public static List<TreeData> getTreeList(List<TreeData> list, String pId){
		if (list == null){
			return null;
		}
		//获取所有头节点
		List<TreeData> rootNode = new ArrayList<>();
		for (TreeData treeData: list ){
			if (treeData.getId().equals(pId)){
				rootNode.add(treeData);
			}
		}
		//头节点不存在的情况
		if (rootNode.size() == 0){
			return getChild(pId,list);
		}
		//头节点存在的情况
		for (TreeData treeData : rootNode){
			String id = treeData.getId();
			treeData.setChild(getChild(id,list));
		}
		return rootNode;
	}
	private static List<TreeData> getChild(String id,List<TreeData> list){
		//找到id节点子节点
		List<TreeData> childList = new ArrayList<>();
		for (TreeData treeData: list){
			if (treeData.getpId().equals(id)){
				childList.add(treeData);
			}
		}
		//给子节点设置子节点
		for (TreeData treeData : childList){
			id = treeData.getId();
			//递归
			treeData.setChild(getChild(id,list));
		}
		if (childList.size() == 0){
			return null;
		}
		return childList;
	}

	/**
	 * 获取指定层级的树
	 * @param treeList
	 * @param level
	 * @return
	 */
	public static List<TreeData> getTreeNodeOnLevel(List<TreeData> treeList,int level){
		if (treeList == null && treeList.size() == 0){
			return  new ArrayList<>();
		}
		ArrayList<TreeData> treeListOnLevel = new ArrayList<>();
		//调用递归方法
		treeList = TreeUtil.recursionQueryTree(treeList, treeListOnLevel, 0,level);
		return treeList;
	}

	/**
	 * 递归查所有指定层级的树节点
	 * @param treeList
	 * @param treeListOnLevel
	 * @param currentLevel
	 * @param level
	 * @return
	 */
	private static List<TreeData> recursionQueryTree(List<TreeData> treeList,List<TreeData> treeListOnLevel,int currentLevel,int level){
		currentLevel++;
		//递归循环查询指定层级树
		for (TreeData treeData : treeList){
			if (currentLevel == level){
				treeListOnLevel.add(treeData);
				continue;
			}
			//递归
			if (treeData.getChild() == null || treeData.getChild().size() == 0){
				continue;
			}
			recursionQueryTree(treeData.getChild(),treeListOnLevel,currentLevel,level);
		}
		return treeListOnLevel;
	}



	/**
	 * 统计一颗树的深度
	 * @param treeList
	 * @return
	 */
	public static int getTreeLevel(List<TreeData> treeList){
		if (treeList == null || treeList.size() == 0){
			return 0;
		}
		//调用递归统计方法
		return TreeUtil.recursionCount(treeList,0,0);
	}

	private static int  recursionCount(List<TreeData> treeList,int currentlevel,int maxlevel){
		currentlevel++;
		//当当前层级大于目前最大层级时覆盖
		if (currentlevel > maxlevel){
			maxlevel = currentlevel;
		}
		//递归遍历节点
		for (TreeData treeData : treeList){
			//如果子节点为空不进行递归
			if (treeData.getChild() == null || treeData.getChild().size() == 0){
				continue;
			}
			//递归
			maxlevel = recursionCount(treeData.getChild(), currentlevel, maxlevel);
		}
		return maxlevel;
	}

	/**
	 * 获取指定id在此树中的层级位置
	 *
	 * @param list 要遍历的树
	 * @param id 要寻找的节点Id
	 * @param rankCount 层级统计器，传入0即可
	 * @return
	 */
	public static Map<String,Object> getNode(List<TreeData> list,String  id,Integer rankCount){
		TreeData node = null;
		//计数器加一
		rankCount++;
		Map<String,Object> map = new HashMap<>();
		map.put("node",node);
		map.put("rankCount",rankCount);
		//如果传入的树为0或返回层级0
		if (list == null || list.size() == 0){
			map.put("rankCount",0);
			return map;
		}
		//遍历树
		for (TreeData treeData : list){
			if (treeData.getId().equals(id)){
				map.put("node",treeData);
				return map;
			}
			if (treeData.getChild() == null || treeData.getChild().size() == 0){
				continue;
			}
			//递归
			Map<String,Object> map1 = getNode(treeData.getChild(),id,rankCount);
			if (map1.get("node") != null){
				return  map1;
			}
		}
		//如果传入的节点是不存在的，返回层级0
		map.put("rankCount",0);
		return map;
	}



}