package util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: 柴俊杰
 * @Description: 消息队列创建连接公共类
 * @Date: 2020/7/30 10:26
 */
public class RabbitMqUtil {
	private RabbitMqUtil(){

	}
	private static ConnectionFactory connectionFactory;
	static {
		connectionFactory = new ConnectionFactory();
		//绑定地址
		connectionFactory.setHost("192.168.88.129");
		//绑定端口
		connectionFactory.setPort(5672);
		//绑定虚拟主机
		connectionFactory.setVirtualHost("/ems");
		//设置用户名和密码
		connectionFactory.setUsername("ems");
		connectionFactory.setPassword("ems");
	}
	public static Connection getConnection() throws IOException, TimeoutException {
		return connectionFactory.newConnection();
	}
	public static void close(Channel channel,Connection connection) throws IOException, TimeoutException {
		if(channel!=null) {channel.close();}
		if(connection!=null) {connection.close();}
	}
}
