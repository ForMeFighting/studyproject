package direct;

import com.rabbitmq.client.*;
import org.junit.Test;
import util.RabbitMqUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: 柴俊杰
 * @Description: 消费者
 * @Date: 2020/7/29 16:10
 */
public class Consumer {
	@Test
	public void testConsumer() throws IOException, TimeoutException {
		//产生连接工厂
		ConnectionFactory connectionFactory = new ConnectionFactory();
		//绑定地址
		connectionFactory.setHost("192.168.88.128");
		//绑定端口
		connectionFactory.setPort(5672);
		//绑定虚拟主机
		connectionFactory.setVirtualHost("/ems");
		//设置用户名和密码
		connectionFactory.setUsername("ems");
		connectionFactory.setPassword("ems");
		//从连接工厂中创建连接
		Connection connection = connectionFactory.newConnection();
		//创建通道
		Channel channel = connection.createChannel();
		//创建队列
		//参数1：队列名称 参数2：是否持久化 参数3：是否独占 参数4：是否自动删除 参数5：额外参数
		channel.queueDeclare("hello",false,false,false,null);
		channel.basicConsume("hello",true,new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				System.out.println("================"+new String(body));
			}
		});
//		channel.close();
//		connection.close();
	}

	public static void main(String[] args) throws IOException, TimeoutException {
		//产生连接工厂
//		ConnectionFactory connectionFactory = new ConnectionFactory();
		//绑定地址
//		connectionFactory.setHost("192.168.88.128");
		//绑定端口
//		connectionFactory.setPort(5672);
		//绑定虚拟主机
//		connectionFactory.setVirtualHost("/ems");
		//设置用户名和密码
//		connectionFactory.setUsername("ems");
//		connectionFactory.setPassword("ems");
		//从连接工厂中创建连接
//		Connection connection = connectionFactory.newConnection();
		Connection connection = RabbitMqUtil.getConnection();
		//创建通道
		Channel channel = connection.createChannel();
		//创建队列
		//参数1：队列名称 参数2：是否持久化 参数3：是否独占 参数4：是否自动删除 参数5：额外参数
		channel.queueDeclare("aa",true,false,true,null);
		channel.basicConsume("aa",true,new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				System.out.println("================"+new String(body));
			}
		});
//		channel.close();
//		connection.close();
	}
}
