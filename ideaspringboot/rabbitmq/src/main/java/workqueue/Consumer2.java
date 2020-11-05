package workqueue;

import com.rabbitmq.client.*;
import util.RabbitMqUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: 柴俊杰
 * @Description: 消费者
 * @Date: 2020/7/29 16:10
 */
public class Consumer2 {

	public static void main(String[] args) throws IOException, TimeoutException {
		Connection connection = RabbitMqUtil.getConnection();
		//创建通道
		final Channel channel = connection.createChannel();
		//创建队列
		//参数1：队列名称 参数2：是否持久化 参数3：是否独占 参数4：是否自动删除 参数5：额外参数
		channel.queueDeclare("work", true, false, false, null);
		//如果自动确认，默认是循环执行，一次性确认多条数据，如果此时宕机，就会发生消息丢失
		//所以需要将ack设置为false
//		channel.basicConsume("work",true,new DefaultConsumer(channel){
		channel.basicQos(1);
		channel.basicConsume("work", false, new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				System.out.println("=====消费2========" + new String(body));
				//关闭自动确认后，需要手动确认，
				//参数1：确认的消息的标志，参数2：是否开启多条消息同时确认
				channel.basicAck(envelope.getDeliveryTag(), false);
			}
		});
//		channel.close();
//		connection.close();
	}
}
