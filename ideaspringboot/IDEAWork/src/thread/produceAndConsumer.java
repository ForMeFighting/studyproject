package thread;

import java.util.LinkedList;

/**
 * @Auther: 柴俊杰
 * @Description: 消息队列类，java中的线程之间的通信
 * @Date: 2020/5/23 11:16
 */
public class produceAndConsumer {
	public static void main(String[] args) {
		MessageQueue messageQueue = new MessageQueue(2);
		for (int i = 0; i < 3; i++) {
			int id = i;
			new Thread(()->{
				messageQueue.put(new Message(id+"","值"+id));
			},"produce"+i).start();
		}

		new Thread(()->{
			try {
				while (true){
					Thread.sleep(1000);
					Message message = messageQueue.take();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
	class MessageQueue{
	//消息的队列集合
	private LinkedList<Message> linkedList = new LinkedList<>();
	//队列的容量
	private int capcity;

	public MessageQueue(int capcity) {
		this.capcity = capcity;
	}

	//消费消息
	public Message take(){
		synchronized (linkedList) {
			while (linkedList == null){
				try {
					linkedList.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			linkedList.notifyAll();
			return linkedList.removeFirst();
		}
	}
	//存入消息
	public void put(Message message){
		synchronized (linkedList){
			while (linkedList.size() == capcity){
				try {
					linkedList.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			linkedList.addLast(message);
			linkedList.notifyAll();
		}
	}
}
final class Message{
	private String id;
	private Object value;

	public String getId() {
		return id;
	}

	public Object getValue() {
		return value;
	}

	Message(String id, Object value) {
		this.id = id;
		this.value = value;
	}

}

