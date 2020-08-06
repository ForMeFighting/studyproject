package fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import util.RabbitMqUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: 柴俊杰
 * @Description: 生产者产生消息类
 * RabbitMQ：第二种模型，广播模型
 * @Date: 2020/7/29 15:36
 */
public class Provideer {
	@Test
	public void testSendMessage() throws IOException, TimeoutException {
		Connection connection = RabbitMqUtil.getConnection();
		//创建通道
		Channel channel = connection.createChannel();
		//参数1：交换机名称 参数2：交换机类型
		channel.exchangeDeclare("logs","fanout");
		channel.basicPublish("logs","",null,"exchange type fanout send message".getBytes());
		RabbitMqUtil.close(channel,connection);
	}
}
