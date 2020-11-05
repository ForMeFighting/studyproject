package direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.junit.Test;
import util.RabbitMqUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: 柴俊杰
 * @Description: 生产者产生消息类
 * RabbitMQ：第一种模型，The simplest thing that does something，最简单的一种，不需要交换机，直连模型
 * @Date: 2020/7/29 15:36
 */
public class Provideer {
	@Test
	public void testSendMessage() throws IOException, TimeoutException {
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
		//参数1：队列名称 参数2：队列是否持久化，只保证队列，不保证消息 参数3：是否独占 参数4：是否自动删除 参数5：额外参数
		channel.queueDeclare("aa", true, false, true, null);
		//参数1：交换机名称 参数2：队列名称，参数3：传递消息额外设置，参数4：消息的具体内容
		channel.basicPublish("", "aa", MessageProperties.PERSISTENT_TEXT_PLAIN, "hello rabbitmq,i come".getBytes());//MessageProperties.PERSISTENT_TEXT_PLAIN表示的是消息的持久化
		RabbitMqUtil.close(channel, connection);
	}
}
