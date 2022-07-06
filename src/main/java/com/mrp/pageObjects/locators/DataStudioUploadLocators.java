package com.mrp.pageObjects.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DataStudioUploadLocators {
	
	@FindBy(xpath =  "//a[@href='/mvp/data/list']")	
    public static WebElement dataStudio;

	@FindBy(xpath = "//span[text()='Lists']")
	public static WebElement lists;

	@FindBy(xpath = "//h2[contains(text(),'Account List')]")
	public static WebElement accountList;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public static WebElement Continue;

	@FindBy(xpath = "//h2[contains(text(),'Upload a File')]")
	public static WebElement fileUpload;

	@FindBy(xpath = "//h2[contains(text(),'Discover Prelytix Data')]")
	public static WebElement discoverPrelytix;

	@FindBy(xpath = "//button[contains(text(),'Upload File')]")
	public static WebElement btnFileUpload;

	@FindBy(xpath = "//div//input[@type=\"file\"]")
	public static WebElement file;

	@FindBy(xpath = "//input[@placeholder='Enter a name']")
	public static WebElement fileName;

	@FindBy(xpath = "//button[contains(text(),'Finish')]")
	public static WebElement btnFinish;

	@FindBy(xpath = "//button[contains(text(),'Go Back')]")
	public static WebElement btnGoBack;

	@FindBy(xpath = "//div[contains(text(),'All Lists')]")
	public static WebElement allLists;

	@FindBy(xpath = "//html/body/div/div/div[1]/div[2]/div/h1")
	public static WebElement txtFileCreated;

	@FindBy(xpath = "//input[@id='search']")
	public static WebElement txtSearch;

	@FindBy(xpath = "//span[contains(text(),'This list name is already in use.')]")
	public static WebElement msgListName;
	
	@FindBy(xpath = "//tbody/tr[1]/td[4]")
	public static WebElement nmbrAccounts;

	@FindBy(xpath = "//tbody/tr[1]/td[5]")
	public static WebElement nmbrLocations;

	@FindBy(xpath = "//h1[text()='Accounts']")
	public static WebElement txtAccounts;

	@FindBy(xpath = "//table")
	public static WebElement tblAccounts;
	
	@FindBy(xpath = "//button[text()='Last']")
	public static WebElement lastPage;

	@FindBy(xpath = "//tbody/tr")
	public static List<WebElement> tblCompanies;
	
	@FindBy(id="dropdown-input")
	public static WebElement txtCompany;
	
	@FindBy(xpath = "//div[@tabindex='-1']")
	public static WebElement selectCompamy;


}
