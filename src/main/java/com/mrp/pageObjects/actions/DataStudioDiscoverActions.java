package com.mrp.pageObjects.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.DataStudioDiscoverLocators;
import com.mrp.utils.GenericMethods;

public class DataStudioDiscoverActions {
	private WebDriver driver;
	DataStudioDiscoverLocators dsdLocators;

	public DataStudioDiscoverActions() {
		 this.dsdLocators = new DataStudioDiscoverLocators();
				PageFactory.initElements(DriverManager.getDriver(),this.dsdLocators);
	}
	
	public void clickDiscover() {
		GenericMethods.clickByWebElement(dsdLocators.discoverPrelytix);
	}
	
	public void clickContinue() {
		GenericMethods.clickByWebElement(dsdLocators.Continue);
	}
	
	public void fillGeography(String Geography) throws InterruptedException {
		GenericMethods.FillByWebElement(dsdLocators.txtGeography,Geography);
	}
	
	public void selectLimit(){
		GenericMethods.clickByWebElement(dsdLocators.selectLimit);
	}
	
	public void selectIndustry(){
		GenericMethods.clickByWebElement(dsdLocators.txtIndustry);
	}
	
	public void selectMinRevenue(){
		GenericMethods.clickByWebElement(dsdLocators.txtRevenueMin);
	}
	
	public void selectMaxRevenue(){
		GenericMethods.clickByWebElement(dsdLocators.txtRevenueMax);
	}
	
	public void selectminEmployee(){
		GenericMethods.clickByWebElement(dsdLocators.txtEmployeeMin);
	}
	
	public void selectmaxEmployee() {
		GenericMethods.clickByWebElement(dsdLocators.txtEmployeeMax);
	}
	
	public void fillListName(String listName) throws InterruptedException {
		GenericMethods.FillByWebElement(dsdLocators.listName,listName);
	}
	
	public void clickFinish() {
		GenericMethods.clickByWebElement(dsdLocators.btnFinish);
	}
	
	
}
