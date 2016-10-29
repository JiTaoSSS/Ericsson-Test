package com.jitao.crawler;

public class StrSpiltUtil {
	
	
	/**
	 * 把字符串根据“/”分割开的方法
	 * @param strexample 
	 * @return
	 */
	public static String[] spilt(String strexample){
		String str = strexample;
		String[] result = str.split("/");
		
 		/*for (int i = 0; i < result.length; i++) {
			System.out.println("分隔开后的字符串数组为：" + result[i]);
		}*/
		
		return result;
		
	}
}
