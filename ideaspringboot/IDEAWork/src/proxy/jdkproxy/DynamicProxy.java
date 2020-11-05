package proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: 柴俊杰
 * @Description: 动态代理实现类
 * @Date: 2020/7/10 9:54
 */
public class DynamicProxy implements InvocationHandler {
	Animal animal = null;

	DynamicProxy(Animal animal) {
		this.animal = animal;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("狗吃东西之前");
		method.invoke(animal, args);
		System.out.println("狗吃东西之后");
		return null;
	}
}
