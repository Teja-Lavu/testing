package com.mrp.pageObjects.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateOrderLocators {

	@FindBy(xpath =  "//li//span[text()='Admin']")
    public static WebElement admin;	
	
	@FindBy(xpath = "//section//li[contains(text(),'Budgeting')]")
	public static WebElement budgeting;
	
	@FindBy(xpath = "//*[@title='New Purchase Order']")
	public static WebElement NewPurchareOrderTitle;
	
	@FindBy(xpath = "//button/span[contains(text(),'Create new')]")
	public static WebElement createNew;
	
	@FindBy(xpath = "//*[@id='name']")
	public static WebElement name;
	
	@FindBy(xpath = "//*[@id='cost']")
	public static WebElement cost;
	
	@FindBy(xpath = "//*[@name='external_source_id']")
	public static WebElement externalSourceID;
	
	@FindBy(xpath = "//*[@placeholder='Start date']")
	public static WebElement dateRangeStart;
	
	@FindBy(xpath="//*[@placeholder='End date']")
	public static WebElement dateRangeEnd;
	
	@FindBy(xpath="//*[@id=\"__next\"]/section/section/main/div/div[2]/div/div[1]/div/div[1]/form/div[1]/div/div[4]/div[1]/div/div[2]/div/div/div/span")
	public static WebElement calender;
	
	@FindBy(xpath="//*[@value='0%']")
	public static WebElement margin;
	
	@FindBy(xpath="//form/div[1]/div/div[1]/div[1]/div/div[2]/div[2]/div")
	public static WebElement Name_validation_error_message;
	
	@FindBy(xpath="//form/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/div")
	public static WebElement cost_validation_error_message;
	
	@FindBy(xpath = "//button/span[contains(text(),'Save')]")
	public static WebElement save;
	
	@FindBy(xpath = "//input[@placeholder='Search purchase orders']")
	public static WebElement searchbar;
	
	@FindBy(xpath= "//button[@class='ant-btn ant-btn-icon-only ant-input-search-button']")
	public static WebElement searchIcon;
	
	@FindBy(xpath = "//table/tbody/tr/td[1]/a")
	public static WebElement searchResult;
	
}
