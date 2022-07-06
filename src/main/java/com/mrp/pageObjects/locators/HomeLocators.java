package com.mrp.pageObjects.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeLocators {

	@FindBy(xpath =  "//h2[text()='Account Reach']")
    public static WebElement txtAccountReach;
	
	@FindBy(xpath =  "//h2[text()='Tactic Performance']")
    public static WebElement txtTacticPerformance;
	
	@FindBy(xpath =  "//h2[text()='Average Topic Score']")
    public static WebElement txtAverageTopicScore;
	
	@FindBy(xpath =  "//h2[text()='Activity']")
    public static WebElement txtActivity;
	
	@FindBy(xpath =  "//h2[text()='Top Accounts']")
    public static WebElement txtTopAccounts;
	
	@FindBy(xpath =  "//main/div[3]//table/tbody/tr[1]/td[1]/a")
    public static WebElement linkTopic;
	
	@FindBy(xpath =  "//main/div[3]//table/tbody/tr[1]/td[3]/a")
    public static WebElement linkScoreDistribution;

	@FindBy(xpath =  "//h2[text()='Share of Voice']")
    public static WebElement txtShareofVoice;
	
	@FindBy(xpath =  "//button[text()='Close']")
    public static WebElement btnClose;

	@FindBy(xpath =  "//div[@class='px-4']/section[1]//canvas")
    public static WebElement graphScoreDistribution;
	
	@FindBy(xpath =  "//div[@class='px-4']/section[2]//canvas")
    public static WebElement graphShareOfVoice;
	
	@FindBy(xpath =  "//div[@class='flex mb-4']/div[1]/div/div[2]/div")
    public static WebElement drpdwnTopicScoreSort;

	@FindBy(xpath =  "//div[@class='flex mb-4']/div[2]/div/div[1]/div[2]/div")
    public static WebElement drpdwnTopic;
	
	@FindBy(xpath =  "//main/section//table/tbody/tr[1]/td[1]/a")
    public static WebElement linkAccount;
	
	@FindBy(xpath =  "//main/section//table/tbody/tr[1]/td[2]//span")
    public static WebElement score1;

	@FindBy(xpath =  "//button[text()='Last']")
    public static WebElement btnLastPage;

	@FindBy(xpath =  "//main/section//table/tbody/tr[1]/td[2]/div/text()")
    public static WebElement txtTopic;

	@FindBy(xpath =  "//button[text()=' Filters']")
    public static WebElement btnFilters;
	
	@FindBy(xpath =  "//div[text()='All Types']")
    public static WebElement drpdwnfilterType;
	
	@FindBy(xpath =  "//table/tbody/tr")
    public static WebElement tableAccounts;
	
	@FindBy(xpath =  "//table/tbody/tr[1]/td[2]/span[2]")
    public static WebElement accountsTopic;

	@FindBy(xpath =  "//span[text()='Home']")
    public static WebElement Home;
	
	@FindBy(xpath =  "//div[@class='w-full h-[230px]']/div[1]/div[2]/a[2]")
    public static WebElement linkActivity2;
	
	@FindBy(xpath =  "//main/div[3]//table/tbody/tr[1]/td[2]//span")
    public static WebElement avgScore;

	@FindBy(xpath =  "//h1[text()='Vendors']")
    public static WebElement vendors;

	@FindBy(xpath =  "//div[text()='Anti-Virus']")
    public static WebElement selectTopic;

	@FindBy(xpath =  "//div[text()='Intelligence']")
    public static WebElement tabIntelligence;
	
	@FindBy(xpath =  "//div[text()='Website Click']")
    public static WebElement selectWebsiteClick;
	
	@FindBy(xpath =  "//div[@class='w-full h-[230px]']/div[1]/div[2]")
    public static WebElement firstActivity;
	
	@FindBy(xpath =  "//div[@class='w-full h-[230px]']/div[1]/div[2]/a[1]")
    public static WebElement activityAccount;
	
	@FindBy(xpath =  "//h2[text()='Top Account Score']")
    public static WebElement lblTopAccountScore;
	
	@FindBy(xpath =  "//div[text()='Display Click']")
    public static WebElement selectDisplayClick;

	@FindBy(xpath =  "//div[text()='Topic Score: Ascending']")
    public static WebElement selectAscending;
	
	@FindBy(xpath =  "//div[text()='Topic Score: Descending']")
    public static WebElement selectDescending;



}
