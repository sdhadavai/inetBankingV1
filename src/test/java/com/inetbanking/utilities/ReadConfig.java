package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	public ReadConfig() {
		//File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(new File("./Configuration/config.properties"));
			//FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is: " + e.getMessage());
		}
		  		
	} 
	public String getAppURL() {
		return prop.getProperty("baseURL");
		
	}
	public String getUserName() {
		return prop.getProperty("userId");
		
	}
	public String getpassword() {
		return prop.getProperty("password");
		
	}
	public String getChromePath() {
		return prop.getProperty("chromePath");
		
	}
	public String getFirefoxPath() {
		return prop.getProperty("firefoxPath");
		
	}
	public String getIEPath() {
		return prop.getProperty("iePath");
		
	}
	
	

}
