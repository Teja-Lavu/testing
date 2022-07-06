package com.mrp.pageObjects.actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.Assertion;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.AccountLocationLocators;
import com.mrp.pageObjects.locators.DataStudioUploadLocators;
import com.mrp.pageObjects.locators.FilterLocators;
import com.mrp.utils.GenericMethods;

public class FilterActions {
	FilterLocators fltrLoc;
	AccountLocationLocators accntalct;
	CustomerHomePageActions chpActions;
	DataStudioUploadLocators dsuLocators;
	Assertion assertion = new Assertion();
	
	public FilterActions() {
		this.fltrLoc = new FilterLocators();
		this.accntalct = new AccountLocationLocators();
		this.chpActions = new CustomerHomePageActions();
		this.dsuLocators = new DataStudioUploadLocators();
		PageFactory.initElements(DriverManager.getDriver(), this.accntalct);
		PageFactory.initElements(DriverManager.getDriver(), this.fltrLoc);
		PageFactory.initElements(DriverManager.getDriver(), this.chpActions);
		PageFactory.initElements(DriverManager.getDriver(), this.dsuLocators);

	}
	
	public void navigateToLocations() {
		GenericMethods.waitForElementVisiblity(accntalct.tabLocations, 30);
		GenericMethods.clickByWebElement(accntalct.tabLocations);		
	}
	
public void verifyLocationNotPresent(String loc) throws InterruptedException {
	GenericMethods.waitForElementVisiblity(fltrLoc.drpLocation, 30);
	GenericMethods.clickByWebElement(fltrLoc.drpLocation);
	
	List<WebElement> values = DriverManager.getDriver().findElements(By.xpath("//main[@class='flex-col overflow-y-auto w-full py-4 px-6']/div/div[2]/div/div[2]/div[2]/div/div"));
		Thread.sleep(4000);
	for (int i = 1; i < values.size(); i++) {
             String location = values.get(i).getText();
	
		if(location.contains(loc)) {
			 assertion.assertNotEquals(location, loc);
		}
	}
}

public void verifyLocationPresent(String loc) throws InterruptedException {
	GenericMethods.waitForElementVisiblity(fltrLoc.drpLocation, 30);
	GenericMethods.clickByWebElement(fltrLoc.drpLocation);
	
	List<WebElement> values = DriverManager.getDriver().findElements(By.xpath("//main[@class='flex-col overflow-y-auto w-full py-4 px-6']/div/div[2]/div/div[2]/div[2]/div/div"));
	Thread.sleep(4000);
	
	for (int i = 1; i < values.size(); i++) {

	 String location = values.get(i).getText();
		if(location.contains(loc)) {
			assertion.assertTrue(true, location);
		}
		
	}
}

public void verifyList() throws InterruptedException {
	Thread.sleep(2000);
	int count = DriverManager.getDriver().findElements(By.xpath("//tbody/tr")).size();
	
	chpActions.clickdatasourceicon();
	GenericMethods.FillByWebElement_sendkeys(dsuLocators.txtSearch, "Top 3 Accounts");
	GenericMethods.clickByWebElement(fltrLoc.top3Accounts);

	Thread.sleep(4000);
	int count1 = DriverManager.getDriver().findElements(By.xpath("//tbody/tr")).size();
	
	assertion.assertEquals(count, count1);
}
	

}
