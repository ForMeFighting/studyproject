package springioc;

/**
 * @Auther: 柴俊杰
 * @Description: 工厂类
 * @Date: 2020/5/28 16:26
 */
public class Factory {

	public static Fruit fruit = null;
	public static Fruit getFruit(String className){
		try {
			fruit = (Fruit)Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fruit;
	}
}
