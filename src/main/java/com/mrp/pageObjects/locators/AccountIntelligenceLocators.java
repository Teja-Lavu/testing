package com.mrp.pageObjects.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountIntelligenceLocators {

	
	@FindBy(xpath =  "//table/tbody/tr[1]/td[1]")
    public static WebElement selectAccount;
	
	@FindBy(xpath =  "//div[text()='Intelligence']")
    public static WebElement tabIntelligence;
	
	@FindBy(xpath =  "//div[text()='Location']")
    public static WebElement lblLocation;

	@FindBy(xpath =  "//div[text()='Topic']")
    public static WebElement lblTopic;
	
	@FindBy(xpath =  "//div[text()='Time Frame']")
    public static WebElement lblTimeframe;
	
	@FindBy(xpath =  "//h2[text()='Account Score']")
    public static WebElement lblAccountScore;
	
	@FindBy(xpath =  "//h2[text()='Top Key Terms']")
    public static WebElement lblTopKeyTerms;
	
	@FindBy(xpath =  "//h2[text()='Top Vendor Exposure']")
    public static WebElement lblTopVendorExposure;
	
	@FindBy(xpath =  "//h1[text()='WEBSITE ACTIVITY']")
    public static WebElement lblWebsiteActivity;
	
	@FindBy(xpath =  "//div[@class='w-full text-right pt-2']/div[2]/div[2]/div/div[2]")
    public static WebElement drpTopic;
	
	@FindBy(xpath =  "//div[text()='Supply Chain']")
    public static WebElement selectTopic;
	
	@FindBy(xpath =  "//span[text()='Last 7 days']")
    public static WebElement drpTimeframe;
	
	@FindBy(xpath =  "//span[text()='Last 365 days']")
    public static WebElement selectTimeframe;

	@FindBy(xpath =  "//div[text()='88']")
    public static WebElement accountScoreNumber;
	
	@FindBy(xpath =  "//div[@class='p-2 flex']/div[2]")
    public static WebElement accountScorebar;
		
	@FindBy(xpath =  "//div[text()='- All Topics -']")
    public static WebElement selectAllTopics;

	@FindBy(xpath =  "//div[@class='flex']//section[1]//canvas")
    public static WebElement chartTopKeyTerms;
	
	@FindBy(xpath =  "//div[@class='flex']//section[2]//canvas")
    public static WebElement chartTopVendorExposure;

	@FindBy(xpath =  "//span[text()='PAGE']")
    public static WebElement lblPage;
	
	@FindBy(xpath =  "//span[text()='VISITS']")
    public static WebElement lblVisits;

	@FindBy(xpath =  "//span[text()='LAST VISIT DATE']")
    public static WebElement lblLastVisitDate;
	
	@FindBy(xpath =  "//div[@class='min-h-[276px]']/table/tbody/tr[1]")
    public static WebElement dataWebsiteActivity;
	
	@FindBy(xpath =  "//button[text()='Last']/../button[3]")
    public static WebElement btnNextPage;

	@FindBy(xpath =  "//button[text()='First']/../div/span")
    public static WebElement pagination;

}
