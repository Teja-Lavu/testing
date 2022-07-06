package com.mrp.pageObjects.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalesDevelopmentLocators {

	@FindBy(xpath =  "//span[text()='Sales Development']")
    public static WebElement selectSalesDevelopment;
	
	@FindBy(xpath =  "//h1[text()='Sales Development']")
    public static WebElement textSalesDevelopment;

	@FindBy(xpath =  "//tr[1]//div[text()='Open']")
    public static WebElement linkOpen;
	
	@FindBy(xpath =  "//p[@class='whitespace-pre-line']")
    public static WebElement popUp;
	
	@FindBy(xpath =  "//table/tbody/tr[1]/td[14]/a")
	public static WebElement linkDomain;

	@FindBy(xpath ="//div[text()='Vandelar']")
	public static WebElement company;
	
	@FindBy(xpath ="//div[1]/nav/a[1]/span")
	public static WebElement InsightStudio;



}
