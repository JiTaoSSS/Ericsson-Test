package com.jitao.crawler;

/**
 * 书本信息类
 * 
 * @author jitao
 * 
 */
public class BookInfo {
	private String bookName; // 书本名称
	private float score;  // 书本评分
	private int ratingPeopleNum; // 书本评价人数
	private String bookAuthor; // 书本作者
	private String bookTranslator; // 书本翻译者
	private String bookPublisher; // 书本出版社
	private String bookPublicationDate; // 书本出版日期
	private String price; // 价格

	public BookInfo(String bookName, float score, int ratingPeopleNum,
			String bookAuthor, String bookTranslator, String bookPublisher,
			String bookPublicationDate, String price) {
		super();
		this.bookName = bookName;
		this.score = score;
		this.ratingPeopleNum = ratingPeopleNum;
		this.bookAuthor = bookAuthor;
		this.bookTranslator = bookTranslator;
		this.bookPublisher = bookPublisher;
		this.bookPublicationDate = bookPublicationDate;
		this.price = price;
	}

	public BookInfo() {
		super();
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getRatingPeopleNum() {
		return ratingPeopleNum;
	}

	public void setRatingPeopleNum(int ratingPeopleNum) {
		this.ratingPeopleNum = ratingPeopleNum;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookTranslator() {
		return bookTranslator;
	}

	public void setBookTranslator(String bookTranslator) {
		this.bookTranslator = bookTranslator;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookPublicationDate() {
		return bookPublicationDate;
	}

	public void setBookPublicationDate(String bookPublicationDate) {
		this.bookPublicationDate = bookPublicationDate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
