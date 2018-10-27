package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XlUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test (dataProvider ="LoginData") // Real Testcase
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		driver.get(baseurl);
		logger.info("Url is opened");
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("User name provided"); //logger msg
	    lp.setPassword(password);
		logger.info("Password provided"); //logger msg
		lp.clickLogin();
		logger.info("Validation Started"); //logger msg
		//lp.clickLogout();
		//logger.info("Validation finished");
		
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();// click ok of alert window
			driver.switchTo().defaultContent();//come to main page
			Assert.assertTrue(false);// because we have provided invalid data
			Thread.sleep(3000);
			logger.info("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			logger.info("login passed");
		}
	}
		public boolean isAlertPresent()//Supported method to verify alert is present /not
		{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
			
		
	
	@DataProvider(name= "LoginData")
	public  String[][] getData() throws IOException // Data provider methodto read data from Excel file 
	                             //and store in 2 dimensional array and pass to Testcase
	{
		//String path = C:\Users\sanil\eclipse-workspace\inetbankingv3\src\test\java\com\inetbanking\testData\TestData.xlsx
		//normal path of xlsx file in project; to mke it short chk below code 
		//use system.getProperty("user.dir"
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/TestData.xlsx";
		//have to get no of Row and col in xlsx file
		int rownum = XlUtils.getRowCount(path, "Sheet1");
		int colcount =XlUtils.getCellCount(path, "Sheet1",1);
		
		// create 2 dimensional array ; with same size as of excel file
		String logindata[][]= new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)// 1 st row is header so i=1
		{
			for(int j=0;j<colcount;j++)// column have no header
			{
				logindata[i-1][j]=XlUtils.getCellData(path,"Sheet1", i,j);//1,0
			}
		}
		
		return logindata;
		
	}
		
		
	}


