package datetest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 柴俊杰
 * @Description: 根据时间段拆分
 * @Date: 2021/3/11 15:42
 */
public class MakeDateTest {
	public static void main(String[] args) {
		List<DateBos> coDate = new ArrayList<>();
		DateBos dateBos = new DateBos();
		dateBos.setBeginDate("2020-03-01");
		dateBos.setEndDate("2020-03-15");
		coDate.add(dateBos);
		DateBos dateBos1 = new DateBos();
		dateBos1.setBeginDate("2020-03-21");
		dateBos1.setEndDate("2020-03-25");
		coDate.add(dateBos1);

		List<DateBos> originDate = new ArrayList<>();
		DateBos dateBos2 = new DateBos();
		dateBos2.setBeginDate("2020-03-01");
		dateBos2.setEndDate("2020-03-10");
		originDate.add(dateBos2);
		DateBos dateBos3 = new DateBos();
		dateBos3.setBeginDate("2020-03-11");
		dateBos3.setEndDate("2020-03-20");
		originDate.add(dateBos3);
		DateBos dateBos4 = new DateBos();
		dateBos4.setBeginDate("2020-03-21");
		dateBos4.setEndDate("2020-03-30");
		originDate.add(dateBos4);

		String strFormat = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (DateBos bos:coDate) {

		}



	}

}
class DateBos{
	private String beginDate;
	private String endDate;

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
