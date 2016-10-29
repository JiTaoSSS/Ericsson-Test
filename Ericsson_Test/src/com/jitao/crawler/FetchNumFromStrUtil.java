package com.jitao.crawler;

public class FetchNumFromStrUtil {

	/**
	 * 用于提取评价内容框中的评价人数的数字段
	 * 
	 * @param strexample 
	 * 传入的字符串
	 * @return 
	 * 解析后的数字（float类型）
	 */
	public static int fetch(String strexample) {
		String str = strexample;
		str = str.trim();
		int peopleNum = 0;
		String str2 = "";
		if (str != null && !"".equals(str)) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
					str2 += str.charAt(i);
					peopleNum = Integer.parseInt(str2);
				}
			}

		}
		// System.out.println("解析后的评价人数："str2);
		return peopleNum;

	}

}
