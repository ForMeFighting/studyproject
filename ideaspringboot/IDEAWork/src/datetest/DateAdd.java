package datetest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: 柴俊杰
 * @Description: 测试时间增加一天或者减少一天
 * @Date: 2021/2/20 16:39
 */
public class DateAdd {
	public static void main(String[] args) throws ParseException {
		String str = "2020-12-31";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = simpleDateFormat.parse(str);
		Date date1 = subDay(date);
		System.out.println(simpleDateFormat.format(date1));
	}
		private static Date subDay(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(sdf.format(date));
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		rightNow.add(Calendar.DAY_OF_MONTH, 1);
		Date dt1 = rightNow.getTime();
		return dt1;
	}
}
