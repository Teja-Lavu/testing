package com.mrp.pageObjects.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLocationLocators {
	
	@FindBy(xpath =  "//span[contains(text(),'Accounts')]")
    public static WebElement Accounts;

	@FindBy(xpath = "//div[text()='Locations']")
	public static WebElement tabLocations;

	@FindBy(xpath = "//span[text()='Nacro']")
	public static WebElement selectAccount;
	
	@FindBy(xpath = "//span[text()='Stanford University']")
	public static WebElement selectAccountProd;
	
	@FindBy(xpath = "//div[text()='Location']")
	public static WebElement lblLocation;

	@FindBy(xpath = "//div[text()='Topic']")
	public static WebElement lblTopic;
	
	@FindBy(xpath = "//span[text()='Score + Topic']")
	public static WebElement lblScoreTopic;
	
	@FindBy(xpath = "//span[text()='Address']")
	public static WebElement lblAddress;
	
	@FindBy(xpath = "//span[text()='Action']")
	public static WebElement lblAction;
	
	@FindBy(xpath = "//div[@class=' css-18o81tj-control']/div[2]")
	public static WebElement drpdwnLocation;
	
	@FindBy(xpath="//div[@class=' css-9f2hmr']")
	public static List<WebElement> tblLocation;
	
	@FindBy(xpath = "//div[text()='- All Topics -']")
	public static WebElement drpdwnTopic;
	
	@FindBy(xpath="//div[@class=' css-18v2fc0']")
	public static List<WebElement> tblTopic;
	
	@FindBy(xpath="//a[text()='View Location']")
	public static WebElement linkLocation;
	
	@FindBy(xpath="//div[text()='10-12 Park Place, Lawn Lane, London, England, United Kingdom' or text()='4426 Chippendale Ct, Union City, California, United States']")
	public static WebElement selectLocation;
	
	@FindBy(xpath="//td[text()='10-12 Park Place, Lawn Lane, London, England, United Kingdom' or text()='4426 Chippendale Ct, Union City, California, United States']")
	public static WebElement resultLocation;
	
	@FindBy(xpath="//div[text()='4426 Chippendale Ct, Union City, California, United States']")
	public static WebElement selectLocationprod;
	
	@FindBy(xpath="//td[text()='4426 Chippendale Ct, Union City, California, United States']")
	public static WebElement resultLocationprod;
	
	@FindBy(xpath="//div[text()='Supply Chain']")
	public static WebElement selectTopic;
	
	@FindBy(xpath="//td[text()='Supply Chain']")
	public static WebElement resultTopic;

	@FindBy(xpath="//h2[text()='Account Score']")
	public static WebElement lblAccountScore;

}
