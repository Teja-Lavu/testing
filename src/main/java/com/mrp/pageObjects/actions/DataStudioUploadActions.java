package com.mrp.pageObjects.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.DataStudioUploadLocators;
import com.mrp.utils.GenericMethods;

public class DataStudioUploadActions {

	DataStudioUploadLocators dsuLocators;
	private WebDriver driver;

	public DataStudioUploadActions() {
		this.dsuLocators = new DataStudioUploadLocators();
		PageFactory.initElements(DriverManager.getDriver(), this.dsuLocators);
	}

	public void clickAccountList() {
		GenericMethods.waitForElementVisiblity(dsuLocators.accountList, 10);
		GenericMethods.clickByWebElement(dsuLocators.accountList);
	}

	public void clickContinue() {
		GenericMethods.clickByWebElement(dsuLocators.Continue);
	}

	public void clickUploadfile() {
		GenericMethods.clickByWebElement(dsuLocators.fileUpload);
	}

	public void clickbtnUpload() {
		GenericMethods.clickByWebElement(dsuLocators.btnFileUpload);
	}

	public void fillListName(String listName) throws InterruptedException {
		
		GenericMethods.FillByWebElement(dsuLocators.fileName, listName);
		//GenericMethods.clickByWebElement(dsuLocators.fileName);
	}

	public void clickbtnFinish() {
		GenericMethods.isClickable(dsuLocators.btnFinish);
		GenericMethods.clickByWebElement(dsuLocators.btnFinish);
	}

	public void clickbtnGoBack() {
		GenericMethods.clickByWebElement(dsuLocators.btnGoBack);
	}

	public void clickAllLists() {
		GenericMethods.waitForElementVisiblity(dsuLocators.allLists, 10);
		GenericMethods.clickByWebElement(dsuLocators.allLists);
	}

	public void clickDiscover() {
		GenericMethods.clickByWebElement(dsuLocators.discoverPrelytix);
	}
}
