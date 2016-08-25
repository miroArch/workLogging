package com.work.utils;

import org.apache.commons.lang3.StringUtils;

public class StrUtil {
	
	/**
	 * 是否为空或者Null
	 * @param string
	 * @return
	 * @author 张昊
	 */
	public static boolean isEmpty(String string){
		return StringUtils.isEmpty(string);
	}
	
	/**
	 * 检测数组里的元素是否都为空
	 * @param strs
	 * @return
	 * @author 张昊
	 */
	public static boolean isEmptyList(String[] strs){
		if(strs==null)
			return true;
		for (String str : strs) {
			if(str==null||str.isEmpty()){
				return true;
			}
		}
		return false;
	}
}
