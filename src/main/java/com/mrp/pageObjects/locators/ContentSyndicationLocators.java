package com.mrp.pageObjects.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentSyndicationLocators {

	@FindBy(xpath =  "//span[text()='Content Syndication']")
    public static WebElement selectContentSyndication;
	
	@FindBy(xpath =  "//h1[text()='Content Syndication']")
    public static WebElement textContentSyndication;
	
	@FindBy(xpath =  "//h2[text()='Top Countries']")
    public static WebElement textTopCountries;

	@FindBy(xpath =  "//h2[text()='Employees']")
    public static WebElement textEmployees;
	
	@FindBy(xpath =  "//button[text()='Export Leads']")
    public static WebElement btnExportLeads;
	
	@FindBy(xpath =  "//div[@class='flex gap-x-4']/section[1]//canvas")
    public static WebElement graphTopCountries;

	@FindBy(xpath =  "//div[@class='flex gap-x-4']/section[2]//canvas")
    public static WebElement graphEmployees;
	
	@FindBy(xpath =  "//table/tbody/tr[2]/td[1]//span")
	public static WebElement linkOpen;
	
	@FindBy(xpath =  "//table/tbody/tr[2]/td[2]//span")
	public static WebElement linkAccount;
	
	@FindBy(xpath =  "//div[@class='absolute hidden pr-4 pt-4 right-0 sm:block top-0 z-10']/button")
	public static WebElement btnClose;
	
	@FindBy(xpath =  "//table/tbody/tr[1]/td[15]/a")
	public static WebElement linkDomain;

	@FindBy(xpath =  "//table/tbody/tr[1]/td[17]/a")
	public static WebElement linkSuccess;
	
	@FindBy(xpath =  "//div[contains(text(),'Question')]")
	public static WebElement popupQstn;
}
