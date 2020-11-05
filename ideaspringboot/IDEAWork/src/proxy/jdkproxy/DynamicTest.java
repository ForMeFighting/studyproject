package proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @Auther: 柴俊杰
 * @Description: jdk动态代理测试类
 * @Date: 2020/7/10 9:56
 */
public class DynamicTest {
	public static void main(String[] args) {
		Animal animal = new Dog();
		DynamicProxy dynamicProxy = new DynamicProxy(animal);
		Animal newProxyInstance = (Animal) Proxy.newProxyInstance(Dog.class.getClassLoader(), Dog.class.getInterfaces(), dynamicProxy);
		newProxyInstance.eat();
	}
}
