package com.mrp.pageObjects.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.CompanySwitcherLocators;
import com.mrp.pageObjects.locators.CreateCompanyLocators;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;

public class CreateCompanyActions {
	CreateCompanyLocators companyLocators = new CreateCompanyLocators();
	CompanySwitcherLocators csl = new CompanySwitcherLocators();
	LoginPageActions lpa = new LoginPageActions();

	public CreateCompanyActions() {
		this.companyLocators = new CreateCompanyLocators();
		PageFactory.initElements(DriverManager.getDriver(), this.companyLocators);
		PageFactory.initElements(DriverManager.getDriver(), this.csl);
	}

	public void clickAdminMenu() {
		WaitUtils.waitForElementVisiblity(companyLocators.Admin, 10);
		GenericMethods.clickByWebElement(companyLocators.Admin);
	}

	public void clickCompanies() {
		WaitUtils.waitForElementVisiblity(companyLocators.Companies, 10);
		GenericMethods.clickByWebElement(companyLocators.Companies);
	}

	public void NewCompanyTitle() {
		GenericMethods.getText(companyLocators.NewCompanyTitle);
	}

	public void createNewButton() {
		GenericMethods.clickByWebElement(companyLocators.CreateNew);
	}

	public void fillcompanyName(String companyName) throws InterruptedException {
		GenericMethods.FillByWebElement(companyLocators.companyName, companyName);
	}

	public void FiscalYear(String year) throws InterruptedException {
		GenericMethods.FillByWebElement(companyLocators.FiscalYearStart, year);
	}

	public void clientAccountId() {
		GenericMethods.clickByWebElement(companyLocators.ClientAccountId);
	}

	public void selectClientAccountId() throws InterruptedException {
		GenericMethods.clickByWebElement(companyLocators.selectAccountId);
	}

	public void createButton() {
		GenericMethods.clickByWebElement(companyLocators.saveButton);
	}

	public void switchCompany() {
	GenericMethods.clickByWebElement(csl.btnUserLogo);
	WaitUtils.waitForElementVisiblity(csl.lblCompany, 15);
	csl.lblCompany.isDisplayed();
	WaitUtils.waitForElementVisiblity(csl.drpCompany, 15);
	GenericMethods.clickByWebElement(csl.drpCompany);
	WaitUtils.waitForElementVisiblity(csl.company, 15);
	GenericMethods.clickByWebElement(csl.company);
	WaitUtils.waitForElementVisiblity(csl.btnYes, 15);
	GenericMethods.clickByWebElement(csl.btnYes);
	}

	public void CreateNewCompany(String companyName, String year, String accountId) throws InterruptedException {
		clickAdminMenu();
		clickCompanies();
		NewCompanyTitle();
		fillcompanyName(companyName);
		FiscalYear(year);
		createButton();
	}
}
