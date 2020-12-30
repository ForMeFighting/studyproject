package datetest;

import java.text.ParseException;
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simpleDateFormat.format(date));
		System.out.println(dateFormat.format(new Date()));
		try {
			System.out.println(dateFormat.format(dateFormat.parse("2019-07-21")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
