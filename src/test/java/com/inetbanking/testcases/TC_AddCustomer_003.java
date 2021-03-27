package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;

public class TC_AddCustomer_003 extends BaseTest {
	
	@Test
	public void addCutomer() throws IOException, InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userId);
		logger.info("Username provided");
		lp.setPassword(password);
		logger.info("Password provided");
		lp.clickLogin();
		logger.info("Login button clicked");
		
		AddCustomerPage addCust = new AddCustomerPage(driver);
		logger.info("Entering Customer Details");
		addCust.clickAddCustomerLink();
		addCust.setCustomerName("Sri");
		addCust.setGender("female");
		addCust.setDOB("12", "02", "1980");
		addCust.setAddress("BHEL, New MIG");
		addCust.setCity("Hyd");
		addCust.setState("TS");
		addCust.setPin("500001");
		addCust.setPhone("1234569870");
		
		String email = randomString()+"@gmail.com";
		addCust.setEmail(email);
		Thread.sleep(3000);
		addCust.clickSubmit();
		
		
		String pageSource = driver.getPageSource();
		if(pageSource.contains("Customer Registered Successfully!!!")) {
			Assert.assertTrue(true);
			logger.info("Customer Added Successfully");
		}else {
			
			logger.info("Customer not added");
			captureScreen(driver, "addCutomer");
			Assert.assertTrue(false);
		}
	}

}
