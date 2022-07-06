package com.mrp.pageObjects.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DataStudioDiscoverLocators {

	@FindBy(xpath =  "//a[@href='/mvp/data/list']")
    public static WebElement dataStudio;
	
	@FindBy(xpath="//span[text()='Lists']")
	public static WebElement lists;
	
	@FindBy(xpath="//button[contains(text(),'Create a List')]")
	public static WebElement createlist;
	
	@FindBy(xpath="//h2[contains(text(),'Account List')]")
	public static WebElement accountList;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	public static WebElement Continue;
	
	@FindBy(xpath="//h2[contains(text(),'Discover Prelytix Data')]")
	public static WebElement discoverPrelytix;
	
	@FindBy(xpath="//input[@placeholder='Enter a name']")
	public static WebElement listName;
	
	@FindBy(xpath="//button[contains(text(),'Finish')]")
	public static WebElement btnFinish;
	
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	public static WebElement btnGoBack;

	@FindBy(xpath="//div[contains(text(),'All Lists')]")
	public static WebElement allLists;
	
	@FindBy(xpath="//html/body/div/div/div[1]/div[2]/div/h1")
	public static WebElement txtFileCreated;

	@FindBy(xpath="//input[@id='search']")
	public static WebElement txtSearch;
	
	@FindBy(xpath="//div[contains(text(),'Begin typing to select a geography')]")
	public static WebElement txtGeography;
	
	@FindBy(xpath="//div[contains(text(),'Select Yes or No')]")
	public static WebElement selectLimit;
	
	@FindBy(xpath="//div[contains(text(),'Select an option')]")
	public static WebElement txtIndustry;
	
	@FindBy(xpath="//div[contains(text(),'Enter a minimum value in millions (USD)')]/../../../div[2]")
	public static WebElement drpRevenueMin;	
	
	@FindBy(xpath="//div[contains(text(),'Enter a minimum value in millions (USD)')]/../../../../div[2]/div/div")
	public static List<WebElement> tblRevenueMin;
	
	@FindBy(xpath="//div/div[1]/div[2]/div[2]/label/div/div/div[1]")
	public static WebElement txtRevenueMin;
	
	@FindBy(xpath="//div[@class='flex justify-between items-end w-full'][2]/label//input")
	public static WebElement iptRevenueMin;	
	
	@FindBy(xpath="//div[@class=' css-y6oup3']")
	public static WebElement selectRevenueMin;	
	
	@FindBy(xpath="//div/div[1]/div[2]/div[3]/label/div/div/div[1]/div[3]/div/input")
	public static WebElement iptEmployeeMin;	
	
	@FindBy(xpath="//*[@id='__next']/div/div[1]/div[2]/div[2]/label/div/div/div[2]/div[1]")
	public static WebElement RevenueMinCrs;
			
	@FindBy(xpath="//div[contains(text(),'Enter a maximum value in millions (USD)')]")
	public static WebElement txtRevenueMax;
	
	@FindBy(xpath="//div[contains(text(),'Enter a maximum value in millions (USD)')]/../../../div[2]")
	public static WebElement drpRevenueMax;

	@FindBy(xpath="//div[contains(text(),'Enter a maximum value in millions (USD)')]/../../../../div[2]/div/div")
	public static List<WebElement> tblRevenueMax;
	
	@FindBy(xpath="//*[@id='__next']/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[1]")
	public static WebElement RevenueMaxCrs;
	
	@FindBy(xpath="//div[text()='Enter a minimum value']")
	public static WebElement txtEmployeeMin;
	
	@FindBy(xpath="//div[text()='Enter a maximum value']")
	public static WebElement txtEmployeeMax;
	
	@FindBy(xpath="//p[contains(text(),'Revenue minimum cannot be greater than or equal to maximum')]")
	public static WebElement msgRevenue;
	
	@FindBy(xpath="//p[contains(text(),'Employee minimum cannot be greater than or equal to maximum')]")
	public static WebElement msgEmployee;
	
	@FindBy(xpath="//span[contains(text(),'This list name is already in use.')]")
	public static WebElement msgListName;
	
	@FindBy(xpath="//*[@id='__next']/div/div[1]/div[1]/div[2]/div")
	public static WebElement statusBar;
	
	@FindBy(xpath="//span[contains(text(),'geography')]")
	public static WebElement geography;
	
	@FindBy(xpath="//span[contains(text(),'limit results to accounts headquartered in selected geography?')]")
	public static WebElement limitResults;
	
	@FindBy(xpath="//span[contains(text(),'industry')]")
	public static WebElement industry;
	
	@FindBy(xpath="//div[contains(text(),'Select an option')]/../../../div[2]")
	public static WebElement drpIndustry;
	
	@FindBy(xpath="//div[contains(text(),'Select an option')]/../../../../div[2]/div/div")
	public static List<WebElement> tblIndustry;
	
	@FindBy(xpath="//span[contains(text(),'industry')]/../div/div[1]/div[1]")
	public static WebElement iptIndustry;
	
	@FindBy(xpath="//div/div[2]/div/div[text()='Construction']")
	public static WebElement selectConstruction;
	
	@FindBy(xpath="//span[contains(text(),'industry')]/../div/div[2]/div/div[text()='Education']")
	public static WebElement selectEducation;
	
	@FindBy(xpath="//span[contains(text(),'Annual Revenue')]")
	public static WebElement annualRevenue;
	
	@FindBy(xpath="//span[contains(text(),'employee count')]")
	public static WebElement employeeCount;
	
	@FindBy(xpath="//div[contains(text(),'Enter a minimum value in millions (USD)')]")
	public static WebElement plcHldrMinRevenue;
	
	@FindBy(xpath="//div[contains(text(),'Enter a maximum value in millions (USD)")
	public static WebElement plcHldrMaxRevenue;
	
	@FindBy(xpath="//div[contains(text(),'Select Yes or No')]")
	public static WebElement plcHldrHeadQuarter;
	
	@FindBy(xpath="//div/div[1]/div[2]/div[1]/label[2]/div/div/div[1]")
	public static WebElement drpHeadQuarter;
	
	@FindBy(xpath="//div[contains(text(),'Select Yes or No')]/../../../../div[2]/div/div")
	public static List<WebElement> tblHeadQuarter;
	
	@FindBy(xpath="//div/div[2]/div/div[(text()='Yes')]")
	public static WebElement drpHeadQuarterYes;
	
	@FindBy(xpath="//div/div[2]/div/div[(text()='No')]")
	public static WebElement drpHeadQuarterNo;
	
	@FindBy(xpath="//div[contains(text(),'Select an option')]")
	public static WebElement plcHldrLimit;
	
	@FindBy(xpath="//span[contains(text(),'limit results to all known locations or just headquarters?')]/../div/div/div[2]/div")
	public static WebElement drpLimit;
	
	@FindBy(xpath="//span[contains(text(),'limit results to all known locations or just headquarters?')]/../div/div[2]/div")
	public static List<WebElement> tblLimit;
	
	@FindBy(xpath="//span[contains(text(),'employee count')]/../div/div/div[2]/div[1]")
	public static WebElement crsEmployeeMin;
	
	@FindBy(xpath="//span[contains(text(),'employee count')]/../div/div/div[2]")
	public static WebElement drpEmployeeMin;

	@FindBy(xpath="//div[contains(text(),'Enter a minimum value')]/../../../../div[2]/div/div")
	public static List<WebElement> tblEmployeeMin;
	
	@FindBy(xpath="//span[contains(text(),'employee count')]/../../div[2]/div/div[2]/div[1]")
	public static WebElement crsEmployeeMax;
	
	@FindBy(xpath="//span[contains(text(),'employee count')]/../../div/div/div[1]")
	public static WebElement drpEmployeeMax;
	
	@FindBy(xpath="//div[contains(text(),'Enter a maximum value')]/../../../../div[2]/div/div")
	public static List<WebElement> tblEmployeeMax;
	
	@FindBy(xpath="//p[contains(text(),'The maximum value you can enter in this field is 5,000,000')]")
	public static WebElement msgMaxEmployee;
	
	@FindBy(xpath="//div[@class=' css-9337yi-menu']//div[text()='60000000']")
	public static WebElement ipt90k;
	
	@FindBy(xpath="//div[@class='flex justify-between items-end w-full'][3]/label//input")
	public static WebElement iptEmployeeMin60m;
	
	@FindBy(xpath="//div[@class='flex justify-between items-end w-full'][1]/label[1]//input")
	public static WebElement iptGeography;

	@FindBy(xpath="//div[1]/div[2]/div[1]/label[1]/div/div[2]/div/div[1]")
	public static WebElement searchGeography;
	
	@FindBy(xpath="//p[text()='India']")
	public static WebElement selectRegion;
	
	@FindBy(xpath ="//div[text()='RajyaTest_1652207810151' or text()='QA Company']")
	public static WebElement company;
	
	

}
