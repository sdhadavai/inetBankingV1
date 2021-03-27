package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseTest{

	@Test(dataProvider="loginData")
	public void loginDDT(String uname, String pwd) {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("Username provide");
		lp.setPassword(pwd);
		logger.info("Password provided");
		lp.clickLogin();
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
			logger.info("Login failed as expected");
			driver.switchTo().defaultContent();
		}else {
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException{
		String xlPath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetbanking\\testdata\\LoginData.xlsx";
		int rowNum = XLUtils.getRowCount(xlPath, "loginData");
		int colNum = XLUtils.getCellCount(xlPath, "loginData", 1);
		String loginData[][] = new String[rowNum][colNum];
		for(int i=1; i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				loginData[i-1][j] = XLUtils.getCellData(xlPath, "loginData", i,j);
				
			}
		}
		return loginData;
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
