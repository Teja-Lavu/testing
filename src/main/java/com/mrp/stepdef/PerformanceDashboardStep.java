package com.mrp.stepdef;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.PerformanceDashboardActions;
import com.mrp.pageObjects.locators.PerformanceDashboardLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;

import ch.qos.logback.classic.boolex.GEventEvaluator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PerformanceDashboardStep extends ReportManager{
	
	PerformanceDashboardActions pdActions;
	PerformanceDashboardLocators pdLocators;
	ExtentTest logtoreport = null;
	
	public PerformanceDashboardStep() {
		 this.pdActions = new PerformanceDashboardActions();
		 this.pdLocators = new PerformanceDashboardLocators();

				PageFactory.initElements(DriverManager.getDriver(),this.pdActions);
				PageFactory.initElements(DriverManager.getDriver(),this.pdLocators);
	}

	@Then("user navigates to performance Dashboard page")
	public void user_is_navigates_to_performance_dashboard_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"),
					"User is navigates to performance Dashboard page");
			
		pdActions.clickPerformanceDash();
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the contents of Performance Dashboard page")
	public void verify_the_contents_of_performance_dashboard_page(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Verify the contents of Performance Dashboard page");
			List<String> data = dataTable.values();
			Thread.sleep(9000);		
			GenericMethods.waitForElementVisiblity(pdLocators.textParformanceDashboard, 30);
			
			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).equalsIgnoreCase("Performance Dashboard"))

					pdLocators.textParformanceDashboard.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("View Filters"))

					pdLocators.textViewFilters.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("TimeFrame dropdown"))

					pdLocators.textTimeFrame.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Accounts"))

					pdLocators.textAccounts.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Accounts W/INTENT"))

					pdLocators.textAccountsIntent.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Site Visits"))

					pdLocators.textSiteVisits.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Orchestration"))

					pdLocators.textOrchestration.isDisplayed();
		
				if (data.get(i).equalsIgnoreCase("Top Accounts"))

					pdLocators.textTopAccounts.isDisplayed();
			}
			
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@When("user select Time Frame {string}")
	public void user_select_time_frame(String string) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"User select Time Frame Last 365 Days");
			
		pdActions.selectTimeFrame();
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("verify the Number of Accounts filtered in Accounts Widget")
	public void verify_the_number_of_accounts_filtered_in_accounts_widget() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Verify the Number of Accounts filtered in Accounts Widget");
			
		String NoAccounts = GenericMethods.getText(pdLocators.NoAccounts);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("verify the contents of Orchestration widget")
	public void verify_the_contents_of_orchestration_widget(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Verify the contents of Orchestration widget");
			List<String> data = dataTable.values();
						
			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).equalsIgnoreCase("Average"))

					pdLocators.textAverage.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Total"))

					pdLocators.textTotal.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Impressions"))

					pdLocators.textImpressions.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Site Visits"))

					pdLocators.textSiteVisitsO.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Content Syndication Leads"))

					pdLocators.textContentSyndicationLeads.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("Sales Development Leads"))

					pdLocators.textSalesDevelopmentLeads.isDisplayed();
				
			}
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("verify the Impressions and Site visits charts are visible")
	public void verify_the_impressions_and_site_visits_charts_are_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify the Impressions and Site visits charts are visible");
			
		GenericMethods.isElementDisplayed(pdLocators.chartImpressions);
		GenericMethods.isElementDisplayed(pdLocators.chartSiteVisitsO);

		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("verify the number of Content Syndication Leads and Sales Development Leads")
	public void verify_the_number_of_content_syndication_leads_and_sales_development_leads() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Verify the number of Content Syndication Leads and Sales Development Leads");
			
			pdActions.assertContentSyndication();
		    pdActions.assertSalesDevelopment();		
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("verify the number of Accounts W\\/Intent")
	public void verify_the_number_of_accounts_w_intent() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Verify the number of Accounts W/Intent");
			GenericMethods.waitForElementVisiblity(pdLocators.NoAccountsINTENT, 25);
			GenericMethods.getText(pdLocators.NoAccountsINTENT);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("verify the % is visible")
	public void verify_the_is_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Verify the %");
			
	    GenericMethods.waitForElementVisiblity(pdLocators.prctSiteVisits, 15);	
		GenericMethods.isElementDisplayed(pdLocators.prctSiteVisits);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("verify the Accounts W\\/Intent graph is visible in widget")
	public void verify_the_accounts_w_intent_graph_is_visible_in_widget() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Verify the Accounts W/Intent graph is visible in widget");
			GenericMethods.waitForElementVisiblity(pdLocators.chartAccountsINTENT, 15);	
		GenericMethods.isElementDisplayed(pdLocators.chartAccountsINTENT);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("verify the Number site visits")
	public void verify_the_number_site_visits() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Verify the Number site visits");
			GenericMethods.waitForElementVisiblity(pdLocators.NoSiteVisits, 15);	
	
		GenericMethods.getText(pdLocators.NoSiteVisits);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("verify the % site visits is visible")
	public void verify_the_site_visits_is_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Verify the % site visits");
			GenericMethods.waitForElementVisiblity(pdLocators.prctSiteVisits, 15);	
		GenericMethods.isElementDisplayed(pdLocators.prctSiteVisits);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("verify the Site visits graph is visible")
	public void verify_the_site_visits_graph_is_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Verify the Site visits Bar is visible");
			GenericMethods.waitForElementVisiblity(pdLocators.chartSiteVisits, 15);
			GenericMethods.isElementDisplayed(pdLocators.chartSiteVisits);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("verify the contents of Top Accounts widget")
	public void verify_the_contents_of_top_accounts_widget(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Verify the contents of Top Accounts widget");
				Thread.sleep(9000);		 
			 List<String> data = dataTable.values();
								
				for (int i = 0; i < data.size(); i++) {

					if (data.get(i).equalsIgnoreCase("Account"))

						pdLocators.textAccount.isDisplayed();
		
					if (data.get(i).equalsIgnoreCase("Score + Topic"))

						pdLocators.textScoreTopic.isDisplayed();
					
					if (data.get(i).equalsIgnoreCase("Location"))

						pdLocators.textLocation.isDisplayed();
				}
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("verify the number of records")
	public void verify_the_number_of_records() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Verify the number of records");
			
			List<WebElement> lresult = pdLocators.tblAccounts;
			int NoResults = lresult.size();

		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("verify if the Account link is clickable")
	public void verify_if_the_account_link_is_clickable() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Verify if the Account link is clickable");
			
		GenericMethods.isClickable(pdLocators.linkAccount);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@When("user click on a Account")
	public void user_click_on_a_account() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"User click on a Account");
			
		pdActions.clickAccountLink();
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

	@Then("user should be navigated to Account Intelligence Tab")
	public void user_should_be_navigated_to_account_intelligence_tab() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"user should be navigated to Account Intelligence Tab");
			
		GenericMethods.waitForElementVisiblity(pdLocators.detailsAccount, 50);
		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}  
	}

}
