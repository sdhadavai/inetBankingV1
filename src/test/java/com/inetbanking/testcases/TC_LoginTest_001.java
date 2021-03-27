package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseTest{
	
	@Test
	public void loginTest() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		logger.info("WebPage opened");
		lp.setUserName(userId);
		logger.info("Entered UserID");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickLogin();
		logger.info("Clicked on Login button");
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
			
		}
		
	}

}
