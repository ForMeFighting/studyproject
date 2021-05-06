package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author: 柴俊杰
 * @Description: UDP服务端
 * @Date: 2021/4/27 15:40
 */
public class UdpServer {
	/**
	 * 1.使用DatagramSocket指定端口 创建接收端
	 * 2.准备容器，封装成DatagramPacket包裹，
	 * 3.阻塞式接受包裹，receive(DatagramPacket p)
	 * 4.分析数据
	 * 	byte[] getData()
	 * 		getLength()
	 * 5.释放资源
	 */
	public static void main(String[] args) throws Exception {
		DatagramSocket server = new DatagramSocket(9999);
		byte[] bytes = new byte[1024*60];
		DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length);
		server.receive(datagramPacket);
		byte[] data = datagramPacket.getData();
		int len = datagramPacket.getLength();
		System.out.println(new String(data,0,len));

	}
}
