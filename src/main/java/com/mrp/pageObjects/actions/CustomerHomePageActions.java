package com.mrp.pageObjects.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.CreateOrderLocators;
import com.mrp.pageObjects.locators.CustomerHomePageLocators;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;

public class CustomerHomePageActions {
	
	
	CustomerHomePageLocators customerHomePageLocators = new CustomerHomePageLocators();
	
		public CustomerHomePageActions() {			
					PageFactory.initElements(DriverManager.getDriver(),this.customerHomePageLocators);
		}
		
		public void clickdatasourceicon() {
			WaitUtils.waitForElementVisiblity(customerHomePageLocators.dataStudio, 5);
			GenericMethods.clickByWebElement(customerHomePageLocators.dataStudio);
			 
		}
		
		public void click_create_newList_button() {
			GenericMethods.clickByWebElement(customerHomePageLocators.createlist);
			 
		}

}
