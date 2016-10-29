package com.jitao.crawler;

import java.util.ArrayList;
import java.util.List;
/**
 * main方法入口
 * 
 * @author jitao
 * 
 */
public class Launch {
	// list用于暂存爬到的有效数据
	private static List<BookInfo> list = new ArrayList<BookInfo>();

	public static List<BookInfo> getList() {
		return list;
	}

	public static void setList(List<BookInfo> list) {
		Launch.list = list;
	}

	public static void main(String[] args) {
		CrawlData cd = CrawlData.getInstance(); // 获取单例
		cd.getDoubanReview(list, "https://book.douban.com/tag/互联网"); // 抓取有关互联网的书本数据
		cd.getDoubanReview(list, "https://book.douban.com/tag/编程"); // 抓取有关编程的书本数据
		cd.getDoubanReview(list, "https://book.douban.com/tag/算法"); // 抓取有关算法的书本数据
		ListSortUtil.ListSort(list); // 对抓取到的List进行排序
		CreateExcel.exportExcel(list, "E:\\douban\\resultDisplay.xls"); // 将数据写入excel文件
	}

}