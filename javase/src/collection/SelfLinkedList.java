package collection;

import java.util.LinkedList;

/**
 * @Author: 柴俊杰
 * @Description: 自定义LinkedList
 * @Date: 2021/4/23 13:49
 */
public class SelfLinkedList<E> {
	transient int size;
	transient Node<E> first;
	transient Node<E> last;
	private static class Node<E>{
		E item;
		Node<E> prev;
		Node<E> next;
		public Node(SelfLinkedList.Node<E> prev, E element, SelfLinkedList.Node<E> next){
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}
}
