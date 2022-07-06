package com.mrp.stepdef;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;  

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.DisplayReportActions;
import com.mrp.pageObjects.locators.DisplayReportLocators;
import com.mrp.pageObjects.locators.PerformanceDashboardLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;

import io.cucumber.java.en.Then;

public class DisplayReportStep extends ReportManager{

	ExtentTest logtoreport = null;
	DisplayReportActions drActions;
	DisplayReportLocators drlocators;
	PerformanceDashboardLocators pdLocators;
	String clicks;
	String impressions;
	String clickThroughrate;
	Assertion assertion = new Assertion();
	
	public DisplayReportStep() {
		this.drActions = new DisplayReportActions();
		this.drlocators = new DisplayReportLocators();
		this.pdLocators = new PerformanceDashboardLocators();
		PageFactory.initElements(DriverManager.getDriver(),this.drlocators);
		PageFactory.initElements(DriverManager.getDriver(),this.drActions);
		PageFactory.initElements(DriverManager.getDriver(),this.pdLocators);

	}
	
	@Then("user navigates to Display Report page")
	public void user_navigates_to_display_report_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"User is navigates to performance Dashboard page");
			
			drActions.clickDisplayReport();
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the contents of Display Report page")
	public void verify_the_contents_of_display_report_page(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify the contents of Display Report page");
			Thread.sleep(3000);
			List<String> data = dataTable.values();
			
			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).equalsIgnoreCase("Display Report"))
                    GenericMethods.waitForElementVisiblity(drlocators.textDisplayReport, 15);
					drlocators.textDisplayReport.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Impressions"))

					drlocators.textImpressions.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Account Reach"))

					drlocators.textAccountReach.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Cost Analysis"))

					drlocators.textCostAnalysis.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Clicks"))

					drlocators.textClicks.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Click-Through Rate"))

					drlocators.textClickThroughRate.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Site Lift"))

					drlocators.textSiteLift.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("View Filters"))

					pdLocators.textViewFilters.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Last 7 days"))

					pdLocators.textTimeFrame.isDisplayed();
			}
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify Impressions,Clicks and Click through Rate numbers are visible")
	public void verify_impressions_clicks_and_click_through_rate_numbers_are_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify Impressions,Clicks and Click through Rate numbers are visible");
			GenericMethods.waitForElementVisiblity(drlocators.NoClicks, 15);
			GenericMethods.isElementDisplayed(drlocators.NoClicks);
			clicks = GenericMethods.getText(drlocators.NoClicks);
			GenericMethods.waitForElementVisiblity(drlocators.NoImpressions, 15);

			GenericMethods.isElementDisplayed(drlocators.NoImpressions);
		    impressions = GenericMethods.getText(drlocators.NoImpressions);
			GenericMethods.waitForElementVisiblity(drlocators.NoClickThroughRate, 15);

		    GenericMethods.isElementDisplayed(drlocators.NoClickThroughRate);
			clickThroughrate = GenericMethods.getText(drlocators.NoClickThroughRate);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the Total number of accounts")
	public void verify_the_total_number_of_accounts() throws IOException, InterruptedException,AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify the Total number of accounts");
			
			String Accounts = GenericMethods.getText(drlocators.totalAccounts);			
			String[] getNoAccounts = Accounts.split(" "); 
			String noAccounts = getNoAccounts[2];			
			
			GenericMethods.clickByWebElement(pdLocators.selectParformanceDashboard);
			GenericMethods.waitForElementVisiblity(pdLocators.NoAccounts, 15);					
			assertion.assertEquals(noAccounts, GenericMethods.getText(pdLocators.NoAccounts));			
			GenericMethods.clickByWebElement(drlocators.selectDisplayReport);
		} catch (Exception|AssertionError ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify Impressions,Clicks and Click through Rate are changed")
	public void verify_impressions_clicks_and_click_through_rate_are_changed() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify Impressions,Clicks and Click through Rate are changed");
			GenericMethods.waitForElementVisiblity(drlocators.NoClicks, 50);
			GenericMethods.isElementDisplayed(drlocators.NoClicks);
			assertion.assertNotEquals(clicks, GenericMethods.getText(drlocators.NoClicks));
			GenericMethods.waitForElementVisiblity(drlocators.NoImpressions, 50);
			GenericMethods.isElementDisplayed(drlocators.NoImpressions);
		    assertion.assertNotEquals(impressions, GenericMethods.getText(drlocators.NoImpressions));
		    GenericMethods.waitForElementVisiblity(drlocators.NoClickThroughRate, 50);
		    GenericMethods.isElementDisplayed(drlocators.NoClickThroughRate);			
			assertion.assertNotEquals(clickThroughrate, GenericMethods.getText(drlocators.NoClickThroughRate));

		} catch (Exception|AssertionError ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify Impressions percentage and graph are visible")
	public void verify_impressions_percentage_and_graph_are_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify Impressions percentage and graph are visible");
		    Thread.sleep(3000);
			GenericMethods.waitForElementVisiblity(drlocators.prctImpressions, 15);
			GenericMethods.isElementDisplayed(drlocators.prctImpressions);
			GenericMethods.isElementDisplayed(drlocators.graphImpressions);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify Account reach chart and number of accounts are visible")
	public void verify_account_reach_chart_and_number_of_accounts_are_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify Account reach chart and number of accounts are visible");
			GenericMethods.waitForElementVisiblity(drlocators.graphAccountReach, 15);

			GenericMethods.isElementDisplayed(drlocators.graphAccountReach);
			GenericMethods.isElementDisplayed(drlocators.totalAccounts);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify Cost Analysis graph is visible")
	public void verify_cost_analysis_graph_is_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify Cost Analysis graph is visible");
			GenericMethods.waitForElementVisiblity(drlocators.graphCostAnalysis, 15);
			GenericMethods.isElementDisplayed(drlocators.graphCostAnalysis);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify Clicks graph and percentage are visible")
	public void verify_clicks_graph_and_percentage_are_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify Clicks graph and percentage are visible");
			
			GenericMethods.isElementDisplayed(drlocators.graphClicks);
			GenericMethods.isElementDisplayed(drlocators.prctClicks);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify Click-Through Rate and percentage are visible")
	public void verify_click_through_rate_and_percentage_are_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify Click-Through Rate and percentage are visible");
			
			GenericMethods.isElementDisplayed(drlocators.NoClickThroughRate);
			GenericMethods.isElementDisplayed(drlocators.prctClickThroughRate);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify Site Lift graph is visible")
	public void verify_site_lift_graph_is_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify Site Lift graph is visible");
			
			GenericMethods.isElementDisplayed(drlocators.graphSiteLift);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
}
