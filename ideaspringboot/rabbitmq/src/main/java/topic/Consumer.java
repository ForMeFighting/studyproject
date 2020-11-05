package topic;

import com.rabbitmq.client.*;
import util.RabbitMqUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: 柴俊杰
 * @Description: 消费者
 * @Date: 2020/7/29 16:10
 */
public class Consumer {

	public static void main(String[] args) throws IOException, TimeoutException {
		Connection connection = RabbitMqUtil.getConnection();
		//创建通道
		Channel channel = connection.createChannel();
		//通道绑定交换机
		channel.exchangeDeclare("topics", "topic");
		//创建临时队列
		String queue = channel.queueDeclare().getQueue();
		//绑定队列
		channel.queueBind(queue, "topics", "topic.*");
		//消费消息
		channel.basicConsume(queue, true, new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				System.out.println("消费者1" + new String(body));
			}
		});

	}
}
