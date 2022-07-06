package com.mrp.stepdef;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.ContentSyndicationActions;
import com.mrp.pageObjects.locators.AccountsOverviewLocators;
import com.mrp.pageObjects.locators.CompanySwitcherLocators;
import com.mrp.pageObjects.locators.ContentSyndicationLocators;
import com.mrp.pageObjects.locators.PerformanceDashboardLocators;
import com.mrp.pageObjects.locators.SalesDevelopmentLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesDevelopmentStep extends ReportManager {
	SalesDevelopmentLocators sdLocators;
	ContentSyndicationLocators csLocators;
	PerformanceDashboardLocators pdLocators;
	CompanySwitcherLocators csl = new CompanySwitcherLocators();
	Assertion assertion = new Assertion();
	ExtentTest logtoreport = null;

	public SalesDevelopmentStep() {
		this.csLocators = new ContentSyndicationLocators();
		this.pdLocators = new PerformanceDashboardLocators();
		this.sdLocators = new SalesDevelopmentLocators();

		PageFactory.initElements(DriverManager.getDriver(), this.csLocators);
		PageFactory.initElements(DriverManager.getDriver(), this.pdLocators);
		PageFactory.initElements(DriverManager.getDriver(), this.csl);
		PageFactory.initElements(DriverManager.getDriver(), this.sdLocators);

	}
	public void switchCompany() {
		GenericMethods.clickByWebElement(csl.btnUserLogo);
		WaitUtils.waitForElementVisiblity(csl.lblCompany, 15);
		csl.lblCompany.isDisplayed();
		WaitUtils.waitForElementVisiblity(csl.drpCompany, 15);
		GenericMethods.clickByWebElement(csl.drpCompany);
		WaitUtils.waitForElementVisiblity(sdLocators.company, 15);
		GenericMethods.clickByWebElement(sdLocators.company);
		WaitUtils.waitForElementVisiblity(csl.btnYes, 15);
		GenericMethods.clickByWebElement(csl.btnYes);
		GenericMethods.clickByWebElement(csl.btnUserLogo);
		}

	@Then("user navigates to Sales Development page")
	public void user_navigates_to_sales_development_page() throws InterruptedException, IOException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user navigates to Sales Development page");
			if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
				GenericMethods.waitForElementVisiblity(sdLocators.selectSalesDevelopment, 30);
				GenericMethods.clickByWebElement(sdLocators.selectSalesDevelopment);
			}
			else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {
			switchCompany();			
			GenericMethods.waitForElementVisiblity(sdLocators.selectSalesDevelopment, 30);
			GenericMethods.clickByWebElement(sdLocators.selectSalesDevelopment);
			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the contents of Sales Development page")
	public void verify_the_contents_of_sales_development_page(io.cucumber.datatable.DataTable dataTable)
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the contents of Sales Development page");
			List<String> data = dataTable.values();

			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).equalsIgnoreCase("Sales Development"))
					GenericMethods.waitForElementVisiblity(sdLocators.textSalesDevelopment, 30);

				if (data.get(i).equalsIgnoreCase("Top Countries"))
					GenericMethods.waitForElementVisiblity(csLocators.textTopCountries, 30);

				if (data.get(i).equalsIgnoreCase("Employees"))
					GenericMethods.waitForElementVisiblity(csLocators.textEmployees, 30);

				if (data.get(i).equalsIgnoreCase("Export Leads"))
					GenericMethods.waitForElementVisiblity(csLocators.btnExportLeads, 30);

				if (data.get(i).equalsIgnoreCase("View Filters"))
					GenericMethods.waitForElementVisiblity(pdLocators.textViewFilters, 30);

				if (data.get(i).equalsIgnoreCase("TimeFrame dropdown"))
					GenericMethods.waitForElementVisiblity(pdLocators.textTimeFrame, 30);
			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user click on Open Survey questions in Sales Development")
	public void user_click_on_open_survey_questions_in_sales_development() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"user click on Open Survey questions in Sales Development");
			GenericMethods.waitForElementVisiblity(sdLocators.linkOpen, 30);
			GenericMethods.clickByWebElement(sdLocators.linkOpen);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify popup opens in Sales Development")
	public void verify_popup_opens_in_sales_development() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "verify popup opens in Sales Development");
			GenericMethods.waitForElementVisiblity(sdLocators.popUp, 30);
			GenericMethods.isElementDisplayed(sdLocators.popUp);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user click on Domain hyperlink in Sales Development")
	public void user_click_on_domain_hyperlin_in_sales_developmentk() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"user click on Domain hyperlink in Sales Development");
			GenericMethods.waitForElementVisiblity(sdLocators.linkDomain, 30);
			GenericMethods.clickByWebElement(sdLocators.linkDomain);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
}
