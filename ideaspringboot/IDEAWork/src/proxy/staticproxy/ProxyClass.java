package proxy.staticproxy;

/**
 * @Auther: 柴俊杰
 * @Description: 代理类
 * @Date: 2020/7/10 9:22
 */
public class ProxyClass implements Fruit{
	Orange orange = null;
	public ProxyClass(Orange orange){
		this.orange = orange;
	}
	@Override
	public void eat() {
		System.out.println("ProxyClass startting");
		orange.eat();
		System.out.println("ProxyClass ending");
	}
}
