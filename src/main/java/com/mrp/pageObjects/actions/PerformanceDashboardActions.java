package com.mrp.pageObjects.actions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.CreateOrderLocators;
import com.mrp.pageObjects.locators.DataStudioDiscoverLocators;
import com.mrp.pageObjects.locators.PerformanceDashboardLocators;
import com.mrp.utils.GenericMethods;

public class PerformanceDashboardActions {

	PerformanceDashboardLocators pdLocators;
	SoftAssert softassert = new SoftAssert();
	
	public PerformanceDashboardActions() {
		 this.pdLocators = new PerformanceDashboardLocators();
				PageFactory.initElements(DriverManager.getDriver(),this.pdLocators);
	}
	
	public void clickPerformanceDash() {
		GenericMethods.waitForElementVisiblity(pdLocators.selectParformanceDashboard, 5);
		GenericMethods.clickByWebElement(pdLocators.selectParformanceDashboard);
	}
	
	public void clickAccountLink() {
		GenericMethods.clickByWebElement(pdLocators.linkAccount);
	}
	
	public void selectTimeFrame() {
		GenericMethods.clickByWebElement(pdLocators.drpTimeFrame);
		GenericMethods.clickByWebElement(pdLocators.drpItem365Days);
	}
	
	public void assertContentSyndication() {
		String noContentSyndication = GenericMethods.getText(pdLocators.noContentSyndicationLeads);
		GenericMethods.clickByWebElement(pdLocators.ContentSyndication);
		selectTimeFrame();
		List<WebElement> tblContentSyndication = pdLocators.tblContentSyndication;
		int NoResults = tblContentSyndication.size();
		String Result = Integer.toString(NoResults);
		
		softassert.assertEquals(noContentSyndication, Result);

	}
	
	public void assertSalesDevelopment() {
		GenericMethods.clickByWebElement(pdLocators.selectParformanceDashboard);
		String noSalesDevelopment = GenericMethods.getText(pdLocators.noSalesDevelopmentLeads);
		GenericMethods.clickByWebElement(pdLocators.SalesDevelopment);
		selectTimeFrame();
		List<WebElement> tblSalesDevelopment = pdLocators.tblSalesDevelopment;
		int NoResults = tblSalesDevelopment.size();
		String Result = Integer.toString(NoResults);
		
		softassert.assertEquals(noSalesDevelopment, Result);
	}
}
