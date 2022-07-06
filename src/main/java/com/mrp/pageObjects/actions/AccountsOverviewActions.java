package com.mrp.pageObjects.actions;

import org.openqa.selenium.support.PageFactory;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.AccountsOverviewLocators;
import com.mrp.pageObjects.locators.DataStudioDiscoverLocators;
import com.mrp.utils.GenericMethods;

public class AccountsOverviewActions {

	AccountsOverviewLocators aol = new AccountsOverviewLocators();
	
	public AccountsOverviewActions() {
		 this.aol = new AccountsOverviewLocators();
				PageFactory.initElements(DriverManager.getDriver(),this.aol);
	}
	
	public void clicksearch() {
		GenericMethods.waitForElementVisiblity(aol.Search, 5);
		GenericMethods.clickByWebElement(aol.Search);
	}
	
	public void searchAccount() throws InterruptedException {
		if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
		GenericMethods.FillByWebElement_sendkeys(aol.Search,"Fitbit");
		}
		else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {
			GenericMethods.FillByWebElement_sendkeys(aol.Search,"Craig Hospital");	
		}
		
	}
	
	public void selectAccount() {
		GenericMethods.waitForElementVisiblity(aol.selectAccount, 30);
		GenericMethods.clickByWebElement(aol.selectAccount);		
	}
	

}
