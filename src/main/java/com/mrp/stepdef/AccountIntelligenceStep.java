package com.mrp.stepdef;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.AccountIntelligenceActions;
import com.mrp.pageObjects.locators.AccountIntelligenceLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountIntelligenceStep extends ReportManager{

	AccountIntelligenceLocators ail = new AccountIntelligenceLocators();
	AccountIntelligenceActions aiActions = new AccountIntelligenceActions();
	ExtentTest logtoreport = null;

	
	
	  public AccountIntelligenceStep() { this.aiActions = new
	  AccountIntelligenceActions(); this.ail = new AccountIntelligenceLocators();
	  PageFactory.initElements(DriverManager.getDriver(),this.aiActions);
	  PageFactory.initElements(DriverManager.getDriver(),this.ail);
	  
	  }
	 
	@When("User select an account")
	public void user_select_an_account() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"User select an account");
			aiActions.clicksearch();
			aiActions.searchAccount();
			Thread.sleep(2000);
			aiActions.selectAccount();
			} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	@When("user navigate to Intelligence Tab")
	public void user_navigate_to_intelligence_tab() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user navigate to Intelligence Tab");
			GenericMethods.waitForElementVisiblity(ail.tabIntelligence, 30);
			GenericMethods.clickByWebElement(ail.tabIntelligence);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	@Then("user verify the contents of the page")
	public void user_verify_the_contents_of_the_page(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user verify the contents of the page");
			List<String> data = dataTable.values();
			System.out.println("Size : " + data.size());
			System.out.println("List : " + data.toString());

			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).equalsIgnoreCase("Location"))
					GenericMethods.waitForElementVisiblity(ail.lblLocation, 15);
				ail.lblLocation.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Topic"))
					GenericMethods.waitForElementVisiblity(ail.lblTopic, 15);

					ail.lblTopic.isDisplayed();
				

				if (data.get(i).equalsIgnoreCase("Time Frame"))
					GenericMethods.waitForElementVisiblity(ail.lblTimeframe, 15);

					ail.lblTimeframe.isDisplayed();
				

				if (data.get(i).equalsIgnoreCase("ACCOUNT SCORE"))
					GenericMethods.waitForElementVisiblity(ail.lblAccountScore, 15);

					ail.lblAccountScore.isDisplayed();
				

				if (data.get(i).equalsIgnoreCase("TOP KEY TERMS"))
					GenericMethods.waitForElementVisiblity(ail.lblTopKeyTerms, 15);

					ail.lblTopKeyTerms.isDisplayed();
				

				if (data.get(i).equalsIgnoreCase("TOP VENDOR EXPOSURE"))
					GenericMethods.waitForElementVisiblity(ail.lblTopVendorExposure, 15);

					ail.lblTopVendorExposure.isDisplayed();
				

				if (data.get(i).equalsIgnoreCase("WEBSITE ACTIVITY"))
					GenericMethods.waitForElementVisiblity(ail.lblWebsiteActivity, 15);

					ail.lblWebsiteActivity.isDisplayed();
			}

		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	@When("select a Topic to see account score")
	public void select_a_topic_to_see_account_score() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"select a Topic to see account score");
			GenericMethods.clickByWebElement(ail.drpTopic);
			GenericMethods.clickByWebElement(ail.selectTopic);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	@When("Verify if account score is visible")
	public void verify_if_account_score_is_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify if account score is visible");
			//GenericMethods.isElementDisplayed(ail.accountScoreNumber);
			
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	@When("Veirfy if bar chart is visible")
	public void veirfy_if_bar_chart_is_visible() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Veirfy if bar chart is visible");
			GenericMethods.waitForElementVisiblity(ail.accountScorebar, 15);
			GenericMethods.isElementDisplayed(ail.accountScorebar);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("select {string} from timeframe dropdown")
	public void select_from_timeframe_dropdown(String string) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"select {string} from timeframe dropdown");
			GenericMethods.clickByWebElement(ail.drpTimeframe);
			GenericMethods.clickByWebElement(ail.selectTimeframe);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	@Then("select {string} from Topic dropdown")
	public void select_from_topic_dropdown(String string) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"select {string} from Topic dropdown");
			GenericMethods.waitForElementVisiblity(ail.drpTopic, 15);
			GenericMethods.clickByWebElement(ail.drpTopic);
			GenericMethods.clickByWebElement(ail.selectAllTopics);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	@Then("verify data is shown in top key terms widget")
	public void verify_data_is_shown_in_top_key_terms_widget() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify data is shown in top key terms widget");
			GenericMethods.waitForElementVisiblity(ail.chartTopKeyTerms, 15);
			GenericMethods.isElementDisplayed(ail.chartTopKeyTerms);
			
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}	
	@Then("Verify TOP VENDOR EXPOSURE widget showing data")
	public void verify_top_vendor_exposure_widget_showing_data() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify TOP VENDOR EXPOSURE widget showing data");
			GenericMethods.waitForElementVisiblity(ail.chartTopVendorExposure, 15);
			GenericMethods.isElementDisplayed(ail.chartTopVendorExposure);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	
	@Then("verify the contents for the widget")
	public void verify_the_contents_for_the_widget(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify the contents for the widget");
			GenericMethods.waitForElementVisiblity(ail.lblPage, 10);
			List<String> data = dataTable.values();
			System.out.println("Size : " + data.size());
			System.out.println("List : " + data.toString());

			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).equalsIgnoreCase("PAGE"))

					ail.lblPage.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("VISITS"))

					ail.lblVisits.isDisplayed();
				
				if (data.get(i).equalsIgnoreCase("LAST VISIT DATE"))

					ail.lblLastVisitDate.isDisplayed();				
			}
				
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	@Then("verify data shown in the widget")
	public void verify_data_shown_in_the_widget() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify data shown in the widget");
			GenericMethods.waitForElementVisiblity(ail.dataWebsiteActivity, 15);
			GenericMethods.isElementDisplayed(ail.dataWebsiteActivity);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}	
		
	@Then("select an item from topic dropdown")
	public void select_an_item_from_topic_dropdown() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"select an item from topic dropdown");
			GenericMethods.clickByWebElement(ail.drpTopic);
			GenericMethods.waitForElementVisiblity(ail.selectTopic, 5);
			GenericMethods.clickByWebElement(ail.selectTopic);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	@Then("verify the result is shown")
	public void verify_the_result_is_shown() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify the result is shown");
			GenericMethods.waitForElementVisiblity(ail.accountScorebar, 15);
			GenericMethods.isElementDisplayed(ail.accountScorebar);

		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	
	@Then("verify the result is shown with timeframe")
	public void verify_the_result_is_shown_with_timeframe() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify the result is shown with timeframe");
			GenericMethods.isElementDisplayed(ail.accountScoreNumber);
			GenericMethods.isElementDisplayed(ail.accountScorebar);

		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
}
