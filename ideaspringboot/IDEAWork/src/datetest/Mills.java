package datetest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 柴俊杰
 * @Description: 时间精确到毫秒
 * @Date: 2020/11/12 9:17
 */
public class Mills {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ssss");
		System.out.println(simpleDateFormat.format(date));
	}
}
