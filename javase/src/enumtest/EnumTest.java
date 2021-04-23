package enumtest;

/**
 * @Author: 柴俊杰
 * @Description: 枚举类测试
 * @Date: 2021/4/21 17:30
 */
public enum  EnumTest {
	//TODO 如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。而且 Java 要求必须先定义 enum 实例。
	RESULT_MESSAGE(0,"成功");
	private String message;
	private int code;
	EnumTest(int code,String message){
		this.code = code;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
