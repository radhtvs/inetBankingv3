package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;//Property class with pro object
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);// FileInputStream to read from config properties
			pro = new Properties(); //   initiate pro object
			pro.load(fis);//will load all variables(not values) from the config file 
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	// Methods to get variable values of config.properties file
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url; //return value to Base class because this method will be called by Baseclass
	}
	
	public String getUsername()
	{
	String username=pro.getProperty("username");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getEdgePath()
	{
	String iepath=pro.getProperty("edgepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}
	
	

}
