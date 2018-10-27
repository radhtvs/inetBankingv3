package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
	
	driver.get(baseurl);
	logger.info("Url is opened");
	LoginPage lp= new LoginPage(driver);
	
	lp.clickBtnReset();//
	logger.info("ResetBtn clicked"); //logger msg
	Thread.sleep(3000);
	lp.setUserName(username);
	logger.info("User name provided"); //logger msg
    lp.setPassword(password);
	logger.info("Password provided"); //logger msg
	lp.clickLogin();
	logger.info("Validation Started"); //logger msg
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{
		Assert.assertTrue(true);
		logger.info("Testcase passed");
	}
	else
	{
		CaptureScreen (driver, "loginTest");//In case if Testcase failes to capture screenshot, " loginTest"test method name
		Assert.assertTrue(false);
		logger.info("Testcase failed");
	}
	driver.close();
}	
	
}

