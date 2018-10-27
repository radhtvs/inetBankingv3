package com.inetbanking.pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	public  WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy (xpath ="/html/body/div[3]/div/ul/li[2]/a") //@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
    
	@FindBy(name="name")// @FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy (name = "rad1")
	@CacheLookup
	WebElement rdGender;
	
	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;
	
	
	/*@FindBy (name = "dob")
	@CacheLookup
	WebElement txtdob;*/
	
	@FindBy (name = "addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy (name = "city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy (name = "state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy (name = "pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy (name = "telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy (name = "emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy (name = "password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy (name ="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickAddNewCustomer(){
		lnkAddNewCustomer.click();
		
	}
	
	public void custName(String cname ) {
		txtCustomerName.sendKeys(cname);
	}
	public void custgender(String gender) {
		rdGender.click();
	}
	
	public void custdob(String yy,String mm, String dd) {
	txtdob.sendKeys(yy);
	txtdob.sendKeys(mm);
	txtdob.sendKeys(dd);
	}
	
	
	
	
	
	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {//if cpinno is taken as int cpinno
		txtpinno.sendKeys(String.valueOf(cpinno));//optional ; converting into string format 
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
}
