package com.mrp.pageObjects.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.CreateCompanyLocators;
import com.mrp.pageObjects.locators.CreateOrderLocators;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;

public class CreateOrderActions {

	CreateOrderLocators orderLocators = new CreateOrderLocators();
	
	public CreateOrderActions() {
		PageFactory.initElements(DriverManager.getDriver(),this.orderLocators );
	}
	
	public void clickAdminMenu() {
		GenericMethods.clickByWebElement(orderLocators.admin);
		 
	}
	
	public void clickBudgeting() {
		GenericMethods.clickByWebElement(orderLocators.budgeting);
	}
	
	public void clickCreateNew() {
		GenericMethods.clickByWebElement(orderLocators.createNew);
	}
	
	public void newPurchaseOrderTitle() {
		GenericMethods.getText(orderLocators.NewPurchareOrderTitle);
	}
	
	public void fillName(String name) throws InterruptedException {
		GenericMethods.FillByWebElement_sendkeys(orderLocators.name, name);
	}
	
	public void fillCost(String cost) throws InterruptedException {
		GenericMethods.FillByWebElement_sendkeys(orderLocators.cost,cost);
	}
	
	public void fillExternalSourceId(String externalSourceID ) throws InterruptedException {
		GenericMethods.FillByWebElement_sendkeys(orderLocators.externalSourceID,externalSourceID);
	}
	
	public void fillDateRangeStart(String dateRangeStart) throws InterruptedException {
		GenericMethods.FillByWebElement_sendkeys(orderLocators.dateRangeStart,dateRangeStart);
	}
	
	public void fillDateRangeEnd(String dateRangeEnd) throws InterruptedException {
		WaitUtils.waitForElementVisiblity(orderLocators.dateRangeEnd,10);
		GenericMethods.FillByWebElement_sendkeys(orderLocators.dateRangeEnd,dateRangeEnd);		
	}
	
	public void fillMargin(String margin) throws InterruptedException {
		GenericMethods.clickByWebElement(orderLocators.margin);
		GenericMethods.FillByWebElement_sendkeys(orderLocators.margin,margin);
	}
	
	public void clickSearchIcon() {
		GenericMethods.clickByWebElement(orderLocators.searchIcon);
	}
	
	public void clickSave() {
		GenericMethods.clickByWebElement(orderLocators.save);
	}
}
