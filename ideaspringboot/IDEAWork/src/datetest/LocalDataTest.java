package datetest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Auther: 柴俊杰
 * @Description: jdk1.8时间测试类
 * @Date: 2020/10/8 10:59
 */
public class LocalDataTest {
	public static void main(String[] args) throws ParseException {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String format = now.format(dateTimeFormatter);
		System.out.println(format);
		LocalDate parse = LocalDate.parse(format,dateTimeFormatter);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"===");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = simpleDateFormat.parse("2020-10-08");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2020-10-08"));
	}
}
