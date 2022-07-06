package com.mrp.pageObjects.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocators {

	@FindBy(xpath = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg' or @class='modal-content background-customizable modal-content-mobile visible-md visible-sm']//input[@id='signInFormUsername']")
    public WebElement userName;

	@FindBy(xpath = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg' or @class='modal-content background-customizable modal-content-mobile visible-md visible-sm']//input[@id='signInFormPassword']")
	public WebElement password;

	@FindBy(xpath = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg' or @class='modal-content background-customizable modal-content-mobile visible-md visible-sm']//input[@type='Submit']")
	public WebElement loginbutton;

	@FindBy(xpath = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg' or @class='modal-content background-customizable modal-content-mobile visible-md visible-sm']//a[text()='Forgot your password?']")
	public static WebElement ForgotPassword;
	
	@FindBy(xpath = "//span[@class='ant-avatar-string']")
	public static WebElement userLogo;
	
	@FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div/aside/div[1]/button[2]/div/div")
	public static WebElement userCustLogo;

	@FindBy(xpath = "//h2")
	public static WebElement Title;

	@FindBy(xpath = "/html/body/div[1]/section/header/div/div[2]/div/div/button")
	public WebElement profileUserName;

	@FindBy(xpath = "//button[@class='u-no-button']")
	public WebElement logOutBtn;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]//p[@id=\"loginErrorMessage\"]")
	public WebElement invalidCredentialsErrorMessage;
	
	@FindBy(xpath = "//*[@id='__next']/section/header/div/div[2]/div/div/button")
	public WebElement logOutIcon;
	
	@FindBy(xpath = "//*[@id='__next']/div/div[1]/div/aside/div[2]/div/div/div[2]/button")
	public static WebElement btnLogout;
	
	@FindBy(xpath = "//input[@id='username']")
	public static WebElement iptUserName;

	@FindBy(xpath = "//button[text()='Reset my password']")
	public static WebElement btnResetPassword;

	@FindBy(xpath = "//button[text()='Change Password']")	
	public static WebElement btnChangePassword;

}
