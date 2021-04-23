package collection;

/**
 * @Author: 柴俊杰
 * @Description: 测试泛型
 * @Date: 2021/4/22 14:53
 */
public class TestGeneric {
	public static void main(String[] args) {
		MyCollection<Integer> myCollection = new MyCollection();
		myCollection.setIndex(1);
		myCollection.setName(333);
		System.out.println(myCollection.toString());

	}
}
class MyCollection<E>{
	private int index;
	private E name;
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public E getName() {
		return name;
	}

	public void setName(E name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[index"+index+",name"+name+"]";
	}
}