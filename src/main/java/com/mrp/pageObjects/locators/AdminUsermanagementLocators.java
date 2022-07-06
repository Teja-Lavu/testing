package com.mrp.pageObjects.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminUsermanagementLocators {
	
	@FindBy(xpath = "//span[text()='Admin Studio']/..")
	public static WebElement btnAdmin;
	
	@FindBy(xpath = "//span[contains(text(),'Users')]")
	public static WebElement btnUsers;
	
	@FindBy(xpath = "//button[contains(text(),'Create User')]")
	public static WebElement btnCreateUser;
	
	@FindBy(xpath = "//span[text()='First Name*']/../input")
	public static WebElement iptfirstName;
	
	@FindBy(xpath = "//span[text()='First Name*']")
	public static WebElement lblfirstName;
	
	@FindBy(xpath = "//span[text()='Last Name*']/../input")
	public static WebElement iptlastName;
	
	@FindBy(xpath = "//span[text()='Last Name*']")
	public static WebElement lbllastName;
	
	@FindBy(xpath = "//span[text()='Email*']/../input")
	public static WebElement iptemail;
	
	@FindBy(xpath = "//span[text()='Email*']")
	public static WebElement lblemail;
	
	@FindBy(xpath = "//span[text()='Password*']")
	public static WebElement lblPassword;
	
	@FindBy(xpath = "//span[text()='Role*']")
	public static WebElement lblRole;
	
	@FindBy(xpath = "//div[text()='Select a role']")
	public static WebElement dropdownRole;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	public static WebElement btnCreate;
	
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	public static WebElement btnCancel;
	
	@FindBy(xpath = "//span[text()='Password*']/../input")
	public static WebElement iptPassword;
	
	@FindBy(xpath = "//div[contains(text(),'Company Admin')]")
	public static WebElement selectCompanyAdmin;
	
	@FindBy(xpath = "//div[contains(text(),'Member')]")
	public static WebElement selectMember;
	
	@FindBy(xpath = "//p[text()='New User has been created.']")
	public static WebElement usersuccessmessage;
	
	@FindBy(xpath = "//span[text()='Incorrect email format.']")
	public static WebElement alertEmail;
	
	@FindBy(xpath = "//span[contains(text(),'Password must be a minimum of 6 characters in length with at least 1 uppercase, 1 lowercase, 1 number, and 1 special character.')]")
	public static WebElement alertPassword;
	
	
}
