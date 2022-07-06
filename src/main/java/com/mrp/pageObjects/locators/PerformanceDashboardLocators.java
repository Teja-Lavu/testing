package com.mrp.pageObjects.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PerformanceDashboardLocators {
	
	@FindBy(xpath =  "//span[text()='Performance Dash']")
    public static WebElement selectParformanceDashboard;
	
	@FindBy(xpath =  "//h1[text()='Performance Dashboard']")
    public static WebElement textParformanceDashboard;
	
	@FindBy(xpath =  "//div[text()='Intelligence']")
    public static WebElement tabIntelligence;

	@FindBy(xpath =  "//button[text()='View Filters']")
    public static WebElement textViewFilters;
	
	@FindBy(xpath =  "//div[@class='relative text-sm']")
    public static WebElement textTimeFrame;
	
	@FindBy(xpath =  "//div[@class='relative text-sm']/button")
    public static WebElement drpTimeFrame;
	
	@FindBy(xpath =  "//span[text()='Last 365 days']")
    public static WebElement drpItem365Days;
	
	@FindBy(xpath =  "//dt[text()='Accounts']")
    public static WebElement textAccounts;
	
	@FindBy(xpath =  "//dt[text()='Accounts W/INTENT']")
    public static WebElement textAccountsIntent;
	
	@FindBy(xpath =  "//h2[text()='Orchestration']")
    public static WebElement textOrchestration;
	
	@FindBy(xpath =  "//dt[text()='Site Visits']")
    public static WebElement textSiteVisits;
	
	@FindBy(xpath =  "//h2[text()='Top Accounts']")
    public static WebElement textTopAccounts;
	
	@FindBy(xpath =  "//th[text()='Account']")
    public static WebElement textAccount;
	
	@FindBy(xpath =  "//th[text()='Score + Topic']")
    public static WebElement textScoreTopic;
	
	@FindBy(xpath =  "//th[text()='Location']")
    public static WebElement textLocation;
	
	@FindBy(xpath =  "//span[text()='AVERAGE']")
    public static WebElement textAverage;
	
	@FindBy(xpath =  "//span[text()='TOTAL']")
    public static WebElement textTotal;
	
	@FindBy(xpath =  "//dt[text()='Impressions']")
    public static WebElement textImpressions;
	
	@FindBy(xpath =  "//div[@class='p-3 flex justify-center']/dt[text()='Site Visits']")
    public static WebElement textSiteVisitsO;
	
	@FindBy(xpath =  "//table[@role='table']/tbody/tr")
	public static List<WebElement> tblAccounts;

	@FindBy(xpath =  "//div[@class='flex md:space-x-4'][1]/div[1]")
    public static WebElement chartImpressions;

	@FindBy(xpath =  "//div[@class='flex md:space-x-4'][1]/div[2]")
    public static WebElement chartSiteVisitsO;

	@FindBy(xpath =  "//dt[text()='Accounts']/../dd")
    public static WebElement NoAccounts;
	
	@FindBy(xpath =  "//dt[text()='Accounts W/INTENT']/../dd")
    public static WebElement NoAccountsINTENT;
	
	@FindBy(xpath =  "//div[@class='bg-white rounded-md transition-shadow shadow p-4 px-4 mb-4'][2]//div[text()='%']")
    public static WebElement prctAccountsINTENT;

	@FindBy(xpath =  "//div[@class='bg-white rounded-md transition-shadow shadow p-4 px-4 mb-4'][2]//canvas")
    public static WebElement chartAccountsINTENT;

	@FindBy(xpath =  "//dt[text()='Site Visits']/../dd")
    public static WebElement NoSiteVisits;
	
	@FindBy(xpath =  "//div[@class='bg-white rounded-md transition-shadow shadow p-4 px-4 mb-4'][3]//div[text()='%']")
    public static WebElement prctSiteVisits;

	@FindBy(xpath =  "//div[@class='bg-white rounded-md transition-shadow shadow p-4 px-4 mb-4'][3]//canvas")
    public static WebElement chartSiteVisits;

	@FindBy(xpath =  "//table[@role='table']/tbody/tr[1]/td[1]/a")
    public static WebElement linkAccount;
	
	@FindBy(xpath =  "//div[@class='mb-3 pb-2 pl-4 pt-4']/h4")
    public static WebElement detailsAccount;
	
	@FindBy(xpath =  "//div[text()='Content Syndication Leads']")
    public static WebElement textContentSyndicationLeads;
	
	@FindBy(xpath =  "//div[text()='Sales Development Leads']")
    public static WebElement textSalesDevelopmentLeads;

	@FindBy(xpath =  "//div[@class='flex md:space-x-4'][2]/div[@class='w-full md:w-1/2'][1]//h3")
    public static WebElement noContentSyndicationLeads;

	@FindBy(xpath =  "//div[@class='flex md:space-x-4'][2]/div[@class='w-full md:w-1/2'][2]//h3")
    public static WebElement noSalesDevelopmentLeads;
	
	@FindBy(xpath =  "//span[text()='Content Syndication']")
    public static WebElement ContentSyndication;
	
	@FindBy(xpath =  "//span[text()='Sales Development']")
    public static WebElement SalesDevelopment;
	
	@FindBy(xpath =  "//table/tbody/tr")
	public static List<WebElement> tblContentSyndication;
	
	@FindBy(xpath =  "//table/tbody/tr")
	public static List<WebElement> tblSalesDevelopment;
}
