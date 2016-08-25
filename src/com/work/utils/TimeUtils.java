package com.work.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.work.exception.DevelopException;

/**
 * 时间工具 
 * @author 张昊
 */
public class TimeUtils {
	
	public static final String YMD = "yyyy-MM-dd";
	public static final String Y = "yyyy";
	public static final String HM = "HH:mm";
	public static final String YMDHM = "yyyy-MM-dd HH:mm";
	
	/**
	 * 获取当前时间的制定格式字符串
	 * @param format
	 * @return
	 * @throws DevelopException
	 * @author 张昊
	 */
	public static String getNow(String format){
		return getFormatDateString(new Date(), format);
	}
	
	/**
	 * 将一个date对象返回一个制定格式的时间字符串
	 * @param date
	 * @return
	 * @author 张昊
	 * @date 2016年6月4日
	 */
	public static String getFormatDateString(Date date,String pattern){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String format = simpleDateFormat.format(date);
		return format;
	}
}
