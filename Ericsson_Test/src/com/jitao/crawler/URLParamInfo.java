package com.jitao.crawler;

/**
 * 控制爬取数据地址的改变
 * 
 * @author jitao
 * 
 */
public class URLParamInfo {

	/**
	 * 豆瓣关于“**”方面的书籍的地址，用传参的方式来给出
	 */
	public static  String URL = null;
	/**
	 * 每页显示记录条数
	 */
	public static final int NUM = 20;
	/**
	 * 拼接分页
	 */
	public static final String START = "?start=";

}