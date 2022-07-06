package com.mrp.pageObjects.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCompanyLocators {

	@FindBy(xpath = "//span[contains(text(),'Admin Studio')]/../../../a[3]")
	public static WebElement Admin;

	@FindBy(xpath = "//span[contains(text(),'Companies')]")
	public static WebElement Companies;
		
	@FindBy(xpath = "//button[contains(text(),'Create a Company')]")
	public static WebElement CreateNew;

	@FindBy(xpath = "//h1[contains(text(),'Create a Company')]")
	public static WebElement NewCompanyTitle;
	
	@FindBy(xpath = "//input[@placeholder = 'Enter a company name']")
	public static WebElement companyName;
		
	@FindBy(xpath = "//input[@placeholder = 'MM/DD']")
	public static WebElement FiscalYearStart;
	
	@FindBy(xpath = "//div[contains(text(),'Enter client account ID')]")
	public static WebElement ClientAccountId;
	
	@FindBy(xpath = "//div[contains(text(),'3 Tree Tech')]")
	public static WebElement selectAccountId;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public static WebElement saveButton;
	
	@FindBy(xpath = "//div//label[@title=\"Company Name\"]//..//..//div[@role='alert']")
	public static WebElement Name_validation_error_message;
	
	@FindBy(xpath = "//div//label[@title=\"Fiscal Year Start\"]//..//..//div[@role='alert']")
	public static WebElement Fiscaldate_validation_error_message;
		
	@FindBy(xpath = "//input[@id='search']")
	public static WebElement SearchBar;
	
	@FindBy(xpath = "//table/tbody/tr/td[1]/a")
	public static WebElement SearchResult;
	
	
}
