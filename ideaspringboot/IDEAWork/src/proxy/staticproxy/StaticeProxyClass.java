package proxy.staticproxy;

/**
 * @Auther: 柴俊杰
 * @Description: 静态代理测试类
 * @Date: 2020/7/10 9:18
 */
public class StaticeProxyClass {
	public static void main(String[] args) {
		Orange orange = new Orange();
		ProxyClass proxyClass = new ProxyClass(orange);
		proxyClass.eat();

	}
}
