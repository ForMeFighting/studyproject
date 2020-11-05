package topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import util.RabbitMqUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: 柴俊杰
 * @Description: 生产者产生消息类
 * RabbitMQ：第二种模型，topic统配route key
 * @Date: 2020/7/29 15:36
 */
public class Provideer {
	@Test
	public void testSendMessage() throws IOException, TimeoutException {
		Connection connection = RabbitMqUtil.getConnection();
		//创建通道
		Channel channel = connection.createChannel();
		//参数1：交换机名称 参数2：交换机类型
		channel.exchangeDeclare("topics", "topic");
		String routekey = "topic.save";
		channel.basicPublish("topics", routekey, null, "exchange type topic send message".getBytes());
		RabbitMqUtil.close(channel, connection);
	}
}
