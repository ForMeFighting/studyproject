package enumtest;

/**
 * @Auther: 柴俊杰
 * @Description: 枚举类简单测试
 * @Date: 2020/9/17 9:50
 */
public enum EnumTest {
	MEMBERS_CHANGE_ADD("0", "待新增", "d");
	private String data;
	private String status;
	private String message;

	private EnumTest(String data, String status, String message) {
		this.data = data;
		this.message = message;
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
