package collection;

import exception.SelfException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Author: 柴俊杰
 * @Description: 手写ArrayList
 * @Date: 2021/4/22 19:32
 */
public class SelfArrayList<E> implements Serializable {
	private int size;
	transient private Object[] elementData;
	private static final int DEFALUT_SIZE = 10;
	SelfArrayList(){
		elementData = new Object[DEFALUT_SIZE];
	}
	SelfArrayList(int size){
		if(size < 0){
			new SelfException("Illegal Capacity: "+
					0);
		}
		elementData = new Object[size];
	}
	public E add(E value){
		if(size == elementData.length){
			//扩容为原先的1.5倍
			Object[] newArray = new Object[elementData.length + (elementData.length << 1)];
			System.arraycopy(elementData,0,newArray,0,elementData.length);
			elementData = newArray;
		}
		elementData[size++] = value;
		return value;
	}
	public E get(int index){
		return (E)elementData[index];
	}
	public E set(int index,E value){
		elementData[index] = value;
		return value;
	}
	public E remove(int index){
		int numMoved = elementData.length - index - 1;
		if(numMoved > 0){//说明移除的不是最后一个
			System.arraycopy(elementData,index+1,elementData,index,numMoved);

		}
		elementData[--size] = null;
		return (E)elementData[index];
	}
}
