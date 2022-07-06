package com.mrp.pageObjects.actions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.LoginLocators;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;

public class LoginPageActions {
	
	LoginLocators loginLocators = new LoginLocators();

	public LoginPageActions() {
		this.loginLocators = new LoginLocators();
		PageFactory.initElements(DriverManager.getDriver(), this.loginLocators);
	}

	public void fillUserName(String userName) throws InterruptedException {
		GenericMethods.waitForElementVisiblity(loginLocators.userName, 10);
		GenericMethods.FillByWebElement(loginLocators.userName, userName);
	}
	
	public void fillEmail(String email) throws InterruptedException {
		GenericMethods.waitForElementVisiblity(loginLocators.iptUserName, 10);
		GenericMethods.FillByWebElement(loginLocators.iptUserName, email);
	}
	

	public void fillPassword(String password) throws InterruptedException {
		GenericMethods.FillByWebElement(loginLocators.password, password);
	}

	public void clickLoginButton() {
		GenericMethods.clickByWebElement(loginLocators.loginbutton);

	}

	public void profileUserName() {
		GenericMethods.clickByWebElement(loginLocators.profileUserName);
	}

	public String Title() {
		String text = GenericMethods.getText(LoginLocators.Title);
		return text;
	}

	public void clicklogOutbtn() {
		GenericMethods.waitForElementVisiblity(loginLocators.logOutIcon, 10);
		GenericMethods.clickByWebElement(loginLocators.logOutIcon);	
		GenericMethods.waitForElementVisiblity(loginLocators.logOutBtn, 5);
		GenericMethods.clickByWebElement(loginLocators.logOutBtn);
	}

	public void Login(String userName, String password) throws InterruptedException {
		fillUserName(userName);
		fillPassword(password);
		clickLoginButton();

	}	


}
