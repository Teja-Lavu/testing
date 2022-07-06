package com.mrp.pageObjects.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanySwitcherLocators {
	
	@FindBy(xpath = "//*[@id='__next']/div/div[1]/div/aside/div[1]/button/div/div")
	public static WebElement btnUserLogo;
	
	@FindBy(xpath ="//span[contains(text(),'Switch Company')]/../div/div")
	public static WebElement lblCompany;
	
	@FindBy(xpath ="//div[text()='Vandelar' or text()='MRP']")
	public static WebElement txtCompanyMRP;
	
	@FindBy(xpath ="//span[contains(text(),'Switch Company')]/../div/div/div[2]")
	public static WebElement drpCompany;
	
	@FindBy(xpath ="//*[@id=\"__next\"]/div/div[1]/div/nav/div[2]/ul/div/label/div/div[2]/div/div")
	public static List<WebElement> ListCompany;	

	@FindBy(xpath ="//div[text()='QA Test Company1' or text()='QA Company' ]")
	public static WebElement company;

	@FindBy(xpath ="//h3[contains(text(),'Are you sure you want to act on behalf of ')]/../../div[2]")
	public static WebElement popupcompany;
	
	@FindBy(xpath ="//h3[contains(text(),'Are you sure you want to act on behalf of ')]/../../div[2]/h3")
	public static WebElement msgpopupcompany;

	@FindBy(xpath ="//button[contains(text(),'Yes')]")
	public static WebElement btnYes;

	@FindBy(xpath ="//div[text()='QA Test Company1' or text()='QA Company' ]")
	public static WebElement txtCompanyQTC;
	
	@FindBy(xpath ="//div[contains(text(),'123')]")
	public static WebElement company123;
	
	@FindBy(xpath ="//button[contains(text(),'No')]")
	public static WebElement btnNo;
}
