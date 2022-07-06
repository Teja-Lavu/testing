package com.mrp.stepdef;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.github.dockerjava.api.model.Driver;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.ContentSyndicationActions;
import com.mrp.pageObjects.locators.AccountsOverviewLocators;
import com.mrp.pageObjects.locators.ContentSyndicationLocators;
import com.mrp.pageObjects.locators.PerformanceDashboardLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContentSyndicationStep extends ReportManager {

	ContentSyndicationLocators csLocators;
	ContentSyndicationActions csActions;
	PerformanceDashboardLocators pdLocators;
	AccountsOverviewLocators aol;
	Assertion assertion = new Assertion();
	ExtentTest logtoreport = null;

	public ContentSyndicationStep() {
		this.csLocators = new ContentSyndicationLocators();
		this.csActions = new ContentSyndicationActions();
		this.pdLocators = new PerformanceDashboardLocators();
		this.aol = new AccountsOverviewLocators();
		PageFactory.initElements(DriverManager.getDriver(), this.csLocators);
		PageFactory.initElements(DriverManager.getDriver(), this.csActions);
		PageFactory.initElements(DriverManager.getDriver(), this.pdLocators);
		PageFactory.initElements(DriverManager.getDriver(), this.aol);

	}

	@Then("user navigates to Content Syndication page")
	public void user_navigates_to_content_syndication_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"user navigates to Content Syndication page");
			WaitUtils.waitForElementVisiblity(csLocators.selectContentSyndication, 15);
			csActions.clickContentSyndication();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the contents of Content Syndication page")
	public void verify_the_contents_of_content_syndication_page(io.cucumber.datatable.DataTable dataTable)
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the contents of Content Syndication page");
			List<String> data = dataTable.values();

			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).equalsIgnoreCase("Content Syndication"))
					GenericMethods.waitForElementVisiblity(csLocators.textContentSyndication, 30);
				assertion.assertEquals(csLocators.textContentSyndication.isDisplayed(), true,
						"Label Content Syndication is not displayed");

				if (data.get(i).equalsIgnoreCase("View Filters"))
					GenericMethods.waitForElementVisiblity(pdLocators.textViewFilters, 30);
				assertion.assertEquals(pdLocators.textViewFilters.isDisplayed(), true,
						"View Filters button is not displayed");

				if (data.get(i).equalsIgnoreCase("TimeFrame dropdown"))
					GenericMethods.waitForElementVisiblity(pdLocators.textTimeFrame, 30);
				assertion.assertEquals(pdLocators.textTimeFrame.isDisplayed(), true,
						"TimeFrame dropdown is not displayed");

				if (data.get(i).equalsIgnoreCase("Top Countries"))
					GenericMethods.waitForElementVisiblity(csLocators.textTopCountries, 30);
				assertion.assertEquals(csLocators.textTopCountries.isDisplayed(), true,
						"Label Top Countries is not displayed");

				if (data.get(i).equalsIgnoreCase("Employees"))
					GenericMethods.waitForElementVisiblity(csLocators.textEmployees, 30);
				assertion.assertEquals(csLocators.textEmployees.isDisplayed(), true,
						"Label Employees is not displayed");

				if (data.get(i).equalsIgnoreCase("Export Leads"))
					Thread.sleep(3000);
				GenericMethods.waitForElementVisiblity(csLocators.btnExportLeads, 30);				
				assertion.assertEquals(GenericMethods.isElementDisplayed(csLocators.btnExportLeads), true,
						"Export Leads is not displayed");

			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify TopCountries Graph is visible")
	public void verify_top_countries_graph_is_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "verify TopCountries Graph is visible");
			GenericMethods.waitForElementVisiblity(csLocators.graphTopCountries, 30);
			assertion.assertEquals(GenericMethods.isElementDisplayed(csLocators.graphTopCountries), true,
					"TopCountries Graph is not displayed");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify Employees graph is visible")
	public void verify_employees_graph_is_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "verify Employees graph is visible");
			GenericMethods.waitForElementVisiblity(csLocators.graphEmployees, 30);
			assertion.assertEquals(GenericMethods.isElementDisplayed(csLocators.graphEmployees), true,
					"Employees graph is not displayed");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user click on Open Survey questions")
	public void user_click_on_open_survey_questions() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user click on Open Survey questions");
			GenericMethods.clickByWebElement(csLocators.linkOpen);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user click on any account hyperlink")
	public void user_click_on_any_account_hyperlink() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user click on any account hyperlink");
			GenericMethods.waitForElementVisiblity(csLocators.linkAccount, 30);
			GenericMethods.clickByWebElement(csLocators.linkAccount);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify if user navigates to Accounts Overview page")
	public void verify_if_user_navigates_to_accounts_overview_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify if user navigates to Accounts Overview page");
			GenericMethods.waitForElementVisiblity(aol.lblTopAccountScore, 30);
			assertion.assertEquals(GenericMethods.isElementDisplayed(aol.lblTopAccountScore), true,
					"Navigation to overview page failed");

		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user click on Domain hyperlink")
	public void user_click_on_domain_hyperlink() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user click on Domain hyperlink");
			GenericMethods.waitForElementVisiblity(csLocators.linkDomain, 30);
			GenericMethods.clickByWebElement(csLocators.linkDomain);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify if user navigates to domain page")
	public void verify_if_user_navigates_to_domain_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "verify if user navigates to domain page");
			Thread.sleep(3000);
			String winHandleBefore = DriverManager.getDriver().getWindowHandle();
			for (String winHandle : DriverManager.getDriver().getWindowHandles()) {
				DriverManager.getDriver().switchTo().window(winHandle);
			}
			if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
			assertion.assertEquals(DriverManager.getDriver().getTitle(), "Homepage - Atento",
					"Navigation to Domain page failed");
			}else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {
				
				assertion.assertEquals(DriverManager.getDriver().getTitle(), "MRP Prelytix",
						"Navigation to Domain page failed");}
			DriverManager.getDriver().close();
			DriverManager.getDriver().switchTo().window(winHandleBefore);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user click on Asset URL")
	public void user_click_on_asset_url() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user click on Asset URL");
			GenericMethods.waitForElementVisiblity(csLocators.linkSuccess, 30);
			GenericMethods.clickByWebElement(csLocators.linkSuccess);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify if user navigates to success page")
	public void verify_if_user_navigates_to_success_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "verify if user navigates to success page");
			Thread.sleep(3000);
			String winHandleBefore = DriverManager.getDriver().getWindowHandle();
			for (String winHandle : DriverManager.getDriver().getWindowHandles()) {
				DriverManager.getDriver().switchTo().window(winHandle);
			}

			assertion.assertEquals(DriverManager.getDriver().getTitle(),
					"MRP Prelytix - Enterprise-Class ABM Success Stories", "Navigation to success page failed");

			DriverManager.getDriver().close();
			DriverManager.getDriver().switchTo().window(winHandleBefore);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user click on Export Leads")
	public void user_click_on_export_leads() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user click on Export Leads");
			GenericMethods.waitForElementVisiblity(csLocators.btnExportLeads, 30);
			GenericMethods.clickByWebElement(csLocators.btnExportLeads);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify Leads excel sheet is downloaded")
	public void verify_leads_excel_sheet_is_downloaded() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "verify Leads excel sheet is downloaded");
			csActions.verifyDocumentDownload();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify popup opens")
	public void verify_popup_opens() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "verify popup opens");
			GenericMethods.waitForElementVisiblity(csLocators.popupQstn, 30);
			GenericMethods.isElementDisplayed(csLocators.popupQstn);
			
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("click on X to close")
	public void click_on_x_to_close() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "click on X to close");
			GenericMethods.waitForElementVisiblity(csLocators.btnClose, 35);
			GenericMethods.clickByWebElement(csLocators.btnClose);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

}
