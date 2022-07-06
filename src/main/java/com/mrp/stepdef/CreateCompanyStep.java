package com.mrp.stepdef;

import java.io.IOException;
import java.lang.String;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.CompanySwitcherActions;
import com.mrp.pageObjects.actions.CreateCompanyActions;
import com.mrp.pageObjects.locators.CompanySwitcherLocators;
import com.mrp.pageObjects.locators.CreateCompanyLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.GetConfigProperties;
import com.mrp.utils.WaitUtils;
import io.cucumber.java.en.*;

public class CreateCompanyStep extends ReportManager {

	CreateCompanyActions cca = new CreateCompanyActions();
	CreateCompanyLocators ccl = new CreateCompanyLocators();
	CompanySwitcherLocators csl = new CompanySwitcherLocators();
	public static String dynamic_companyname;
	ExtentTest logtoreport = null;
	
	public CreateCompanyStep() {		
		PageFactory.initElements(DriverManager.getDriver(), this.csl);
	}

	@And("user will click Admin icon")
	public void user_will_click_admin_icon() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "User will click Admin");
			cca.clickAdminMenu();
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("user will click Companies")
	public void user_will_click_companies() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "User will click Companies");
			cca.clickCompanies();
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("user will click create new button")
	public void user_will_click_create_new_button() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "User will Click Create New Button");
			WaitUtils.waitForElementVisiblity(ccl.CreateNew, 10);
			cca.createNewButton();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}

	@Then("user should see New Company page")
	public void user_should_see_new_company_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"), "User should see New Company page");
			WaitUtils.waitForElementVisiblity(ccl.NewCompanyTitle, 10);
			Assert.assertEquals(ccl.NewCompanyTitle.getText(), "Create a Company",
					"Company creation page is not displayed");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("user will enter CompanyName with {string}")
	public void user_will_enter_company_name_with(String Name) throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "User will Enter CompanyName with {string}");
			
			if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
			dynamic_companyname = Name + "_" + System.currentTimeMillis();
			GenericMethods.waitForElementVisiblity(CreateCompanyLocators.companyName, 10);
			GenericMethods.FillByWebElement_sendkeys(CreateCompanyLocators.companyName, dynamic_companyname);
			}
		
		else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {
			cca.switchCompany();
			dynamic_companyname = Name + "_" + System.currentTimeMillis();
			GenericMethods.waitForElementVisiblity(CreateCompanyLocators.companyName, 10);
			GenericMethods.FillByWebElement_sendkeys(CreateCompanyLocators.companyName, dynamic_companyname);
		}
		} catch (StaleElementReferenceException ex) {
			if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
				dynamic_companyname = Name + "_" + System.currentTimeMillis();
				GenericMethods.waitForElementVisiblity(CreateCompanyLocators.companyName, 10);
				GenericMethods.FillByWebElement_sendkeys(CreateCompanyLocators.companyName, dynamic_companyname);
				}
			
			else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {
				cca.switchCompany();
				dynamic_companyname = Name + "_" + System.currentTimeMillis();
				GenericMethods.waitForElementVisiblity(CreateCompanyLocators.companyName, 10);
				GenericMethods.FillByWebElement_sendkeys(CreateCompanyLocators.companyName, dynamic_companyname);
			}		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("user will select FiscalYearStart with {string}")
	public void user_will_select_fiscal_year_start_with(String year) throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"User will select FiscalYearStart with {string}");
			GenericMethods.FillByWebElement_sendkeys(ccl.FiscalYearStart, year);
			
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("clear the entered values")
	public void clear_the_entered_values() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "Clear the entered values");
			GenericMethods.clearInput(CreateCompanyLocators.companyName);
			GenericMethods.clearInput(CreateCompanyLocators.FiscalYearStart);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify if the save button is disabled")
	public void verify_if_the_save_button_is_disabled() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "Clear the entered values");
			if(!GenericMethods.isClickable(CreateCompanyLocators.saveButton)) {
				
			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("user will select Client Account ID")
	public void user_will_select_client_account_id() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "User will click Companies");
			cca.clientAccountId();
			cca.selectClientAccountId();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("user will click create button")
	public void user_will_click_create_button() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "User will click Create Button");
			WaitUtils.waitForElementVisiblity(ccl.saveButton, 5);
			Thread.sleep(3000);
			cca.createButton();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the company list if it is created")
	public void verify_the_company_list_if_it_is_created() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"), "Verify the company list if it is created");
			WaitUtils.waitForElementVisiblity(ccl.SearchBar, 5);
			GenericMethods.FillByWebElement_sendkeys(ccl.SearchBar, dynamic_companyname);
			Thread.sleep(5000);
			/*
			 * GenericMethods.FillByWebElement_sendkeys(ccl.SearchBar, "0"); String temp =
			 * ccl.SearchBar.getText(); WaitUtils.waitForTextVisible(ccl.SearchBar, 2,
			 * temp); ccl.SearchBar.sendKeys(Keys.BACK_SPACE);
			 */
			WaitUtils.waitForTextVisible(ccl.SearchResult, 10, dynamic_companyname);
			String actual = CreateCompanyLocators.SearchResult.getText();
			System.out.println("Dynamic comapany name retireved : " + actual);
			Assert.assertEquals(actual, dynamic_companyname);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}

}
