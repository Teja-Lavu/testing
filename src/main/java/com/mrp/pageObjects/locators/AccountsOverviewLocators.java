package com.mrp.pageObjects.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsOverviewLocators {

	@FindBy(xpath =  "//span[contains(text(),'Accounts')]")
    public static WebElement Accounts;

	@FindBy(xpath =  "//input[@name='search']")
    public static WebElement Search;
	
	@FindBy(xpath =  "//span[text()='Fitbit, Inc.' or text()='Craig Hospital']")
    public static WebElement selectAccount;

	@FindBy(xpath =  "//h2[text()='Top Account Score']")
    public static WebElement lblTopAccountScore;
	
	@FindBy(xpath =  "//h4[text()='Fitbit, Inc.' or text()='Craig Hospital']")
    public static WebElement accountFitbit;
	
	@FindBy(xpath =  "//h4[text()='Craig Hospital']")
    public static WebElement accountProd;
	
	@FindBy(xpath =  "//h2[text()='Account Activity']")
    public static WebElement lblAccountActivity;
		
	@FindBy(xpath =  "//p[text()='Summary']")
    public static WebElement lblSummary;
	
	@FindBy(xpath =  "//h2[text()='News']")
    public static WebElement lblNews;

	@FindBy(xpath =  "//div[@class='max-w-[200px]']/div/canvas")
    public static WebElement canvasChart;

	@FindBy(xpath =  "//h3[text()='Composition']")
    public static WebElement lblComposition;

	@FindBy(xpath =  "//p[text()='Fitness']")
    public static WebElement lblFitness;
	
	@FindBy(xpath =  "//p[text()='Implicit Intent']")
    public static WebElement lblImplicitIntent;
	
	@FindBy(xpath =  "//p[text()='Engagement']")
	public static WebElement lblEngagement;		
	
	@FindBy(xpath =  "//h3[text()='Topic']")
	public static WebElement lblTopic;	
	
	@FindBy(xpath =  "//p[text()='Supply Chain' or text()='Enterprise Content Services']")
	public static WebElement textDataAnalytics;	
	
	@FindBy(xpath =  "//h3[text()='Location']")
	public static WebElement lblLocation;	
	
	@FindBy(xpath =  "//div[text()='San Francisco, California, United States'  or text()='Englewood, Colorado, United States']")
	public static WebElement headLocation;	
	
	@FindBy(xpath =  "//p[text()='Boston, Massachusetts, United States' or text()='Englewood, Colorado, United States']")
	public static WebElement verifyLocation;	
	
	@FindBy(xpath =  "//div[text()='Display Clicks']")
	public static WebElement lblDisplayClicks;	

	@FindBy(xpath =  "//div[text()='Display Impressions']")
	public static WebElement lblDisplayImpressions;	
	
	@FindBy(xpath =  "//div[text()='Website Visits']")
	public static WebElement lblWebsiteVisits;	
	
	@FindBy(xpath =  "//div[text()='Content Syndication']")
	public static WebElement lblContentSyndication;	
	
	@FindBy(xpath =  "//div[text()='Sales Development']")
	public static WebElement lblSalesDevelopment;	
	
  @FindBy(xpath =  "//div[@class='flex w-full items-center h-[32px]']")
	public static WebElement calender;	

	@FindBy(xpath =  "//div[@class='flex w-full items-center h-[32px]']/div[1]//button")
	public static WebElement dateFrom;	

	@FindBy(xpath =  "//div[@class='flex w-full items-center h-[32px]']/div[3]//button")
	public static WebElement dateTo;	
	
	@FindBy(xpath =  "//div[text()='Sep']")
	public static WebElement textMonth;		
	
	
	@FindBy(xpath =  "//p[text()='Related Organizations']")
	public static WebElement contentSummary;	

	@FindBy(xpath =  "//nav[@class='flex items-center justify-end p-4 space-x-3 w-full']")
	public static WebElement newsPagination;	

	@FindBy(xpath =  "//tbody/tr[1]/td[1]/a")
	public static WebElement filterAccount;	

	@FindBy(xpath =  "//div[@class='flex w-full items-center h-[32px]']/div[1]//button")
	public static WebElement clickdate;	
	
	@FindBy(xpath =  "//button[@aria-label='Previous Month']")
	public static WebElement clickPrevMonth;	

	@FindBy(xpath =  "//div[@class='react-datepicker__week'][1]/div[1]")
	public static WebElement selectdate;	

	@FindBy(xpath =  "//div[@class='block relative w-full'][2]/canvas")
	public static WebElement showActivity;
	
	@FindBy(xpath =  "//div[@class='flex h-[80px] relative bottom-[8px] border-l border-grey-200 w-[500px]']")
	public static WebElement listDates;

	@FindBy(xpath =  "//div[@class='p-4']/section")
	public static WebElement listNews;
	
}

