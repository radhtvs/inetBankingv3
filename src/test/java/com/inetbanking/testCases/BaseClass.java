package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {//Created Base class to store all common variables
	
	ReadConfig readconfig = new ReadConfig(); // created an object for ReadConfig class of utilitity package
	public String baseurl = readconfig.getApplicationURL();
	public String username = readconfig.getUsername() ;
	public String password= readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger; //Added logger
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) //Created common method used by all Tcs
	{  

	
	logger= Logger.getLogger("ebanking");//initialize logger
	 PropertyConfigurator.configure("log4j.properties");//specify logj4property file
	 
	   System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		driver = new FirefoxDriver();
		 /*System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver = new ChromeDriver();*/
		/*System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
		driver = new EdgeDriver();*/
	 
	/* if (br.equals("firefox")) {
			// Firefox Browser
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}

		else if (br.equals("chrome")) {
			// opens the browser
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}*/

		driver.get(baseurl);
		
		// Global implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
	
	public void CaptureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String randomestring() {//created a method to create random string; 
		//it can be part of BaseClass as it can be used by any Testcases
		String randomstring1 = RandomStringUtils.randomAlphabetic(8);//will generate random 8 alphabets
		
		return randomstring1;
	}
}
