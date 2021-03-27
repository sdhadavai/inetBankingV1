package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver driver;
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddCustomer;
	
	@FindBy(how=How.NAME, using="name")
	WebElement txtCName;
	
	@FindBy(how=How.NAME, using="rad1")
	WebElement radGender;
	
	@FindBy(how=How.ID_OR_NAME, using="dob")
	WebElement txtDOB;
	
	@FindBy(name="addr")
	WebElement txtAddress;
	
	@FindBy(how=How.NAME, using="city")
	WebElement txtCity;
	
	@FindBy(how=How.NAME, using="state")
	WebElement txtState;
	
	@FindBy(name="pinno")
	WebElement txtPin;
	
	@FindBy(how=How.NAME, using="telephoneno")
	WebElement txtPhone;
	
	@FindBy(name="emailid")
	WebElement txtEmail;
	
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	public void clickAddCustomerLink() {
		lnkAddCustomer.click();
	}
	
	public void setCustomerName(String cName) {
		txtCName.sendKeys(cName);
	}
	
	public void setGender(String cGender) {
		radGender.click();
	}
	public void setDOB(String mm, String dd, String yyyy) {
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yyyy);
	}
	
	public void setAddress(String cAdd) {
		txtAddress.sendKeys(cAdd);
		
	}
	
	public void setCity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void setState(String state) {
		txtState.sendKeys(state);
	}
	
	public void setPin(String pin) {
		txtPin.sendKeys(pin);
	}
	
	public void setPhone(String phone) {
		txtPhone.sendKeys(phone);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}

}
