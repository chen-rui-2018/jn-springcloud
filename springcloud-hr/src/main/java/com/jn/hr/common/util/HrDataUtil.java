package com.jn.hr.common.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;

/**
 * 
 *
 * @author： wangtt
 * @date：Created on  2019/05/07 08:45 
 * @version： v1.0
 * @modified By:
 **/
public class HrDataUtil {
	/**
	 * 求两个数的百分比
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String getPercentStr(int num1, int num2) {
		// 创建一个数值格式化对象
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(2);
		String result = numberFormat.format((float) num1 / (float) num2 * 100);
		return result;
	}

	/**
	 * 求两个数的百分比
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String getDoublePercentStr(Double num1, Double num2) {
		// 创建一个数值格式化对象
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(2);
		String result = numberFormat.format(num1 / num2 * 100);
		return result;
	}

	/**
	 * 获取指定日期的星期
	 * @param num1
	 * @param num2
	 * @return
	 */
	 public static String getWeek(Date date){
		String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if(week_index<0){
		week_index = 0;
		} 
		return weeks[week_index];
	}
	/**
	 * 获取指定日期当天23:59:59
	 * 
	 * @param time
	 * @return
	 */
	public static Date getEndOfDayTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}

	public static Date getPOIDate(boolean use1904windowing, double value) {
		int wholeDays = (int) Math.floor(value);
		int millisecondsInDay = (int) ((value - (double) wholeDays) * 8.64E7D + 0.5D);
		Calendar calendar = new GregorianCalendar();
		short startYear = 1900;
		byte dayAdjust = -1;
		if (use1904windowing) {
			startYear = 1904;
			dayAdjust = 1;
		} else if (wholeDays < 61) {
			dayAdjust = 0;
		}
		calendar.set(startYear, 0, wholeDays + dayAdjust, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, millisecondsInDay);
		if (calendar.get(Calendar.MILLISECOND) == 0) {
			calendar.clear(Calendar.MILLISECOND);
		}
		Date date = calendar.getTime();
		return date;
	}

	public static List<String> getRemoveAll(List<String> a, List<String> b) {
		a.removeAll(b);
		return a;
	}

	// 将字符串转为date时间
	public static Date getDate(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(dateStr);
	}
	
	// 将字符串转为date时间
	public static Date conversionDate(String dateStr) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.parse(dateStr);
	}

	public static Date getDateMonth(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		return sdf.parse(dateStr);
	}

	public static Date formatConversion(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}

	public static Date formatConversionMinute(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 获取某月的第一天和最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Map<String, Date> getFirstdayLastdayMonth(String time) {
		Date date = null;
		try {
			date = getDateMonth(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// calendar.add(Calendar.MONTH, -1);
		Date firstDate = calendar.getTime();

		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, 1);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date lastDate = calendar.getTime();

		Map<String, Date> map = new HashMap<String, Date>();
		map.put("first", firstDate);
		map.put("last", lastDate);
		return map;
	}

	/**
	 * 获得两个Date类型日期之间的时间差(秒)
	 * 
	 * @param date1
	 * @param date2
	 * @return 两个Date类型日期之间的时间秒差
	 */
	public static long betweenDates(Date date1, Date date2) {
		long v1 = date1.getTime();
		long v2 = date2.getTime();

		if (v1 > v2) {
			return Math.abs(v1 - v2) / 1000;
		} else {
			return Math.abs(v2 - v1) / 1000;
		}
	}

	// 获取上个月时间
	public static Date getLastdayMonth(String time) {

		Date date = null;
		try {
			date = getDateMonth(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// 上个月第一天
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DATE, 1);
		calendar.add(Calendar.DATE, 1);
		// DateUtils.formatDate(calendar.getTime(),"yyyy-mm");
		return calendar.getTime();
	}

	/**
	 * 获得指定日期的前一天
	 * 
	 * @param specifiedDay
	 * @return
	 * @throws Exception
	 */
	public static String getSpecifiedDayBefore(Date date) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);

		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayBefore;
	}

	public static Date getBeforeDay(Date date) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);

		return c.getTime();
	}

	public static String getDayBefore(Date date) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);

		String dayBefore = new SimpleDateFormat("yyyy-MM").format(c.getTime());
		return dayBefore;
	}

	/***
	 * 求两个字符串的相似度
	 * 
	 * 完全相似=1.0
	 * 完全不相似=0.0
	 */
	public static float getSimilarityRatio(String str, String target, float achievement) {
		float a = 1 - (float) compare(str, target) / Math.max(str.length(), target.length());
		return (float) a * achievement;
	}

	private static int compare(String str, String target) {
		int d[][]; // 矩阵
		int n = str.length();
		int m = target.length();
		int i; // 遍历str的
		int j; // 遍历target的
		char ch1; // str的
		char ch2; // target的
		int temp; // 记录相同字符,在某个矩阵位置值的增量,不是0就是1
		if (n == 0) {
			return m;
		}
		if (m == 0) {
			return n;
		}
		d = new int[n + 1][m + 1];
		for (i = 0; i <= n; i++) { // 初始化第一列
			d[i][0] = i;
		}
		for (j = 0; j <= m; j++) { // 初始化第一行
			d[0][j] = j;
		}
		for (i = 1; i <= n; i++) { // 遍历str
			ch1 = str.charAt(i - 1);
			// 去匹配target
			for (j = 1; j <= m; j++) {
				ch2 = target.charAt(j - 1);
				if (ch1 == ch2) {
					temp = 0;
				} else {
					temp = 1;
				}
				// 左边+1,上边+1, 左上角+temp取最小
				d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
			}
		}
		return d[n][m];
	}

	private static int min(int one, int two, int three) {
		return (one = one < two ? one : two) < three ? one : three;
	}

	/**
	 * 对答案列表排序
	 * @param str
	 * @return
	 */
	public static String getAnswerStr(String str) {
		List<String> list = new ArrayList<>();
		if (!StringUtils.isBlank(str)) {
			String[] strList = str.toUpperCase().split(",");
			for (String strs : strList) {
				list.add(strs);
			}
			Collections.sort(list);
		}
		if (null != list && list.size() > 0) {
			str = list.toString().substring(1, list.toString().length() - 1);
		}
		return str;
	}

	/**
	 * 计算选择题分数
	 * @param answer
	 * @param standardAnswer
	 * @param score
	 * @return
	 */
	public static float examinee(String answer, String standardAnswer, float score) {
		answer = answer.toUpperCase();
		standardAnswer = standardAnswer.toUpperCase();
		float newScore = 0f;
		if (standardAnswer.length() == 1) {
			// 单选
			if (standardAnswer.equals(answer)) {
				newScore = score;
			}
		} else {
			// 多选题
			if (answer.length() < standardAnswer.length()) {
				if (answer.length() > 0) {
					// 判断answerArr中的字符是否全在standardAnswerArr中如果是就得一半分
					char[] answerArr = answer.toCharArray();
					// 标志，一旦有一个字符不在standardAnswerArr中 就变为 0,不得分
					int flag = 1;
					for (int i = 0; i < answerArr.length; i++) {
						if (standardAnswer.indexOf(String.valueOf(answerArr[i])) == -1) {
							flag = 0;
						}
					}
					if (flag == 1) {
						newScore = score / 2;
					}
				}
			} else if (answer.length() == standardAnswer.length()) {
				// 判断answerArr中的字符是否全在standardAnswerArr中 如果是就得全分
				char[] answerArr = answer.toCharArray();
				// 标志，一旦有一个字符不在standardAnswerArr中 就变为 0,不得分
				int flag = 1;
				for (int i = 0; i < answerArr.length; i++) {
					if (standardAnswer.indexOf(String.valueOf(answerArr[i])) == -1) {
						flag = 0;
					}
				}
				if (flag == 1) {
					newScore = score;
				}
			}
		}
		return newScore;
	}

}
