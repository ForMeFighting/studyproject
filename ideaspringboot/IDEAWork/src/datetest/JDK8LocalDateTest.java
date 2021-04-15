package datetest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @Auther: 柴俊杰
 * @Description: jdk1.8日期类测试
 * @Date: 2021/2/3 13:57
 */
public class JDK8LocalDateTest {
//	public static void main(String[] args) {
//		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//		LocalDate localDate = LocalDate.parse("20200229",dateTimeFormatter);
//		localDate = localDate.plusDays(1);
//		String yyyyMMdd = localDate.format(dateTimeFormatter);
////		System.out.println(yyyyMMdd);
//		Date date = new Date();
//		Date date1 = new Date();
//		try {
//			date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-02");
//			date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-02");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		System.out.println(date.getTime() == date1.getTime());
//	}
public static void main(String[] args) {
	String str="20200101";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	try{
		System.out.println(sdf.parse(str));
	}catch (Exception e){
		System.out.println(e.getMessage());
	}

}
}
