package datetest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 柴俊杰
 * @Description: 得到两个日期之前所有的时间段
 * @Date: 2020/10/20 9:07
 */
public class GetBetweenDate {
	public static void main(String[] args) {
		List<Date> betweenDates = new ArrayList<>();
		try {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(simpleDateFormat.format(date));
			System.out.println(dateFormat.parse(simpleDateFormat.format(date)));
			betweenDates = getBetweenDates(new SimpleDateFormat("yyyyMMdd").parse("20201010"),
					new SimpleDateFormat("yyyyMMdd").parse("20201015"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < betweenDates.size(); i++) {
//			System.out.println(betweenDates.get(i));
		}
	}

	public static List<Date> getBetweenDates(Date start, Date end) {
		List<Date> result = new ArrayList<Date>();
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(start);
//		tempStart.add(Calendar.DAY_OF_YEAR, 1);

		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(end);
		while (tempEnd.after(tempStart)) {
			result.add(tempStart.getTime());
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
		}
		result.add(end);
		return result;
	}
}
