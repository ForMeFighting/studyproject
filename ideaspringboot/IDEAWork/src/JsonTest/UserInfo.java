package JsonTest;

/**
 * @Auther:chaijunjie
 * @Date:2019/10/30
 * @Description:JsonTest
 * @version:1.0
 */
public class UserInfo {
	private String name;
	private int age;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
}
