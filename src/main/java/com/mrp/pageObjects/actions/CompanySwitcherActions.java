package com.mrp.pageObjects.actions;

import org.openqa.selenium.support.PageFactory;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.CompanySwitcherLocators;
import com.mrp.utils.GenericMethods;

public class CompanySwitcherActions {
	
	CompanySwitcherLocators csl = new CompanySwitcherLocators();
	
	public CompanySwitcherActions() {
		this.csl = new CompanySwitcherLocators();
		PageFactory.initElements(DriverManager.getDriver(), this.csl);
	}
	
	public void selectCompany(){
		GenericMethods.clickByWebElement(csl.company);
	}
	
	public void clickYes(){
		GenericMethods.clickByWebElement(csl.btnYes);
	}

}
