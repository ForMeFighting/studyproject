package JsonTest;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

/**
 * @Auther:chaijunjie
 * @Date:2019/10/30
 * @Description:JsonTest
 * @version:1.0
 */
public class JsonTest {
	private static String jsonStr = "{\"name\":\"zhangshan\", \"age\": 10, \"address\": \"中国深圳\"}";

	public static void main(String[] args) {

		//JSON-LIB
		JSONObject jsonResult = JSONObject.fromObject(jsonStr);
		UserInfo userInfo = (UserInfo) JSONObject.toBean(jsonResult, UserInfo.class);
		System.out.println("userInfo:" + userInfo);

		//fastjson
		com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(jsonStr);
		UserInfo userInfo2 = com.alibaba.fastjson.JSONObject.toJavaObject(jsonObject, UserInfo.class);
		System.out.println("userInfo2:" + userInfo2);
	}
}
