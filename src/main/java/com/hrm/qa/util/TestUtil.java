package com.hrm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.hrm.qa.base.BaseDetails;

public class TestUtil extends BaseDetails{
	
	public static long PAGE_TIME_LOAD = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static String TESTDATA_SHEET_PATH="";
	
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	
	public static Object[][] getTestData(String sheetname) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}catch(InvalidFormatException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=book.getSheet(TESTDATA_SHEET_PATH);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int k=0; k<sheet.getRow(i).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	}
	
		public static void takeScreenShotAtEndOfTest() throws IOException {
			File srcFIle= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyDirectory(srcFIle, new File(currentDir +"/screenshot/"+System.currentTimeMillis() + ".png"));
			
		}
	
		
	public static void runTimeErrorMsg(String messageType, String errorMessage)throws InterruptedException{
		
		js = (JavascriptExecutor) driver;
		js.executeScript("if (!window.jQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(5000);

		// Use jQuery to add jquery-growl to the page
				js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

				// Use jQuery to add jquery-growl styles to the page
				js.executeScript("$('head').append('<link rel=\"stylesheet\" "
						+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
				Thread.sleep(5000);

				// jquery-growl w/ no frills
				js.executeScript("$.growl({ title: 'GET', message: '/' });");
		//'"+color+"'"
				if (messageType.equals("error")) {
					js.executeScript("$.growl.error({ title: 'ERROR', message: '"+errorMessage+"' });");
				}else if(messageType.equals("info")){
					js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
				}else if(messageType.equals("warning")){
					js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
				}else
					System.out.println("no error message");
			Thread.sleep(5000);
	}

}
