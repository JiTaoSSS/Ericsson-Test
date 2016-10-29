package com.jitao.crawler;

import java.io.File;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CreateExcel {
	
	/**
	 * 将数据写到Excel表中
	 * @param path
	 * @param list
	 */
	public static void exportExcel(List<BookInfo> list,String path){
        WritableWorkbook book = null;
        System.out.println(path);//输出文件地址
        String info[] = {"序号","书名","评分","评价人数","作者","翻译者","出版社","出版日期","价格"};//创建数组，用于存放列标签
        try{
        	File excelFile = new File(path);
            if (!excelFile.exists()) {
				book = Workbook.createWorkbook(excelFile);
				//生成名为bookRank的工作表，参数0表示第一页
				WritableSheet sheet = book.createSheet("bookRank", 0);
				//表头导航
				for (int j = 0; j < info.length; j++) {
					Label label = new Label(j, 0, info[j]);
					sheet.addCell(label);
					//设置单元格宽度
					sheet.setColumnView(0, 5);  //序号列
					sheet.setColumnView(1, 40); //书名列
					sheet.setColumnView(2, 5);  //评分列
					sheet.setColumnView(3, 10); //评价人数列
					sheet.setColumnView(4, 50); //作者列
					sheet.setColumnView(5, 40); //翻译者列
					sheet.setColumnView(6, 20); //出版社列
					sheet.setColumnView(7, 10); //出版日期列
					sheet.setColumnView(8, 10); //价格列
				}
				for (int i = 0; i < 100; i++) { //i<100用于控制只取前100条数据
					sheet.addCell(new Label(0, i + 1, (i + 1) + ""));
					sheet.addCell(new Label(1, i + 1, list.get(i).getBookName()));
					sheet.addCell(new Label(2, i + 1, list.get(i).getScore()
							+ ""));
					sheet.addCell(new Label(3, i + 1, list.get(i)
							.getRatingPeopleNum() + ""));
					sheet.addCell(new Label(4, i + 1, list.get(i)
							.getBookAuthor()));
					sheet.addCell(new Label(5, i + 1, list.get(i)
							.getBookTranslator()));
					sheet.addCell(new Label(6, i + 1, list.get(i)
							.getBookPublisher()));
					sheet.addCell(new Label(7, i + 1, list.get(i)
							.getBookPublicationDate()));
					sheet.addCell(new Label(8, i + 1, list.get(i).getPrice()));
				}
				// 写入数据并关闭文件
				book.write();
			}
            else{
            	System.err.println("文件已存在！！！"); //出于文件安全考虑，判断下文件是否存在
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(book!=null){
                try {
                    book.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }
        }
    }
}
