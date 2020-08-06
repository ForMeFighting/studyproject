package springioc;

/**
 * @Auther: 柴俊杰
 * @Description: 测试springioc实现简单原理
 * @Date: 2020/5/28 16:17
 */
public class SptingIoc {
	/**
	 * 测试ioc,主要使用到工厂模式和反射
	 */
	public static void main(String[] args) {
		Fruit fruit = Factory.getFruit("springioc.Apple");
		fruit.eat();
	}
}
