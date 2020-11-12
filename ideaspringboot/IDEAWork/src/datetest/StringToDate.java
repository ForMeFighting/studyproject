package datetest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 柴俊杰
 * @Description: 字符串转换成日期类型
 * @Date: 2020/10/20 15:39
 */
public class StringToDate {
	/**
	 * 将字符串时间格式转换成Date时间格式，参数String类型
	 * 比如字符串时间："2017-12-15 21:49:03"
	 * 转换后的date时间：Fri Dec 15 21:49:03 CST 2017
	 *
	 * @param datetime 类型为String
	 * @return
	 */
	public static Date StringToDate(String datetime) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = sdFormat.parse(datetime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static void main(String[] args) {
//		System.out.println(StringToDate("2020-10-01".substring(0, 10)));
		try {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-11-01T12:27:10.323+0800".substring(0,10)+" "+ "2020-11-01T12:27:10.323+0800".substring(11,19)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
