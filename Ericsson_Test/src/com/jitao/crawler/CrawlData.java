package com.jitao.crawler;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 爬取页面数据的方法
 * @author jitao
 * 
 */
public class CrawlData {
	
	private CrawlData() {

	}

	private static final CrawlData instance = new CrawlData();

	public static CrawlData getInstance() {
		return instance;
	}

	
	/**
	 * 获取数据的方法
	 * @param list
	 * @param urlparam
	 */
	public void getDoubanReview(List<BookInfo> list,String urlparam) {
		try {
			// 分页读取数据
			for (int i = 0; i < 50; i++) {   //在相关页面观察后觉得统一用50，已经可以保障所有数据都能取到了
				URLParamInfo.URL = urlparam;   //因为有三个不同的地址，所以通过参数将地址值注入，提高代码重用率
				String url = URLParamInfo.URL + URLParamInfo.START
						+ String.valueOf(i * URLParamInfo.NUM);
				System.out.println(url);    //用于控制台输出查询状态，更好的观察当前状态
				Connection connection = Jsoup.connect(url);
				Document document = connection.get();
				Elements block = document.select(".subject-item"); // 获取subjet-item类block块
				// System.out.println("subject-item类"+ul);//测试使用
				Iterator<Element> blockIter = block.iterator();
				while (blockIter.hasNext()) {
					Element element = blockIter.next();
					Elements h2Block = element.select("h2");
					Elements bookNameBlock = h2Block.select("a"); // 获取书名标签块
					Elements scoreBlock = element.select(".rating_nums"); // 获取评分标签块
					Elements ratingPeopleNumBlock = element.select(".pl"); // 获取评价人数标签块
					Elements bookInfoBlock = element.select(".pub");  //获取书本相关信息标签块
					
					// 获取书名
					String bookName = bookNameBlock.text(); 
					
					//获取评分 
					float score; 
					try {
						score = Float.parseFloat(scoreBlock.text());
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						score = 0L;   //当评分不存在是不报异常，直接将评分设为0
					}
					
					// 获取评价人数相关内容
					String ratingPeopleContext = ratingPeopleNumBlock.text(); 
					int ratingPeopleNum = FetchNumFromStrUtil
							.fetch(ratingPeopleContext);
					
					//获取书本相关信息（包括：作者，出版社，出版日期，价格）
					String bookExtraInfo = bookInfoBlock.text();  
					String[] bookExtraInfoArr = StrSpiltUtil.spilt(bookExtraInfo); //将书本相关信息分割开
					/*System.out.println("书名" + bookName);
					System.out.println("评分" + score);
					System.out.println("评价人数" + ratingPeopleNum);
					System.out.println("书本相关信息"+bookExtraInfo);*/
				
					/**
					 * 只有当评价人数大于1000时
					 * 将书本数据存入对象中并添加到list中去
					 */
					if (ratingPeopleNum >= 1000) {
						BookInfo bookinfo = new BookInfo();
						bookinfo.setBookName(bookName);
						bookinfo.setScore(score);
						bookinfo.setRatingPeopleNum(ratingPeopleNum);
						
						//书本额外信息分3种情况进行存错
						switch (bookExtraInfoArr.length) {
						
						//如果书本额外信息的数据长度等于3，那么价格未知
						case 3:
							bookinfo.setBookAuthor(bookExtraInfoArr[0]);
							bookinfo.setBookTranslator("无");
							bookinfo.setBookPublisher(bookExtraInfoArr[1]);
							bookinfo.setBookPublicationDate(bookExtraInfoArr[2]);
							bookinfo.setPrice("未知");
							break;
						
						//如果书本额外信息的数据长度等于5，那么作者列会有2项，一项为原著作者，另一项为翻译作者，需要合并
						case 5:
							bookinfo.setBookAuthor(bookExtraInfoArr[0]);
							bookinfo.setBookTranslator(bookExtraInfoArr[1]);
							bookinfo.setBookPublisher(bookExtraInfoArr[2]);
							bookinfo.setBookPublicationDate(bookExtraInfoArr[3]);
							bookinfo.setPrice(bookExtraInfoArr[4]);
							break;
						
						//默认情况
						default:
							bookinfo.setBookAuthor(bookExtraInfoArr[0]);
							bookinfo.setBookTranslator("无");
							bookinfo.setBookPublisher(bookExtraInfoArr[1]);
							bookinfo.setBookPublicationDate(bookExtraInfoArr[2]);
							bookinfo.setPrice(bookExtraInfoArr[3]);
							break;
						}
						list.add(bookinfo);
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	
	

	
}