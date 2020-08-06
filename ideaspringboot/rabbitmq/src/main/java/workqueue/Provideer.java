package workqueue;

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
 * RabbitMQ：第二种模型，任务队列
 * @Date: 2020/7/29 15:36
 */
public class Provideer {
	@Test
	public void testSendMessage() throws IOException, TimeoutException {
		Connection connection = RabbitMqUtil.getConnection();
		//创建通道
		Channel channel = connection.createChannel();
		//创建队列
		//参数1：队列名称 参数2：队列是否持久化，只保证队列，不保证消息 参数3：是否独占 参数4：是否自动删除 参数5：额外参数
		channel.queueDeclare("work",true,false,false,null);
		//参数1：交换机名称 参数2：队列名称，参数3：传递消息额外设置，参数4：消息的具体内容
		for (int i = 0; i < 20; i++) {
			channel.basicPublish("","work", null,(i+"hello rabbitmq,i come").getBytes());//MessageProperties.PERSISTENT_TEXT_PLAIN表示的是消息的持久化
		}
		RabbitMqUtil.close(channel,connection);
	}
}
