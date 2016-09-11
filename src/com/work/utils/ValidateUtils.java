package com.work.utils;

import org.apache.commons.lang3.StringUtils;

public class ValidateUtils {

	/**
	 * 判断字符串是否全是手机号
	 * @param s
	 * @return
	 * @author 张昊
	 * @date 2016年9月11日
	 */
	public static boolean isPhoneNum(String s) {
		return !(StringUtils.isEmpty(s) || s.length() != 11 || !StringUtils.isNumeric(s));
	}
	
	
	/**
	 * 判断是否是中国人的名字
	 * @param s
	 * @return
	 * @author 张昊
	 * @date 2016年9月11日
	 */
	public static boolean isChineseName(String s){
		return s.matches("[\u4E00-\u9FA5]+")&&!StringUtils.isEmpty(s)&&s.length()<4;
	}


	public static boolean isEnglishName(String userName) {
		return userName!=null&&userName.matches("[A-z]+-?[A-z]+");
	}
	
	public static void main(String[] args) {
		System.out.println(isEnglishName("asd大"));
	}
	
}
