package datetest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: 柴俊杰
 * @Description: 根据时间拆分新的时间段
 * @Date: 2021/2/22 8:54
 */
public class DateMakeNew {
	public static void main(String[] args) throws Exception {
		String strOne = "2020-11-01";
		String strTwo = "2020-11-30";
		String strThree = "2020-10-01";
		String strFour = "2020-11-30";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date one = simpleDateFormat.parse(strOne);
		Date two = simpleDateFormat.parse(strTwo);
		Date three = simpleDateFormat.parse(strThree);
		Date four = simpleDateFormat.parse(strFour);
		Set<DateMake> dateMakes = makeNewDate(one, two, three, four);
		for (DateMake date:dateMakes) {
			System.out.println(simpleDateFormat.format(date.getStartDate())+"========"+simpleDateFormat.format(date.getEndDate()));
		}
	}


	/**
	* @author:         柴俊杰
	* @Description:    根据现有的时间，拆分成新的时间段
	 * 					比如说：现有的时间段为2020-11-01至2020-11-31 如果新的参数为 2020-10-01至2020-10-31 或 2020-12-01至2020-12-31 则直接添加
	 * 					如果传入的时间段为 2020-11-15至2020-12-15 拆分为	2020-11-15至2020-11-31 和 2020-12-01至2020-12-15
	 * 				只要有交集就拆分
	* @date:           2021/2/22 8:56
	*/
	private static Set<DateMake> makeNewDate(Date one, Date two, Date three, Date four) throws ParseException {
		Set<DateMake> dateList = new HashSet<>();
		DateMake dateMake = new DateMake();
		//如果新参数和原参数的开始和结束时间一样  则返回
		if(three.getTime() == one.getTime() && four.getTime() == two.getTime()){
			dateMake.setStartDate(one);
			dateMake.setEndDate(two);
			dateList.add(dateMake);
			return dateList;
		}
		//1.如果新参数的结束时间小于等于原先的开始时间 或者 新参数的开始时间大于等于原先的结束时间 表明时间只有临界值有交集
		if(three.getTime() >= two.getTime() || four.getTime() <= two.getTime()){
			//如果新参数的结束时间等于原参数的开始时间 或者 新参数的开始时间等于原参数的结束时间  则拆分
			if(three.getTime() == two.getTime()){
				dateMake.setStartDate(one);
				dateMake.setEndDate(subDay(two));
				dateList.add(dateMake);
				dateMake.setStartDate(subDay(three));
				dateMake.setEndDate(four);
				dateList.add(dateMake);
				return dateList;
			}else if(four.getTime() == two.getTime()){
				dateMake.setStartDate(addDay(one));
				dateMake.setEndDate(two);
				dateList.add(dateMake);
				dateMake.setStartDate(three);
				dateMake.setEndDate(addDay(four));
				dateList.add(dateMake);
				return dateList;
			}else {
				dateMake.setStartDate(one);
				dateMake.setEndDate(two);
				dateList.add(dateMake);
				dateMake.setStartDate(three);
				dateMake.setEndDate(four);
				dateList.add(dateMake);
				return dateList;
			}
		}else if(one.getTime() > three.getTime() && two.getTime() < four.getTime()){
			//如果新参数的开始时间比原参数的开始时间小，并且新参数的结束时间比原参数的结束时间大 则
			dateMake.setStartDate(three);
			dateMake.setEndDate(four);
			dateList.add(dateMake);
			return dateList;
		}else if(one.getTime() < three.getTime() && two.getTime() > four.getTime()){
			//如果新参数的开始时间比原参数的开始时间大并且新参数的结束时间比原参数的结束时间段，则拆分
			dateMake.setStartDate(three);
			dateMake.setEndDate(subDay(three));
			dateList.add(dateMake);
			dateMake.setStartDate(three);
			dateMake.setEndDate(four);
			dateList.add(dateMake);
			dateMake.setStartDate(addDay(three));
			dateMake.setEndDate(two);
			dateList.add(dateMake);
			return dateList;
		}else if(three.getTime() >= one.getTime() && three.getTime() <= two.getTime() && four.getTime() >= two.getTime()){
			//如果新参数的开始时间在原参数的时间区间，并且新参数的结束时间在原参数的结束时间之外
			dateMake.setStartDate(one);
			dateMake.setEndDate(subDay(three));
			dateList.add(dateMake);
			dateMake.setStartDate(three);
			dateMake.setEndDate(four);
			dateList.add(dateMake);
			return dateList;
		}else if(four.getTime() >= one.getTime() && four.getTime() <= two.getTime() && one.getTime() >= three.getTime()){
			//如果新参数的结束时间在原参数的时间区间，并且新参数的开始时间在原参数的开始时间之外
			dateMake.setStartDate(three);
			dateMake.setEndDate(four);
			dateList.add(dateMake);
			dateMake.setStartDate(addDay(four));
			dateMake.setEndDate(two);
			dateList.add(dateMake);
			return dateList;
		}
		return null;
	}

	//根据传进来的时间进行减一天
	private static Date subDay(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(sdf.format(date));
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		rightNow.add(Calendar.DAY_OF_MONTH, -1);
		Date dt1 = rightNow.getTime();
		return dt1;
	}
	//根据传进来的时间进行加一天
	private static Date addDay(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(sdf.format(date));
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		rightNow.add(Calendar.DAY_OF_MONTH, 1);
		Date dt1 = rightNow.getTime();
		return dt1;
	}
}
class DateMake{
	private Date startDate;
	private Date endDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "DateMake{" +
				"startDate=" + startDate +
				", endDate=" + endDate +
				'}';
	}
}