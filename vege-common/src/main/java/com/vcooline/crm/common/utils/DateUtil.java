package com.vcooline.crm.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtil extends DateUtils{
	private static Log logger = LogFactory.getLog(DateUtil.class);

	public final static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public final static String DEFAULT_YMD_FORMAT = "yyyy-MM-dd";

	private final static SimpleDateFormat FORMAT = new SimpleDateFormat(DEFAULT_FORMAT);

	// 字符串转换到时间格式
	public static Date strToDate(String dateStr, String formatStr) {
		if (null == dateStr || "".equals(dateStr))
			return null;
		DateFormat sdf = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			logger.warn(e.getMessage());
		}
		return date;
	}

	// 日期转成字符串,指定日期格式
	public static String dateToStr(Date date, String format) {
		if (date != null) {
			DateFormat df = new SimpleDateFormat(format);
			return df.format(date);
		} else {
			return null;
		}
	}

	// 日期转成字符串,返回默认的yyyy-MM-dd HH:mm:ss格式
	public static String dateToStr(Date date) {
		if (date != null) {
			return dateToStr(date, DEFAULT_FORMAT);
		} else {
			return null;
		}
	}

	/**
	 * 比较两个日期的大小
	 * 
	 * @param first
	 *            第一个日期
	 * @param secend
	 *            第二个日期
	 * @param seconds
	 *            第一个日期与第二个日期相差的秒数,第一个日期加上该秒数比较，正数相加，负数相减
	 * @return 如果第一个日期小于第二个日期，返回-1,大于，返回1，等于返回0
	 */
	public static int compareDate(String first, String secend, int seconds) {
		int result = 0;
		try {
			Date firstDate = FORMAT.parse(first);
			Calendar calFirst = Calendar.getInstance();
			calFirst.setTimeInMillis(firstDate.getTime());
			calFirst.add(Calendar.SECOND, seconds);
			firstDate = calFirst.getTime();
			Date secendDate = FORMAT.parse(secend);
			if (firstDate.before(secendDate)) {
				result = -1;
			} else if (firstDate.after(secendDate)) {
				result = 1;
			} else {
				result = 0;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

    /**
     * 比较两个日期的大小
     *
     * @param first
     *            第一个日期
     * @param secend
     *            第二个日期
     * @param seconds
     *            第一个日期与第二个日期相差的秒数,第一个日期加上该秒数比较，正数相加，负数相减
     * @return 如果第一个日期小于第二个日期，返回-1,大于，返回1，等于返回0
     */
    public static int compareDate(Date first, Date secend, int seconds) {
        return compareDate(FORMAT.format(first),FORMAT.format(secend),seconds);
    }

	/**
	 * 日期增加天数
	 * @param date 要增加天数的日期
	 * @param num 增加多少天(可以为负数，如 num=-1,结果为日期的前一天)
	 * @return
	 */
	public static Date addDay(Date date, Integer num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, num);
		return calendar.getTime();
	}
	
	/**
	 * 增加年数
	 * @param date 要增加天数的日期
	 * @param num 增加多少天(可以为负数，如 num=-1,结果为日期的前一天)
	 * @return
	 */
	public static Date addYear(Date date, Integer num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR,num);
		return calendar.getTime();
	}
	
	/**
	 * @Description: 比较两个时间差
	 * @author liu.z 2015年3月5日
	 * @param d1
	 * @param d2
	 * @param num 
	 * @return true/false
	 */
	public static boolean compareTime(Date d1, Date d2, long num){
		return (d1.getTime() - d2.getTime()) >= num;
	}


	/**
	 * 计算日期begin到日期end还有多少天
	 * @param smdate 开始日期--较小的日期
	 * @param bdate 结束日期--较大的日期
	 * @return 日期天数差
	 */
	public static Integer calculateTheDateDifference(Date smdate,Date bdate){
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			smdate=sdf.parse(sdf.format(smdate));
			bdate=sdf.parse(sdf.format(bdate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(bdate);
			long time2 = cal.getTimeInMillis();
			long between_days=(time2-time1)/(1000*3600*24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 把不带时分秒的日期转换为 23时59分59秒
	 * @param begin
	 * @return
	 */
	public static Date covertEndDate(Date begin){
		if (begin == null){
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(begin);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE,59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	public static Long getTime(Date date){
		return date.getTime()/1000;
	}

    public static String getCurrentYearMonthStr(){
        Calendar cal = Calendar.getInstance();
        cal.get(Calendar.YEAR);
//        System.out.println(String.format("%d-%d",cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1));
        return String.format("%d-%d",cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1);
    }
	
	public static void main(String[] args) throws ParseException {
		String str = "9999-09-07 23:59:59";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = null;
		try {
			d = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(DateUtil.compareTime(new Date(), d, (long) (24 * 3 - 1) * 3600 * 1000));

		System.out.println(format.format(new Date()));
		System.out.println(format.format(addDay(new Date(), 30)));

		//计算两个日期差
		System.out.println(calculateTheDateDifference(d, new Date()));

		System.out.println(covertEndDate(d));
		System.out.println(format.parse(str).getTime()/1000);
		format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format.parse(str).getTime()/1000);
//		System.out.println(getTime(strToDate(String.format("%s-01-01 00:00:00",),DEFAULT_FORMAT)));
        System.out.println(getCurrentYearMonthStr());
    }

}