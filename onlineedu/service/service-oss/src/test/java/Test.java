import com.chai.ossservice.util.ConstantPropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 柴俊杰
 * @Description:
 * @Date: 2021/5/13 14:02
 */
public class Test {
	@Autowired
	private ConstantPropertiesUtil constantPropertiesUtil;
	@org.junit.Test
	public void Data(){
		System.out.println(constantPropertiesUtil.toString());
	}
}
