package com.mrp.pageObjects.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerHomePageLocators {
	
	@FindBy(xpath="//a[@href='/data/list' or @href='/mvp/data/list' ]")
    public static WebElement dataStudio;	
	
	@FindBy(xpath="//button[text()='Create a List' or text()='Create a list']")
	public static WebElement createlist;

}
