package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void AddNewCustomer() throws InterruptedException, IOException{
		
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name provided"); //logger msg
	    lp.setPassword(password);
		logger.info("Password provided"); //logger msg
		lp.clickLogin();
		logger.info("Validation Started"); //logger msg
		Thread.sleep(3000);	
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer(); // click on add new customer link
		logger.info("providing customer details....");
		addcust.custName("Radhika");
		addcust.custgender("Female");
		Thread.sleep(3000);
		addcust.custdob("01","-08","-1980");
		
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email = randomestring() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(3000);
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			CaptureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
	
}	
		
		
		
		
		
		
		
		
		
		
	


