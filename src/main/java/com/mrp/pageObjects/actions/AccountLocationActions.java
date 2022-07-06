package com.mrp.pageObjects.actions;

import org.openqa.selenium.support.PageFactory;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.AccountLocationLocators;
import com.mrp.pageObjects.locators.AccountLocators;
import com.mrp.utils.GenericMethods;

public class AccountLocationActions {

AccountLocationLocators accntalct;
AccountLocators accntlct;	
	public AccountLocationActions() {
		 this.accntalct = new AccountLocationLocators();
		 this.accntlct = new AccountLocators();
				PageFactory.initElements(DriverManager.getDriver(),this.accntalct);
				PageFactory.initElements(DriverManager.getDriver(),this.accntlct);
	}	
	
	public void clickAccounts() {
		GenericMethods.clickByWebElement(accntlct.Accounts);
	}
	
	public void clickAccountNacro() {
		GenericMethods.clickByWebElement(accntalct.selectAccount);
	}
	
	public void clickLocation() {
		GenericMethods.clickByWebElement(accntalct.tabLocations);
	}
	
	
	
}
