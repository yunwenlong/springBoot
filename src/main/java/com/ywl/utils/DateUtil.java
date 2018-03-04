/* 
 *
 * FileName: AjaxObject.java 
 *
 * Author:Administrator
 *
 * Date:2013-12-18 下午03:43:13
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/
package com.ywl.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

 
public class DateUtil {
	private final static Logger logger = Logger.getLogger(DateUtil.class);
	private static final String TIME_FORMAT_SHORT = "yyyyMMddHHmmss";
	private static final String TIME_FORMAT_NORMAL = "yyyy-MM-dd HH:mm:ss";
	private static final String TIME_FORMAT_ENGLISH = "MM/dd/yyyy HH:mm:ss";
	private static final String TIME_FORMAT_CHINA = "yyyy年MM月dd日 HH时mm分ss秒";
	private static final String TIME_FORMAT_CHINA_S = "yyyy年M月d日 H时m分s秒";
	private static final String TIME_FORMAT_SHORT_S = "HH:mm:ss";

	private static final String DATE_FORMAT_SHORT = "yyyyMMdd";
	static final String DATE_FORMAT_NORMAL = "yyyy-MM-dd";
	private static final String DATE_FORMAT_ENGLISH = "MM/dd/yyyy";
	private static final String DATE_FORMAT_CHINA = "yyyy年MM月dd日";
	private static final String MONTH_FORMAT = "yyyyMM";
	private static final String YEAR_MONTH_FORMAT = "yyyy-MM";
	private static final String DATE_FORMAT_MINUTE = "yyyyMMddHHmm";
	private static final String MONTH_DAY_FORMAT = "MM-dd";
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NORMAL);
	
	private static final SimpleDateFormat sdfTime = new SimpleDateFormat(TIME_FORMAT_NORMAL);

	public static final String FORMATER_YYYY_MM_DD = "yyyy-MM-dd";
	public static final String FORMATER_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 改变时间 譬如： changeDate(new Date(),Calendar.DATE, 2) 就是把当前时间加两天
	 * 
	 * @param originDate
	 *            原始时间
	 * @param field
	 *            改变类型
	 * @param distance
	 *            长度
	 * @return 改变后的时间
	 * @since 0.1
	 */
	public static Date changeDate(Date originDate, int field, int distance) {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.setTime(originDate);
		c.add(field, distance);
		return c.getTime();
	}

	/**
	 * 把日期字符串转换为日期类型
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @return 日期
	 * @since 0.1
	 */
	public static Date convertAsDate(String dateStr) {
		DateFormat fmt = null;
		if (dateStr.matches("\\d{14}")) {
			fmt = new SimpleDateFormat(TIME_FORMAT_SHORT);
		} else if (dateStr
				.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")) {
			fmt = new SimpleDateFormat(TIME_FORMAT_NORMAL);
		} else if (dateStr
				.matches("\\d{1,2}/\\d{1,2}/\\d{4} \\d{1,2}:\\d{1,2}:\\d{1,2}")) {
			fmt = new SimpleDateFormat(TIME_FORMAT_ENGLISH);
		} else if (dateStr
				.matches("\\d{4}年\\d{1,2}月\\d{1,2}日 \\d{1,2}时\\d{1,2}分\\d{1,2}秒")) {
			fmt = new SimpleDateFormat(TIME_FORMAT_CHINA);
		} else if (dateStr.matches("\\d{8}")) {
			fmt = new SimpleDateFormat(DATE_FORMAT_SHORT);
		} else if (dateStr.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
			fmt = new SimpleDateFormat(DATE_FORMAT_NORMAL);
		} else if (dateStr.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
			fmt = new SimpleDateFormat(DATE_FORMAT_ENGLISH);
		} else if (dateStr.matches("\\d{4}年\\d{1,2}月\\d{1,2}日")) {
			fmt = new SimpleDateFormat(DATE_FORMAT_CHINA);
		} else if (dateStr.matches("\\d{4}\\d{1,2}\\d{1,2}\\d{1,2}\\d{1,2}")){
			fmt = new SimpleDateFormat(DATE_FORMAT_MINUTE);
		} else if (dateStr.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}")){
			fmt = new SimpleDateFormat(TIME_FORMAT_SHORT_S);
		}
		try {
			return fmt.parse(dateStr);
		} catch (ParseException e) {
			logger.warn(e.getMessage(), e);
			throw new IllegalArgumentException(
					"Date or Time String is invalid.");
		}
	}

	/**
	 * 把 2010-02-04 12:12:34 这样的时间转换为 20100204121234
	 * 
	 * @param origin
	 *            原始时间字符串
	 * @return 转换后的字符串
	 * @since 0.1
	 */
	public static String convertAsShortDateString(String origin) {
		return origin == null ? origin : origin.replaceAll(
				"[-|:|\\s|年|月|日|时|分|秒|/]", "");
	}

	/**
	 * 把 20100204121234 这样的时间转换为 2010-02-04 12:12:34
	 * 
	 * @param origin
	 *            原始时间字符串
	 * @return 转换后的字符串
	 * @since 0.1
	 */
	public static String convertAsNormalDateString(String origin) {
		if (origin == null)
			return origin;
		try {
			if (origin.matches("\\d{8}")) {
				SimpleDateFormat fmt = new SimpleDateFormat(DATE_FORMAT_SHORT);
				return getDateNormalString(fmt.parse(origin));
			} else if (origin.matches("\\d{14}")) {
				SimpleDateFormat fmt = new SimpleDateFormat(TIME_FORMAT_SHORT);
				return getTimeNormalString(fmt.parse(origin));
			}
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
		throw new IllegalArgumentException(origin
				+ "is invalid,String format is yyyyMMddHHmmss or yyyyMMdd");
	}

	/**
	 * 得到日期字符串,格式为 yyyy年MM月dd日
	 * 
	 * @param date
	 *            待格式化日期
	 * @return 返回格式化后的日期字符串
	 * @since 0.1
	 */
	public static String getDateChinaString(Date date) {
		DateFormat fmt = new SimpleDateFormat(DATE_FORMAT_CHINA);
		return fmt.format(date);
	}

	/**
	 * 得到日期字符串,格式为 MM/dd/yyyy
	 * 
	 * @param date
	 *            待格式化日期
	 * @return 返回格式化后的日期字符串
	 * @since 0.1
	 */
	public static String getDateEnglishString(Date date) {
		DateFormat fmt = new SimpleDateFormat(DATE_FORMAT_ENGLISH);
		return fmt.format(date);
	}

	/**
	 * 得到日期字符串,格式为 yyyy-MM-dd
	 * 
	 * @param date
	 *            待格式化日期
	 * @return 返回格式化后的日期字符串
	 * @since 0.1
	 */
	public static String getDateNormalString(Date date) {
		DateFormat fmt = new SimpleDateFormat(DATE_FORMAT_NORMAL);
		return fmt.format(date);
	}

	/**
	 * 得到日期字符串,格式为 MM-dd
	 * 
	 * @param date
	 *            待格式化日期
	 * @return 返回格式化后的日期字符串
	 * @since 0.1
	 */
	public static String getMonthDayDateNormalString(Date date) {
		DateFormat fmt = new SimpleDateFormat(MONTH_DAY_FORMAT);
		return fmt.format(date);
	}
	/**
	 * 
	 * Description: 得到日期字符串，格式为yyyy-MM
	 *
	 * @param date
	 * @return
	 * @Author mwq
	 * Create Date: 2012-8-29 上午11:20:31
	 */
	public static String getYearMonthString(Date date){
		DateFormat fmt = new SimpleDateFormat(YEAR_MONTH_FORMAT);
		return fmt.format(date);
	}
	/**
	 * 
	 * Description: 得到当前日期字符串，格式为yyyy-MM
	 *
	 * @return
	 * @Author mwq
	 * Create Date: 2012-8-29 上午11:28:27
	 */
	public static String getNowYearMonthString(){
		return getYearMonthString(new Date());
	}
	/**
	 * 得到日期字符串,格式为 yyyyMMdd
	 * 
	 * @param date
	 *            待格式化日期
	 * @return 返回格式化后的日期字符串
	 * @since 0.1
	 */
	public static String getDateShortString(Date date) {
		DateFormat fmt = new SimpleDateFormat(DATE_FORMAT_SHORT);
		return fmt.format(date);
	}

	/**
	 * 得到日期字符串,格式为 yyyy年MM月dd日
	 * 
	 * @return 返回当前日期的字符串
	 */
	public static String getNowDateChinaString() {
		return getDateChinaString(new Date());
	}

	/**
	 * 得到日期字符串,格式为 MM/dd/yyyy
	 * 
	 * @return 返回当前日期的字符串
	 */
	public static String getNowDateEnglishString() {
		return getDateEnglishString(new Date());
	}

	/**
	 * 得到日期字符串,格式为 yyyy-MM-dd
	 * 
	 * @return 返回当前日期的字符串
	 */
	public static String getNowDateNormalString() {
		return getDateNormalString(new Date());
	}
	
	/**
	 * 得到日期字符串,格式为 yyyy-MM-dd
	 * 
	 * @param interval
	 *            间隔天数
	 * @return
	 */
	public static String getNowDateNormalString(int interval) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, interval);
		return getDateNormalString(c.getTime());
	}
	/**
	 * 获得指定日期的字符串，格式为MM-dd
	 * @param interval
	 * @return
	 */
	public static String getNowMonthNormalString(int interval){
		return getNowDateNormalString(interval).substring(5, 10);
	}
	/**
	 * 根据输入日期向后累加interval天
	 * @param day
	 * @param interval
	 * @return
	 * @throws ParseException
	 */
	public static String getIntervalDaysLater(String day,int interval){
		if(day == null || "".equals(day)){
			return "";
		}
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(day));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.DATE, interval);
		return getDateNormalString(c.getTime());
	}
	/**
	 * 
	 * Description: 得到当前日期累加interval天
	 *
	 * @param interval
	 * @return
	 * @Author mwq
	 * Create Date: 2012-8-29 下午04:41:43
	 */
	public static String getNowDateIntervalDaysLater(int interval){
		return getIntervalDaysLater(getNowDateNormalString(),interval);
	}
	
	/**
	 * 
	 * Description: 月份累加interval
	 *
	 * @param day
	 * @param interval
	 * @return
	 * @throws ParseException
	 * @Author mwq
	 * Create Date: 2012-8-28 上午11:51:41
	 */
	public static String getIntervalMonthLater(String day,int interval){
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(day));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.MONTH, interval);
		return getDateNormalString(c.getTime());
	}

	/**
	 * 得到日期字符串,格式为 MM-dd
	 * 
	 * @param interval
	 *            间隔天数
	 * @return
	 */
	public static String getNowMonthDayDateNormalString(int interval) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, interval);
		return getMonthDayDateNormalString(c.getTime());
	}

	/**
	 * 得到日期字符串,格式为 yyyyMMdd
	 * 
	 * @return 返回当前日期的字符串
	 */
	public static String getNowDateShortString() {
		return getDateShortString(new Date());
	}
	
	/**
	 * 得到时间字符串,格式为 yyyy年MM月dd日 HH时mm分ss秒
	 * 
	 * @return 返回当前时间的字符串
	 */
	public static String getNowTimeChinaString() {
		return getTimeChinaString(new Date());
	}
	/**
	 * 
	 * Description: 得到时间字符串,格式为 HH:mm:ss
	 *
	 * @return
	 * @Author mwq
	 * Create Date: 2012-8-29 上午11:34:35
	 */
	public static String getNowTimeNormalStringS() {
		return getTimeNormalStringS(new Date());
	}
	/**
	 * 得到时间字符串,格式为 MM/dd/yyyy HH:mm:ss
	 * 
	 * @return 返回当前时间的字符串
	 * 
	 */
	public static String getNowTimeEnglishString() {
		return getTimeEnglishString(new Date());
	}

	/**
	 * 得到时间字符串,格式为 yyyy-MM-dd HH:mm:ss
	 * 
	 * @return 返回当前时间的字符串
	 */
	public static String getCurrentTime() {
		return getTimeNormalString(new Date());
	}

	/**
	 * 得到时间字符串,格式为 yyyyMMddHHmmss
	 * 
	 * @return 返回当前时间的字符串
	 */
	public static String getNowTimeShortString() {
		return getTimeShortString(new Date());
	}

	/**
	 * 得到时间字符串,格式为 yyyy年MM月dd日 HH:mm:ss
	 * 
	 * @param date
	 *            待格式化日期
	 * @return 返回格式化后的时间字符串
	 * @since 0.1
	 */
	public static String getTimeChinaString(Date date) {
		DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_CHINA);
		return fmt.format(date);
	}
	
	public static String getTimeChinaStringS(Date date) {
		DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_CHINA_S);
		return fmt.format(date);
	}

	/**
	 * 得到时间字符串,格式为 MM/dd/yyyy HH:mm:ss
	 * 
	 * @param date
	 *            待格式化日期
	 * @return 返回格式化后的时间字符串
	 * @since 0.1
	 */
	public static String getTimeEnglishString(Date date) {
		DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_ENGLISH);
		return fmt.format(date);
	}

	/**
	 * 得到时间字符串,格式为 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            待格式化日期
	 * @return 返回格式化后的时间字符串
	 * @since 0.1
	 */
	public static String getTimeNormalString(Date date) {
		DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_NORMAL);
		return fmt.format(date);
	}
	/**
	 * 
	 * Description: 得到时间字符串，格式为HH:mm:ss
	 *
	 * @param date
	 * @return
	 * @Author mwq
	 * Create Date: 2012-8-29 上午11:21:20
	 */
	public static String getTimeNormalStringS(Date date) {
		DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_SHORT_S);
		return fmt.format(date);
	}

	/**
	 * 得到时间字符串,格式为 yyyyMMddHHmmss
	 * 
	 * @param date
	 *            待格式化日期
	 * @return 返回格式化后的时间字符串
	 * @since 0.1
	 */
	public static String getTimeShortString(Date date) {
		DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_SHORT);
		return fmt.format(date);
	}

	/**
	 * 得到时间字符串,格式为 yyyyMM
	 * 
	 * @param date
	 * @return
	 * @since 0.1
	 */
	public static String getMonthString(Date date) {
		DateFormat fmt = new SimpleDateFormat(MONTH_FORMAT);
		return fmt.format(date);
	}

	/**
	 * 得到时间字符串,格式为 M月d日
	 * 
	 * @param day
	 *            相隔几天
	 * @return
	 * @since 0.1
	 */
	public static String getMonthDay(int day) {
		DateFormat fmt = new SimpleDateFormat("M月d日");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, day);
		return fmt.format(c.getTime());
	}

	/**
	 * 获得日期集合
	 * 
	 * @param beginDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getDateList(String beginDate, String endDate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NORMAL);
		List<String> list = new ArrayList<String>();
		Calendar c1 = Calendar.getInstance(Locale.CHINA);
		c1.setTime(sdf.parse(beginDate));
		Calendar c2 = Calendar.getInstance(Locale.CHINA);
		c2.setTime(sdf.parse(endDate));
		long l1 = c1.getTimeInMillis();
		long l2 = c2.getTimeInMillis();
		int interval = (int) ((l2 - l1) / (1000 * 60 * 60 * 24));
		for (int i = 0; i <= interval; i++) {
			Calendar c = Calendar.getInstance();
			c.setTime(c1.getTime());
			c.add(Calendar.DATE, i);
			list.add(sdf.format(c.getTime()));
		}
		return list;
	}
	/**
	 * 获得输入日期所在周的第一天（周一为第一天）
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static String getFirstDayOfWeek(String day) throws ParseException{
		Calendar c1 = Calendar.getInstance(Locale.CHINA);
		c1.setTime(sdf.parse(day));
		c1.setFirstDayOfWeek(Calendar.MONDAY);
		c1.set(Calendar.DAY_OF_WEEK, c1.getFirstDayOfWeek());
		return sdf.format(c1.getTime());
	}
	/**
	 * 获得输入日期所在周的最后一天（周日为最后一天）
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static String getLastDayOfWeek(String day) throws ParseException{
		Calendar c1 = Calendar.getInstance(Locale.CHINA);
		c1.setTime(sdf.parse(day));
		c1.setFirstDayOfWeek(Calendar.MONDAY);
		c1.set(Calendar.DAY_OF_WEEK, c1.getFirstDayOfWeek()+6);
		return sdf.format(c1.getTime());
	}
	/**
	 * 计算输入日期所在月的最后一天
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static String getLastDayOfMonth(String day) throws ParseException{
		Calendar c1 = Calendar.getInstance(Locale.CHINA);
		c1.setTime(sdf.parse(day));
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.add(Calendar.MONTH, 1);
		c1.add(Calendar.DAY_OF_MONTH, -1);
		return sdf.format(c1.getTime());
	}
	/**
	 * 计算输入日期所在月的第一天
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static String getFirstDayOfMonth(String day) throws ParseException{
		Calendar c1 = Calendar.getInstance(Locale.CHINA);
		c1.setTime(sdf.parse(day));
		c1.set(Calendar.DAY_OF_MONTH, 1);
		return sdf.format(c1.getTime());
	}
	/**
	 * 是否是当月的第一天
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static boolean isFirstDayOfMonth(String day) throws ParseException{
		return day.equals(getFirstDayOfMonth(day))? true : false;
	}
	
	/**
	 * 是否是当月的最后一天
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static boolean isLastDayOfMonth(String day) throws ParseException{
		return day.equals(getLastDayOfMonth(day))? true : false;
	}
	
	/**
	 * 是否是当前周的第一天
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static boolean isFirstDayOfWeek(String day) throws ParseException{
		return day.equals(getFirstDayOfWeek(day))? true : false;
	}
	
	/**
	 * 是否是当前周的最后一天
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static boolean isLastDayOfWeek(String day) throws ParseException{
		return day.equals(getLastDayOfWeek(day))? true : false;
	}
	/**
	 * 计算输入日期所在周是否跨月
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static boolean isDayBetweenMonthAndWeek(String day) throws ParseException{
		String firstDayOfMonth = getFirstDayOfMonth(day);
		String firstDayOfWeek = getFirstDayOfWeek(day);
		Pattern p = Pattern.compile("\\d{4}-\\d{2}-01");
		Matcher m = p.matcher(day);
		if(firstDayOfWeek.compareTo(firstDayOfMonth) < 0 && !m.matches()){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 输入的日期是否为时间格式
	 * @param input
	 * @return
	 */
	public static boolean isInputDate(String input){
		return input.matches("\\d{4}-\\d{1,2}-\\d{1,2}");
	}
	public static boolean isInputDateNormalString(String input){
		return input.matches("\\d{4}-\\d{2}-\\d{2}");
	}
	/**
	 * 将日期字符串格式化为yyyy-MM-dd
	 * @param input
	 * @return
	 */
	public static String formatDateString(String input) throws IllegalArgumentException{
		String month = "";
		String day = "";
		try {
			if (!isInputDate(input)){
				throw new IllegalArgumentException("日期格式不合法");
			}
			if (isInputDateNormalString(input)){
				return input;
			}
			month = input.substring(input.indexOf("-") + 1, input
					.lastIndexOf("-"));
			if (month.length() == 1 && month.indexOf("0") != 0)
				month = "0" + month;
			day = input.substring(input.lastIndexOf("-") + 1, input.length());
			if (day.length() == 1 && day.indexOf("0") != 0)
				day = "0" + day;
		} catch (Exception e) {
			e.printStackTrace();
			return input;
		}
		return input.substring(0, 4)+"-"+month+"-"+day;
	}
	
	/**
	 * 
	 * Description: 计算时间差
	 * @param time1 开始时间
	 * @param time1 结束时间
	 * @return long 时间差(单位:毫秒)
	 * @throws
	 * @Author deshengxue
	 * Create Date: 2013-11-6 下午02:14:43
	 */
	public static long getStringTimeDiff(String time1, String time2, SimpleDateFormat format) {
		long diff = 0;
		try{
			Date startTime = format.parse(time1);
			Date endTime = format.parse(time2);
			diff = endTime.getTime() - startTime.getTime();
		}catch(Exception e){
			e.printStackTrace();
			logger.error("计算时间差出现异常");
		}
		return diff;
	}
	
	/**
	 * 
	 * Description: 
	 * 得到传入日期对应的星期的数字，0-6
	 * @param 
	 * @return int
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-11-8 上午10:06:44
	 */
	public static int getWeekInt(String dateString) throws ParseException{   
	        DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");   
	        Date dateObject = dateFormater.parse(dateString);//将日期字符串转换为日期对象   
	        Calendar calendar = new GregorianCalendar();   
	        calendar.setTime(dateObject);   
	        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);//该日期的星期   
	       //美国和欧洲习惯把周日当作每周的第一天,故减去1   
	        return dayOfWeek-1;   
	}  
	
	/**
	 * 
	 * Description: 
	 * 得到传入日期对应的星期
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-11-8 上午10:09:45
	 */
	public static String getWeekStr(String dateString){
		String weekStr = "";
		try {
			int weekInt = getWeekInt(dateString);
			if(weekInt==1){
				weekStr = "周一";
			}
			if(weekInt==2){
				weekStr = "周二";
			}
			if(weekInt==3){
				weekStr = "周三";
			}
			if(weekInt==4){
				weekStr = "周四";
			}
			if(weekInt==5){
				weekStr = "周五";
			}
			if(weekInt==6){
				weekStr = "周六";
			}
			if(weekInt==0){
				weekStr = "周日";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return weekStr;
	}
	
	public static void main(String[] args) throws ParseException{
//		System.out.println(getLastDayOfMonth(getNowDateNormalString()));
//		System.out.println(getFirstDayOfMonth(getNowDateNormalString()));
//		System.out.println(getIntervalMonthLater("2012-08-03",2));
//		System.out.println(getIntervalDaysLater(getNowDateNormalString(),0));
//		System.out.println(getIntervalDaysLater(getNowDateNormalString(),1));
//		System.out.println(getIntervalDaysLater(getNowDateNormalString(),2));
//		System.out.println(getNowYearMonthString());
		System.out.println(getStringTimeDiff("2013-11-06 14:14:00","2013-11-06 14:14:00",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		System.out.println(getStringTimeDiff("2013-11-06","2013-11-06",new SimpleDateFormat("yyyy-MM-dd")));
//		List<String> a = new ArrayList<String>();
//		a.addAll(null);
//		System.out.println(a.size());
	}
	public static String MembersDay(){
		String flag;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		String dateStr = sdf.format(date);
		if("02".equals(dateStr)||"12".equals(dateStr)||"22".equals(dateStr)){
			flag="1";//用户日
		}else{
			flag="0";//非用户日
		}
		return flag;
	}
	
	/**
	 * 字符串转化为日期</br>
	 * @param str	需要被转换为日期的字符串
	 * @param format 格式，常用的为 yyyy-MM-dd HH:mm:ss
	 * @return	java.util.Date，如果出错会返回null
	 */
	public static Date StringToDate(String str, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			logger.error("将字符串转换成日期时出错", e);
		}
		return date;
	}
	

}
