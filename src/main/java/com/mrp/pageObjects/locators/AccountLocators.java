package com.mrp.pageObjects.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLocators {
	
	@FindBy(xpath =  "//span[contains(text(),'Accounts')]")
    public static WebElement Accounts;
	
	@FindBy(xpath =  "//input[@name='search']")
    public static WebElement Search;
	
	@FindBy(xpath =  "//span[contains(text(),'Sort By: ')]")
    public static WebElement sortBy;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div/div[1]/div/section[1]/div/div[2]/label/div/button/svg")
	public static WebElement svg;
	
	@FindBy(xpath =  "//*[@id=\"__next\"]/div/div[1]/div/section/div/div[3]/label/div/button/span")
    public static WebElement timePeriod;	
	
	@FindBy(xpath="//button[contains(text(),'View Filters')]")
	public static WebElement viewFilter;
	
	@FindBy(xpath="//button[contains(text(),'Hide Filters')]")
	public static WebElement hideFilter;
	
	@FindBy(xpath="//label/span[contains(text(),'Field')]")
	public static WebElement field;
	
	@FindBy(xpath="//section[2]/div/div/div/div[2]/label/div/button")
	public static WebElement condition;
	
	@FindBy(xpath="//section[2]/div/div/div/div[3]/label/input")
	public static WebElement value;
	
	@FindBy(xpath="//section[2]/div/div/div/div[4]/button[1]")
	public static WebElement addFilter;
	
	@FindBy(xpath="//section[2]/div/div/div/div[4]/button[2]")
	public static WebElement deleteFilter;
	
	@FindBy(xpath="//button[contains(text(),'Clear All')]")
	public static WebElement clearAll;
	
	@FindBy(xpath="//button[contains(text(),'Apply Filters')]")
	public static WebElement applyFilter;
	
	@FindBy(xpath="//button[contains(text(),'Last')]")
	public static WebElement lastPage;	
	
	@FindBy(xpath="//table//tbody/tr")
	public static WebElement lastPageList;
	
	@FindBy(xpath="//span[@class='text-grey-500']")
	public static WebElement lastpageno;
	
	@FindBy(xpath="//table//tbody/tr")
	public static WebElement listResult;
	
	@FindBy(xpath="//div[text()='Select...']")
	public static WebElement iptValue;
	
	@FindBy(xpath="//div[text()='- Select A Filter -']")
	public static WebElement iptFilterName;
	
	@FindBy(xpath="//button[text()='Save Filters']")
	public static WebElement btnSaveFilter;
	
	@FindBy(xpath="//button[text()='Save and Apply Filters']")
	public static WebElement btnSaveAndApplyFilter;

	@FindBy(xpath="//div[@class=' css-6o5gw2']")
	public static WebElement selectSavedFilter;

	@FindBy(xpath="//div[@class=' css-9f2hmr']")
	public static List<WebElement>	listSavedFilters;	
	
	@FindBy(xpath="//input[@placeholder='Enter a name']")
	public static WebElement iptEnterFilter;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[4]")
	public static WebElement btnArrow;
		
	@FindBy(xpath="//span[text()='Location']")
	public static WebElement textLocation;

	@FindBy(xpath="//span[text()='Score + Topics']")
	public static WebElement textScoteTopic;
	
	@FindBy(xpath="//span[text()='Address']")
	public static WebElement textAddress;
	
	@FindBy(xpath="//table/tbody/tr[2]//table/tbody/tr[1]/td[1]/a")
	public static WebElement linkLocation;

	@FindBy(xpath="//div[text()='Intelligence']")
	public static WebElement tabIntelligence;

	@FindBy(xpath="//button[text()='Export']")
	public static WebElement btnExport;

	@FindBy(xpath="//h2[text()='Are you sure you want to export these accounts?']")
	public static WebElement textexport;

	@FindBy(xpath="//div[@class='flex flex-row mt-4 text-center w-full gap-x-4 justify-end']//button[2]")
	public static WebElement btnPopupExport;

	@FindBy(xpath="//h2[text()='Your file is being generated!']")
	public static WebElement textExportgenerated;
	
	@FindBy(xpath="//button[text()='Close Window']")
	public static WebElement btnClose;
	
	@FindBy(xpath="//div[@class=\"rc-virtual-list\"]//div/div/div/div/div")
	public static List<WebElement> list;


}

