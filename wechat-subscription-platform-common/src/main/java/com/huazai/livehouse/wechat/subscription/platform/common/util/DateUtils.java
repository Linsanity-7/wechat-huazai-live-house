package com.huazai.livehouse.wechat.subscription.platform.common.util;

/**
 * 版权所有：上海睿涉取
 * 项目名称:InvestmentAssistant
 * 创建者: loubin
 * 创建日期: 2010-6-10
 * 文件说明: 常用日期转换函数的封装
 * 最近修改者：loubin
 * 最近修改日期：2010-6-10
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	private static String dateFormat="yyyy-MM-dd HH:mm:ss";

	private static final int DATELENGTH_16 = 16;

	private static final int DATELENGTH_10 = 10;
	/**
	  * @Author: Linshanghua
	  * @Description: strToDate 功能：将指定的字符串转换成日期 输入：aStrValue: 要转换的字符串; aFmtDate: 转换日期的格式,默认为:"yyyy/MM/dd" aDteRtn: 转换后的日期
	  * @Date: 17:57 2018/10/31
	  * @params:
	  * @return:
	  */
	public static Date strToDate(String aStrValue, String aFmtDate) {
		Date aDteRtn = Calendar.getInstance().getTime();
		if (aFmtDate.length() == 0) {
			aFmtDate = "yyyyMMddhhmmss";
		}
		SimpleDateFormat fmtDate = new SimpleDateFormat(aFmtDate);

		try {
			aDteRtn.setTime(fmtDate.parse(aStrValue).getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return aDteRtn;
	}

	public static Date stringToDate(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		Date returnDate = null;
		String format = "";
		if (str.length() > DATELENGTH_16) {
			format = "yyyy-MM-dd HH:mm:ss";
		} else if (str.length() > DATELENGTH_10) {
			format = "yyyy-MM-dd HH:mm";
		} else {
			format = "yyyy-MM-dd";
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			returnDate = sdf.parse(str);
		} catch (ParseException e) {
			e.getMessage();
			return null;
		}
		return returnDate;
	}

	// ***************************************************
	// 名称：dateToStr
	// 功能：将指定的日期转换成字符串
	// 输入：aDteValue: 要转换的日期;
	// aFmtDate: 转换日期的格式, 默认为:"yyyy-MM-dd"
	// 输出：
	// 返回：转换之后的字符串
	// ***************************************************
	public static String dateToStr(Date aDteValue, String aFmtDate) {
		String strRtn = null;

		if (aFmtDate.length() == 0) {
			aFmtDate = "yyyy-MM-dd";
		}
		SimpleDateFormat fmtDate = new SimpleDateFormat(aFmtDate);
		// Format fmtDate = new SimpleDateFormat(aFmtDate);
		// try {
		strRtn = fmtDate.format(aDteValue);
		// } catch (exception e) {
		// return "无录入时间";
		// }
		return strRtn;
	}
	/**
	 * @Title: dateToStr、
	 * @Description:日期转换为字符串
	 * @param dateTime
	 * @param aFmtDate
	 * @return
	 * @return: String
	 */
	public static String dateToStr(long dateTime, String aFmtDate) {
		String strRtn = null;
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(dateTime);
		if (aFmtDate.length() == 0) {
			aFmtDate = "yyyy-MM-dd";
		}
		SimpleDateFormat fmtDate = new SimpleDateFormat(aFmtDate);
		// Format fmtDate = new SimpleDateFormat(aFmtDate);
		// try {
		strRtn = fmtDate.format(calendar.getTime());
		// } catch (exception e) {
		// return "无录入时间";
		// }
		return strRtn;
	}

	public static Date getThisWeekBegin() {
		Calendar beginTimecal = Calendar.getInstance();
		beginTimecal.set(Calendar.DAY_OF_WEEK, 1);
		beginTimecal.set(Calendar.HOUR_OF_DAY, 0);
		beginTimecal.set(Calendar.MINUTE, 0);
		beginTimecal.set(Calendar.SECOND, 0);
		return beginTimecal.getTime();
	}

	public static Date getLastWeekBegin() {
		Calendar beginTimecal = Calendar.getInstance();
		beginTimecal.set(Calendar.WEEK_OF_MONTH,
				Calendar.getInstance().get(Calendar.WEEK_OF_MONTH) - 1);
		beginTimecal.set(Calendar.DAY_OF_WEEK, 1);
		beginTimecal.set(Calendar.HOUR_OF_DAY, 0);
		beginTimecal.set(Calendar.MINUTE, 0);
		beginTimecal.set(Calendar.SECOND, 0);
		return beginTimecal.getTime();
	}

	public static Date getLastWeekEnd() {
		Calendar endTimecal = Calendar.getInstance();
		endTimecal.set(Calendar.WEEK_OF_MONTH,
				Calendar.getInstance().get(Calendar.WEEK_OF_MONTH) - 1);
		endTimecal.set(Calendar.DAY_OF_WEEK, 7);
		endTimecal.set(Calendar.HOUR_OF_DAY, 23);
		endTimecal.set(Calendar.MINUTE, 59);
		endTimecal.set(Calendar.SECOND, 59);
		return endTimecal.getTime();

	}

	/**
	 * 取得今天的最后一个时刻
	 * 
	 * @return 今天的最后一个时刻
	 */
	public static Date currentEndDate() {
		return getEndDate(new Date());
	}

	/**
	 * 取得今天的第一个时刻
	 * 
	 * @return 今天的第一个时刻
	 */
	public static Date currentStartDate() {
		return getStartDate(new Date());
	}

	/**
	 * 获取某天的起始时间, e.g. 2005-10-01 00:00:00.000
	 * 
	 * @param date
	 *            日期对象
	 * @return 该天的起始时间
	 */
	public static Date getStartDate(Date date) {
		if (date == null) {
			return null;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	/**
	 * 获取某天的结束时间, e.g. 2005-10-01 23:59:59.999
	 * 
	 * @param date
	 *            日期对象
	 * @return 该天的结束时间
	 */
	public static Date getEndDate(Date date) {

		if (date == null) {
			return null;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);

		return cal.getTime();
	}

	public static String getEarlyOneMonthFromNow(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		return dateToStr(cal.getTime(), "");
	}

	public static String getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		return dateToStr(cal.getTime(), "");
	}

	public static String getCurrentDateTime() {
		Calendar cal = Calendar.getInstance();
		return dateToStr(cal.getTime(), dateFormat);
	}

	public static String dateToWeek(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Calendar c = Calendar.getInstance();
		String week = "";
		try {
			c.setTime(format.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
			return "日期错误";
		}
		switch (c.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			week = "星期日";
			break;
		case 2:
			week = "星期一";
			break;
		case 3:
			week = "星期二";
			break;
		case 4:
			week = "星期三";
			break;
		case 5:
			week = "星期四";
			break;
		case 6:
			week = "星期五";
			break;
		default:
			week = "星期六";
			break;
		}
		return week;
	}

	public static String getToWeek() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String newDate="";
        Date de=null;
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(new Date());
		} catch (Exception e) {
			e.printStackTrace();
			return "日期错误";
		}
		switch (c.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			//周日
			c.add(Calendar.DATE, -2);
			de = c.getTime();
			newDate=format.format(de);
			break;
		case 7:
			//周六
			c.add(Calendar.DATE, -1);
			de = c.getTime();
			newDate=format.format(de);
			break;
		case 2:
			//周一
			c.add(Calendar.DATE, -3);
			de = c.getTime();
			newDate=format.format(de);
			break;
		default:
			c.add(Calendar.DATE, -1);
			de = c.getTime();
			newDate=format.format(de);
			break;
		}
		return newDate;
	}
	
	/**
	 * @Title: getDayDate、
	 * @Description:根据传入的日期计算前几天，后几天
	 * @param date
	 * @param n
	 * @return
	 * @return: String
	 */
	public static String getDayDate(String dateStr,int n){
		Date date=stringToDate(dateStr);
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, n);
		return dateToStr(calendar.getTime(), "yyyy-MM-dd");
	}
	/**
	 * @Title: getHourDate、
	 * @Description:小时计算
	 * @param dateStr
	 * @param n
	 * @return
	 * @return: String
	 */
	public static String getHourDate(String dateStr,int n){
		Date date=stringToDate(dateStr);
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, n);
		return dateToStr(calendar.getTime(), "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * @Title: getMonthDate、
	 * @Description:月计算
	 * @param dateStr
	 * @param n
	 * @return
	 * @return: String
	 */
	public static String getMonthDate(String dateStr,int n){
		Date date=stringToDate(dateStr);
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return dateToStr(calendar.getTime(), "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * @Title: getDayDate、
	 * @Description:根据传入的日期计算前几天，后几天
	 * @param n
	 * @return
	 * @return: String
	 */
	public static String getDayDate(int n){
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, n);
		return dateToStr(calendar.getTime(), "yyyy-MM-dd");
	}
	public static Date getDate(int n){
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, n);
		return calendar.getTime();
	}
	/**
	 * @Title: getMinuteDate、
	 * @Description:
	 * @param dateStr
	 * @param n
	 * @return
	 * @return: String
	 */
	public static String getMinuteDate(String dateStr,int n){
		return getMinuteDate(dateStr,n,"yyyy-MM-dd HH:mm");
	}
	public static String getMinuteDate(String dateStr,int n,String format){
		Date date=stringToDate(dateStr);
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, n);
		return dateToStr(calendar.getTime(), format);
	}
	/**
	 * @Title: compare、
	 * @Description:比较两个日期大小
	 * @param dateTime1
	 * @param dateTime2
	 * @return -1 小于  1大于  0等于
	 * @return: int
	 */
	public static int compare(String dateTime1,String dateTime2){
		if(dateTime1.compareTo(dateTime2)>0){
			return 1;
		}else if(dateTime1.compareTo(dateTime2)<0){
			return -1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 
	 * @author zhangzhen(J)
	 * @date 2016年8月24日上午10:00:51
	 * @Description: 秒数 转为  时：分：秒
	 */
	public static String formatSencond(int time){
		StringBuffer timeStr = new StringBuffer();  
        int hour = 0;  
        int minute = 0;  
        int second = 0;  
        if (time <= 0) {
            return "";
        } else {
            minute = time / 60;  
            if (minute < 60) {  
                second = time % 60;  
                timeStr.append(unitFormat(minute)).append(":").append(unitFormat(second));  
            } else {  
                hour = minute / 60;  
                if (hour > 99) {
					return "99:59:59";
				}
                minute = minute % 60;  
                second = time - hour * 3600 - minute * 60;  
                timeStr.append(unitFormat(hour)).append(":").append(unitFormat(minute)).append(":").append(unitFormat(second));  
            }  
        }  
        return timeStr.toString();
	}
	private static StringBuffer unitFormat(int i){
		StringBuffer retStr = new StringBuffer();  
        if (i >= 0 && i < 10) {
			retStr.append("0").append(Integer.toString(i));
		} else {
			retStr.append(i);
		}
        return retStr;  
	}
	
	public static void main(String[] args) {

		System.out.println(System.currentTimeMillis());
	}

}
