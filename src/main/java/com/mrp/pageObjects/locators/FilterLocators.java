package com.mrp.pageObjects.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterLocators {

	@FindBy(xpath =  "//span[@title='Toggle Row Expanded']")
    public static WebElement drpAccountInfo;
	
	@FindBy(xpath =  "//td[contains(text(),'Albania')]")
    public static WebElement txtAlbania;

	@FindBy(xpath =  "//tbody/tr[1]/td[1]/a")
    public static WebElement lnkAccount;

	@FindBy(xpath =  "//h4[text()='Employee Count']//following-sibling::div")
    public static WebElement employeeCount;
	
	@FindBy(xpath =  "//div[text()='- All Locations -']")
    public static WebElement drpLocation;
	
	@FindBy(xpath =  "//h4[text()='Revenue']//following-sibling::div")
    public static WebElement revenueCount;

	@FindBy(xpath =  "//tbody/tr[1]//span[text()='Supply Chain']")
    public static WebElement resultTopic;
	
	@FindBy(xpath =  "//tbody/tr[1]/td[2]//span[1]")
    public static WebElement resultTopScore;

	@FindBy(xpath =  "//a[text()='Top 3 Accounts']")
    public static WebElement top3Accounts;
	
	@FindBy(xpath =  "//div/span[text()='total visits']//ancestor::div[2]/span")
    public static WebElement countVisits;

	@FindBy(xpath =  "//section[2]/div/table/tbody/tr/td[3]/span")
    public static WebElement countImpressions;

	@FindBy(xpath =  "//tbody[@Class='bg-transparent']/tr/td[4]/span")
    public static WebElement countClicks;

	@FindBy(xpath =  "//h4[text()='Industry']//following-sibling::div")
    public static WebElement txtIndustry;


}
