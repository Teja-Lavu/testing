package com.mrp.pageObjects.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DisplayReportLocators {

	@FindBy(xpath =  "//span[text()='Display Report']")
    public static WebElement selectDisplayReport;
	
	@FindBy(xpath =  "//h1[text()='Display Report']")
    public static WebElement textDisplayReport;	
	
	@FindBy(xpath =  "//dt[text()='Impressions']")
    public static WebElement textImpressions;	
	
	@FindBy(xpath =  "//h2[text()='Account Reach']")
    public static WebElement textAccountReach;
	
	@FindBy(xpath =  "//h2[text()='Cost Analysis']")
    public static WebElement textCostAnalysis;
	
	@FindBy(xpath =  "//dt[text()='Clicks']")
    public static WebElement textClicks;
	
	@FindBy(xpath =  "//dt[text()='Click-Through Rate']")
    public static WebElement textClickThroughRate;
	
	@FindBy(xpath =  "//h2[text()='Site Lift']")
    public static WebElement textSiteLift;

	@FindBy(xpath =  "//dt[text()='Impressions']/../dd")
    public static WebElement NoImpressions;	
	
	@FindBy(xpath =  "//dt[text()='Clicks']/../dd")
    public static WebElement NoClicks;	
	
	@FindBy(xpath =  "//dt[text()='Click-Through Rate']/../dd")
    public static WebElement NoClickThroughRate;
	
	@FindBy(xpath =  "//div[@class='w-1/4 grid gap-2 grid-flow-row-dense auto-rows-min pr-6']/div[1]/div/div[1]")
    public static WebElement prctImpressions;	

	@FindBy(xpath =  "//div[@class='w-1/4 grid gap-2 grid-flow-row-dense auto-rows-min pr-6']/div[2]/div/div[1]")
    public static WebElement prctClicks;
	
	@FindBy(xpath =  "//div[@class='w-1/4 grid gap-2 grid-flow-row-dense auto-rows-min pr-6']/div[3]/div/div[1]")
    public static WebElement prctClickThroughRate;
	
	@FindBy(xpath =  "//div[@class='w-1/4 grid gap-2 grid-flow-row-dense auto-rows-min pr-6']/div[1]/div/div[2]")
    public static WebElement graphImpressions;	

	@FindBy(xpath =  "//div[@class='w-1/4 grid gap-2 grid-flow-row-dense auto-rows-min pr-6']/div[2]/div/div[2]")
    public static WebElement graphClicks;
	
	@FindBy(xpath =  "//div[@class='w-1/4 grid gap-2 grid-flow-row-dense auto-rows-min pr-6']/div[3]/div/div[2]")
    public static WebElement graphClickThroughRate;
	
	@FindBy(xpath =  "//div[@class='pb-4 w-[200px] m-auto']/div/canvas")
    public static WebElement graphAccountReach;

	@FindBy(xpath =  "//div[@class='grid grid-cols-3 gap-6 pb-2']/div//canvas")
    public static WebElement graphCostAnalysis;

	@FindBy(xpath =  "//div[@class='flex-1']/section//canvas")
    public static WebElement graphSiteLift;

	@FindBy(xpath =  "//div[@class='flex flex-col relative p-4 w-full h-full']/p")
    public static WebElement totalAccounts;

}
