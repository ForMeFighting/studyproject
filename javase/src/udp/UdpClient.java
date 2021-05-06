package udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @Author: 柴俊杰
 * @Description: udp客户端
 * @Date: 2021/4/27 15:46
 */
public class UdpClient {
	/**
	 * 1.使用DatagramSocket指定端口 创建发送端
	 * 2.准备数据，一定转成字节数组
	 * 3.封装成DatagramPacket包裹，需要指定目的地
	 * 4.发送包裹send(DatagramPacket p)
	 * 5.释放资源
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中.....");
		//1.使用DatagramSocket指定端口 创建发送端
		DatagramSocket datagramSocket = new DatagramSocket(8888);
		//2.准备数据，一定转成字节数组
//		String str = "测试数据";
//		byte[] bytes = str.getBytes();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String readLine = bufferedReader.readLine();
		byte[] bytes = readLine.getBytes();
		//3.封装成DatagramPacket包裹，需要指定目的地
		DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,
				new InetSocketAddress("localhost",9999));
		//4.发送包裹send(DatagramPacket p)
		datagramSocket.send(datagramPacket);
		//5.释放资源
		datagramSocket.close();
	}
}
