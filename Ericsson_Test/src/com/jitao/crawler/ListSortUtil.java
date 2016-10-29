package com.jitao.crawler;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortUtil {
	/**
	 * 将已有list按照书本的评分进行倒叙排列的方法
	 */
	public static void ListSort(List<BookInfo> list){
		Collections.sort(list, new Comparator<BookInfo>() {
			public int compare(BookInfo book1, BookInfo book2) {

				// 按照书本的评分进行倒叙排列
				if (book1.getScore() < book2.getScore()) {
					return 1;
				}
				if (book1.getScore() == book2.getScore()) {
					return 0;
				}
				return -1;
			}
		});
		/*for (int i = 0; i < list.size(); i++) {
			System.out.println("排序后："+list.get(i).getBookName());//输出排序后的清单，用于测试
		}*/
	}
}
