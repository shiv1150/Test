package com.jet.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseClass {
	public WebDriver driver;
	public void initialization()
	{
		///get set go
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shiv1150\\Downloads\\Compressed\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.spicejet.com/");
	}
	public void takeScreenShot() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("file path"));	
	}
	
	public void writeToExcel() throws IOException
	{
		//import the excel from the webdriver directory
		File src=new File("path");
		//loading the file
		FileInputStream finput=new FileInputStream(src);
		XSSFWorkbook workbook=new XSSFWorkbook(finput);
		XSSFSheet sheet=workbook.getSheetAt(0);
		for (int i=1;i<=sheet.getLastRowNum();i++)
		{
			XSSFCell cell=sheet.getRow(i).getCell(1);

		}
	}

}
