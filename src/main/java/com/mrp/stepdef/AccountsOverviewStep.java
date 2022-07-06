package com.mrp.stepdef;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.bouncycastle.crypto.digests.GeneralDigest;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.AccountsOverviewActions;
import com.mrp.pageObjects.locators.AccountsOverviewLocators;
import com.mrp.pageObjects.locators.CreateCompanyLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsOverviewStep extends ReportManager{
	
	AccountsOverviewLocators aol;
	AccountsOverviewActions aoa = new AccountsOverviewActions();
	ExtentTest logtoreport = null;
	SoftAssert softassert = new SoftAssert();
	
	@When("User selects an account from list")
	public void user_selects_an_account_from_list() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"User selects an account from list");
			aoa.clicksearch();
			aoa.searchAccount();
			Thread.sleep(2000);
			aoa.selectAccount();
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}		
	}

	
	@When("User is on OverView Tab")
	public void user_is_on_over_view_tab() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"User is on OverView Tab");
			GenericMethods.waitForElementVisiblity(aol.lblTopAccountScore, 25);
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}	
	}

	@Then("Verify the Account name")
	public void verify_the_account_name() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify the Account name");
			if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
			GenericMethods.waitForElementVisiblity(aol.accountFitbit, 15);
			softassert.assertTrue(GenericMethods.getText(aol.accountFitbit).contains("Fitbit"));
			}
			else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {
				GenericMethods.waitForElementVisiblity(aol.accountFitbit, 15);
				softassert.assertTrue(GenericMethods.getText(aol.accountFitbit).contains("Craig Hospital"));
			}
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}	
	}
	
	@Then("Verify the contents of the Overview page")
	public void verify_the_contents_of_the_overview_page(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify the contents of the Overview page");
			Thread.sleep(9000);
			GenericMethods.waitForElementVisiblity(aol.lblSummary, 30);
			List<String> data = dataTable.values();

			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).equalsIgnoreCase("TOP ACCOUNT SCORE"))

					aol.lblTopAccountScore.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("ACCOUNT ACTIVITY"))

					aol.lblAccountActivity.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("SUMMARY"))

					aol.lblSummary.isDisplayed();
				
			}
			
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}	
	}

	@Then("Verify Top Account score widget contents")
	public void verify_top_account_score_widget_contents(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify Top Account score widget contents");
			Thread.sleep(2000);
			List<String> data = dataTable.values();

			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).equalsIgnoreCase("CanvasChart"))
					GenericMethods.waitForElementVisiblity(aol.canvasChart, 15);
					aol.canvasChart.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Composition"))

					aol.lblComposition.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Fitness"))

					aol.lblFitness.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Implicit Intent"))

					aol.lblImplicitIntent.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Engagement"))

					aol.lblEngagement.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Topic"))

					aol.lblTopic.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Location"))

					aol.lblLocation.isDisplayed();
			}	
			
			
			
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}	
	}

	@Then("Verify data for Topic and Location")
	public void verify_data_for_topic_and_location() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify data for Topic and Location");
			GenericMethods.waitForElementVisiblity(aol.textDataAnalytics, 15);
			GenericMethods.isElementDisplayed(aol.textDataAnalytics);
			GenericMethods.isElementDisplayed(aol.verifyLocation);
			} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}	
	}

	@Then("Verify the Account Activity widget")
	public void verify_the_account_activity_widget(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify the Account Activity widget");
			
			Thread.sleep(2000);
			List<String> data = dataTable.values();

			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).equalsIgnoreCase("Display Clicks"))
					GenericMethods.waitForElementVisiblity(aol.lblDisplayClicks, 30);

					aol.lblDisplayClicks.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Display Impressions"))

					aol.lblDisplayImpressions.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Website Visits"))

					aol.lblWebsiteVisits.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Content Syndication"))

					aol.lblContentSyndication.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Sales Development"))

					aol.lblSalesDevelopment.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Calender Selection"))

					aol.calender.isDisplayed();
			}	
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}	
	}

	@Given("select an account from result")
	public void select_an_account_from_result() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"select an account from result");
			GenericMethods.clickByWebElement(aol.filterAccount);
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}	
		
	}

	@Then("user will change dates")
	public void user_will_change_dates() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user will change dates");
			
			GenericMethods.clickByWebElement(aol.clickdate);
			GenericMethods.clickByWebElement(aol.clickPrevMonth);
			GenericMethods.clickByWebElement(aol.selectdate);
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}	
		
	}

	@Then("verify graph changes in Account Activity chart")
	public void verify_graph_changes_in_account_activity_chart() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify graph changes in Account Activity chart");
			GenericMethods.waitForElementVisiblity(aol.showActivity, 15);
			GenericMethods.isElementDisplayed(aol.showActivity);
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}	
	}	

	@Then("Verify graph changes days to weeks when dates are given more than a month")
	public void verify_graph_changes_days_to_weeks_when_dates_are_given_more_than_a_month() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify graph changes days to weeks when dates are given more than a month");
			GenericMethods.isElementDisplayed(aol.listDates);
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}	
	}

	@Then("Verify if all the sections are visible in summary Widget")
	public void verify_if_all_the_sections_are_visible_in_summary_widget() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify if all the sections are visible in summary Widget");
			GenericMethods.waitForElementVisiblity(aol.lblSummary, 30);
			GenericMethods.isElementDisplayed(aol.lblSummary);
			GenericMethods.waitForElementVisiblity(aol.contentSummary, 30);
			GenericMethods.isElementDisplayed(aol.contentSummary);
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}	
	}

}
