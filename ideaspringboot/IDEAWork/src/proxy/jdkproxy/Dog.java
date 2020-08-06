package proxy.jdkproxy;

/**
 * @Auther: 柴俊杰
 * @Description: dog实现类
 * @Date: 2020/7/10 9:53
 */
public class Dog implements Animal{
	@Override
	public void eat() {
		System.out.println("狗是吃骨头的！！");
	}
}
