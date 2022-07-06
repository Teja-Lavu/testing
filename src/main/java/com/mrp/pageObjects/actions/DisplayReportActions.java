package com.mrp.pageObjects.actions;

import org.openqa.selenium.support.PageFactory;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.DisplayReportLocators;
import com.mrp.utils.GenericMethods;

public class DisplayReportActions {

	DisplayReportLocators drlocators;
	
	public DisplayReportActions() {
		this.drlocators = new DisplayReportLocators();
		PageFactory.initElements(DriverManager.getDriver(),this.drlocators);

	}
	
	public void clickDisplayReport() {
		GenericMethods.waitForElementVisiblity(drlocators.selectDisplayReport, 5);
		GenericMethods.clickByWebElement(drlocators.selectDisplayReport);
	}
	
	
	
}
