package datetest;

import java.util.*;

/**
 * @Auther: 柴俊杰
 * @Description: 判断一个日期类型的集合是否存在交叉时间
 * @Date: 2020/10/21 15:41
 */
public class IsExistJCDate {
	public static void main(String[] args) {
		List<DateBo> dateBoList = new ArrayList<>();
		DateBo dateBo = new DateBo();
		dateBo.setBegin("2020-10-01");
		dateBo.setEnd("2020-10-10");
		dateBoList.add(dateBo);
		boolean exiextDate = isExiextDate(dateBoList);
		System.out.println(exiextDate);
		DateBo dateBo1 = new DateBo();
		dateBo1.setBegin("2020-10-11");
		dateBo1.setEnd("2020-10-15");
		dateBoList.add(dateBo1);
		exiextDate = isExiextDate(dateBoList);
		System.out.println(exiextDate);
	}

	private static boolean isExiextDate(List<DateBo> dateBoList) {
		Set<Date> set = new HashSet();
		boolean flag = true;
		for (DateBo dateBo : dateBoList) {
			Date begin = StringToDate.StringToDate(dateBo.getBegin().substring(0, 10));
			Date end = StringToDate.StringToDate(dateBo.getEnd().substring(0, 10));
			List<Date> betweenDates = GetBetweenDate.getBetweenDates(begin, end);
			for (int i = 0; i < betweenDates.size(); i++) {
				if (!flag) {
					return flag;
				}
				flag = set.add(betweenDates.get(i));
			}
		}
		return flag;
	}
}

class DateBo {
	private String begin;
	private String end;

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
}
