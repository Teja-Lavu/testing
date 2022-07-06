package com.mrp.pageObjects.actions;

import org.openqa.selenium.support.PageFactory;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.AccountLocators;
import com.mrp.pageObjects.locators.CreateOrderLocators;
import com.mrp.utils.GenericMethods;

public class AccountActions {

	AccountLocators accntlct;
	
	public AccountActions() {
		 this.accntlct = new AccountLocators();
				PageFactory.initElements(DriverManager.getDriver(),this.accntlct);
	}
	
	public void clickAccounts() {
		GenericMethods.clickByWebElement(accntlct.Accounts);
	}
	
	public void fillSearch(String search) throws InterruptedException {
		GenericMethods.FillByWebElement_sendkeys(accntlct.Search, search);
	}
	
	public void selectSortBy(String sortBy) throws InterruptedException {
		System.out.println(accntlct.sortBy.getText());
		GenericMethods.selecte_dropdown(accntlct.sortBy,sortBy,accntlct.list);
	}	

	public void selectTimeperiod(String timePeriod) throws InterruptedException {
		System.out.println(accntlct.timePeriod.getText());
		GenericMethods.clickByWebElement(accntlct.svg);
		GenericMethods.selecte_dropdown(accntlct.timePeriod, timePeriod,accntlct.list);
	}	
	
	public void clickViewFilter() {
		GenericMethods.clickByWebElement(accntlct.viewFilter);
	}
	
	public void clickHideFilter() {
		GenericMethods.clickByWebElement(accntlct.hideFilter);
	}
	
	public void selectField() throws InterruptedException {		
		GenericMethods.clickByWebElement(accntlct.field);
	}	
	
	public void selectCondition() throws InterruptedException {
		GenericMethods.clickByWebElement(accntlct.condition);
	}
	
	public void clickAddFilter() {
		GenericMethods.clickByWebElement(accntlct.addFilter);
	}
	
	public void clickDeleteFilter() {
		GenericMethods.clickByWebElement(accntlct.deleteFilter);
	}
	
	public void clickClearAll() {
		GenericMethods.clickByWebElement(accntlct.clearAll);
	}
	
	public void clickApplyFilter() {
		GenericMethods.clickByWebElement(accntlct.applyFilter);
	}
}
