package com.flipkart.bigbillionday;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SSS {
	
	WebDriver driver;
		@Test(dataProvider="login")
		public void unameTest(String un) throws Exception
		{
			
		System.setProperty("webdriver.chrome.driver", "D:\\New folder (3)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		
		
		WebElement e=driver.findElement(By.name("identifier"));
		//e.click();
		e.sendKeys(un);
		Thread.sleep(2000);
		
		driver.close();
		
				
		}	
		
		public static String excelreader(int rn, int cn) throws Exception
		{
			FileInputStream fis= new FileInputStream("C:\\Users\\Monty\\Desktop\\bookA.xlsx");
			
			Workbook wb= new XSSFWorkbook(fis);
			
			Sheet sh=wb.getSheetAt(0);
			return sh.getRow(rn).getCell(cn).getStringCellValue();
			
			
			
		}
		
		@DataProvider
		public Object[][] login() throws Exception
		{
			String [][] arr=new String[4][1];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 1; j++) {
					arr[i][j]= SSS.excelreader(i, j);
					
				}
				
			}
			return arr;
			
		}
	

}
