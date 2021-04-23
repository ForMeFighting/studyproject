package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: 柴俊杰
 * @Description: 测试顶级接口collection的方法
 * @Date: 2021/4/22 19:29
 */
public class TestCollection {
	public static void main(String[] args) {
		Collection collection = new ArrayList();
		collection.add("aaa");
		int size = collection.size();
		collection.addAll(new ArrayList());
		collection.contains("aaa");
		collection.clear();
		Iterator iterator = collection.iterator();
		if(iterator.hasNext()){
			Object next = iterator.next();
			System.out.println(next);
		}

	}
}
