package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;//Global variable
	
	
	public  LoginPage(WebDriver rdriver)//constructor created
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);//
		
	}
	
	@FindBy(name="btnReset")//identify reset element, or id =""
	@CacheLookup
	WebElement btnReset;//store it in variable
	
	@FindBy(name="uid")//identify username element, or id =""
	@CacheLookup
	WebElement txtUsername;//store it in variable
	
	@FindBy(name="password")//identify password element
	@CacheLookup
	WebElement txtPassword;//store it in variable
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	public void clickBtnReset() // create method for username
	{
		btnReset.click();
	}
	
	public void setUserName(String uname) // create method for username
	{
		txtUsername.sendKeys(uname);
			
	}
	public void setPassword(String Pswd)// create method for password
	{
		
		txtPassword.sendKeys(Pswd);
	}
	public void clickLogin()
	{
	btnLogin.click();
	}
	public void clickLogout()
	{
	lnkLogout.click();
	}
	
}
