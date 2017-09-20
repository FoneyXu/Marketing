package org.marketing.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 英文简写（默认）如：2010-12-01
	 */
	public static String FORMAT_SHORT = "yyyy-MM-dd";
	/**
	 * 英文全称 如：2010-12-01 23:15:06
	 */
	public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
	 */
	public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";
	/**
	 * 中文简写 如：2010年12月01日
	 */
	public static String FORMAT_SHORT_CN = "yyyy年MM月dd";
	/**
	 * 中文全称 如：2010年12月01日 23时15分06秒
	 */
	public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";
	/**
	 * 精确到毫秒的完整中文时间
	 */
	public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

	/**
	 * 获得默认的 date pattern
	 */
	public static String getDatePattern() {
		return FORMAT_LONG;
	}

	/**
	 * 根据预设格式返回当前日期
	 * 
	 * @return
	 */
	public static String getNow() {
		return format(new Date());
	}

	/**
	 * 根据用户格式返回当前日期
	 * 
	 * @param format
	 * @return
	 */
	public static String getNow(String format) {
		return format(new Date(), format);
	}

	/**
	 * 使用预设格式格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format(date, getDatePattern());
	}

	/**
	 * 使用用户格式格式化日期
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static String format(Date date, String pattern) {
		String returnValue = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}
		return (returnValue);
	}

	/**
	 * 使用预设格式提取字符串日期
	 * 
	 * @param strDate
	 *            日期字符串
	 * @return
	 */
	public static Date parse(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 使用用户格式提取字符串日期
	 * 
	 * @param strDate
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static Date parse(String strDate, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 在日期上增加数个整月
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            要增加的月数
	 * @return
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加天数
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            要增加的天数
	 * @return
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}

	/**
	 * 
	 * 方法名称：subtractDay 方法描述：在日期上减去天数 创建人：贺康 创建时间：2016-5-9 下午3:59:19 修改人： 修改时间：
	 * 修改备注：
	 */
	public static Date subtractDay(Date date, int n) {
		Date d = date;
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, -n); // 减1天
		return cal.getTime();
	}

	/**
	 * 获取时间戳
	 */
	public static String getTimeString() {
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
		Calendar calendar = Calendar.getInstance();
		return df.format(calendar.getTime());
	}
	
	/**
	 * 
	 * @discription 获取时间字符串
	 * @author 徐志远
	 * @created 2017年6月13日 上午10:59:08 
	 * @param args
	 */
	public static String getCurrentTimeString() {
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_LONG);
		Calendar calendar = Calendar.getInstance();
		return df.format(calendar.getTime());
	}

	/**
	 * 获取日期年份
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static String getYear(Date date) {
		return format(date).substring(0, 4);
	}

	/**
	 * 按默认格式的字符串距离今天的天数
	 * 
	 * @param date
	 *            日期字符串
	 * @return
	 */
	public static int countDays(String date) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * 按用户格式字符串距离今天的天数
	 * 
	 * @param date
	 *            日期字符串
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static int countDays(String date, String format) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date, format));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * 
	 * 方法名称：month 方法描述：计算月差 创建人：贺康 创建时间：2014-12-29 下午9:15:07 修改人： 修改时间： 修改备注：
	 */
	public static int month(Date d1, Date d2) {
		int monthday;

		SimpleDateFormat sfy = new SimpleDateFormat("yyyy");
		SimpleDateFormat sfm = new SimpleDateFormat("MM");
		SimpleDateFormat sfd = new SimpleDateFormat("dd");

		String sYear = sfy.format(d1);
		String sMonth = sfm.format(d1);
		String sMontd = sfd.format(d1);

		String eYear = sfy.format(d2);
		String eMonth = sfm.format(d2);
		String eMontd = sfd.format(d2);
		if (Integer.parseInt(sMontd) > Integer.parseInt(eMontd)) {
			monthday = (Integer.parseInt(eYear) - Integer.parseInt(sYear)) * 12
					+ (Integer.parseInt(eMonth) - Integer.parseInt(sMonth) - 1);
		} else {
			monthday = (Integer.parseInt(eYear) - Integer.parseInt(sYear)) * 12
					+ (Integer.parseInt(eMonth) - Integer.parseInt(sMonth));
		}

		return monthday;
	}

	/**
	 * 
	 * 方法名称：monthCha 方法描述：计算月差,不加入天数 创建人：侯晓毅 创建时间：2014-12-29 下午9:15:07 修改人：
	 * 修改时间： 修改备注：
	 */
	public static int monthCha(Date d1, Date d2) {
		if (d1.getTime() >= d2.getTime()) {
			return 0;
		} else {
			int monthday;

			SimpleDateFormat sfy = new SimpleDateFormat("yyyy");
			SimpleDateFormat sfm = new SimpleDateFormat("MM");

			String sYear = sfy.format(d1);
			String sMonth = sfm.format(d1);

			String eYear = sfy.format(d2);
			String eMonth = sfm.format(d2);
			monthday = (Integer.parseInt(eYear) - Integer.parseInt(sYear)) * 12
					+ (Integer.parseInt(eMonth) - Integer.parseInt(sMonth));

			return monthday;
		}
	}

	/**
	 * 在日期上增加秒
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            要增加的天数
	 * @return
	 */
	public static Date addSec(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, n);
		return cal.getTime();
	}

	/**
	 * 
	 * 方法名称：daysBetween 方法描述：计算两个日期之间相差的天数 smdate 较小的时间 bdate 较大的时间 创建人：贺康
	 * 创建时间：2016-5-9 下午2:54:11 修改人： 修改时间： 修改备注：
	 */
	public static int daysBetween(Date smdate, Date bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 
	 * 方法名称：howerBetween 方法描述：计算两个日期之间相差的小时 smdate 较小的时间 bdate 较大的时间 创建人：贺康
	 * 创建时间：2016-5-9 下午2:54:11 修改人： 修改时间： 修改备注：
	 */
	public static int howerBetween(Date smdate, Date bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_LONG);
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_howers = (time2 - time1) / (1000 * 3600);

		return Integer.parseInt(String.valueOf(between_howers));
	}
	
	/**
	 * 
	 * 方法名称：randomDateTime 方法描述：生成两个日期之间的随机时间 创建人：孙良涛
	 * 创建时间：2016-11-29 下午2:54:11 修改人： 修改时间： 修改备注：
	 */
	public static Date randomDateTime(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = format.parse(beginDate);// 开始日期
            Date end = format.parse(endDate);// 结束日期
            if (start.getTime() >= end.getTime()) {
                return null;
            }
           
            long date = random(start.getTime(), end.getTime());
 
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));  
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
        if (rtn == begin || rtn == end) {  
            return random(begin, end);  
        }  
        return rtn;  
    }
	
}
