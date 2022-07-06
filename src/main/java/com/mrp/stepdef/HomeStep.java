package com.mrp.stepdef;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.DisplayReportActions;
import com.mrp.pageObjects.locators.DisplayReportLocators;
import com.mrp.pageObjects.locators.HomeLocators;
import com.mrp.pageObjects.locators.PerformanceDashboardLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class HomeStep extends ReportManager{
	
	HomeLocators hLoc = new HomeLocators();
	String topic;
	Assertion assertion = new Assertion();
	ExtentTest logtoreport = null;

	public HomeStep() {
		
		PageFactory.initElements(DriverManager.getDriver(),this.hLoc);
		
	}
	
	@Then("Verify the contents of the Home page")
	public void verify_the_contents_of_the_home_page(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify the contents of the Home page");
         List<String> data = dataTable.values();
		
		for (int i = 0; i < data.size(); i++) {

			if (data.get(i).equalsIgnoreCase("Account Reach"))
				
				GenericMethods.isElementDisplayed(hLoc.txtAccountReach);
			
			if (data.get(i).equalsIgnoreCase("Tactic Performance"))

				GenericMethods.isElementDisplayed(hLoc.txtTacticPerformance);
			
			if (data.get(i).equalsIgnoreCase("Average Topic Score"))

				GenericMethods.isElementDisplayed(hLoc.txtAverageTopicScore);
			
			if (data.get(i).equalsIgnoreCase("Acivity"))

				GenericMethods.isElementDisplayed(hLoc.txtActivity);
			
			if (data.get(i).equalsIgnoreCase("Top Accounts"))

				GenericMethods.isElementDisplayed(hLoc.txtTopAccounts);	
		}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
		
	}
	
	@When("user clicks on topic")
	public void user_clicks_on_topic() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user clicks on topic");
		GenericMethods.waitForElementVisiblity(hLoc.linkTopic, 10);
		 topic = GenericMethods.getText(hLoc.linkTopic);
	    GenericMethods.clickByWebElement(hLoc.linkTopic);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	    
	}

	@Then("user should be redirected to accounts page")
	public void user_should_be_redirected_to_accounts_page() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user should be redirected to accounts page");
		GenericMethods.waitForElementVisiblity(hLoc.tableAccounts, 10);
	   GenericMethods.isElementDisplayed(hLoc.tableAccounts);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the accounts list has clicked topic filtered")
	public void verify_the_accounts_list_has_clicked_topic_filtered() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify the accounts list has clicked topic filtered");
		assertion.assertEquals(topic,GenericMethods.getText(hLoc.accountsTopic) );
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}

	@Then("user comes back to Home page")
	public void user_comes_back_to_home_page() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user comes back to Home page");
		GenericMethods.clickByWebElement(hLoc.Home);
	    GenericMethods.waitForElementVisiblity(hLoc.txtAccountReach, 10);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("user should see average score in the widget")
	public void user_should_see_average_score_in_the_widget() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user should see average score in the widget");
		GenericMethods.isElementDisplayed(hLoc.avgScore);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user clicks on View distribution Hyperlink")
	public void user_clicks_on_view_distribution_hyperlink() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user clicks on View distribution Hyperlink");
		GenericMethods.clickByWebElement(hLoc.linkScoreDistribution);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("user should see Topic Score Distribution PopUp")
	public void user_should_see_topic_score_distribution_pop_up() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user should see Topic Score Distribution PopUp");
		GenericMethods.waitForElementVisiblity(hLoc.txtShareofVoice, 10);
	   GenericMethods.isElementDisplayed(hLoc.txtShareofVoice);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("user should see bar chart and Share of voice,vendors")
	public void user_should_see_bar_chart_and_share_of_voice_vendors() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user should see bar chart and Share of voice,vendors");
		GenericMethods.waitForElementVisiblity(hLoc.graphScoreDistribution, 10);
	   GenericMethods.isElementDisplayed(hLoc.graphScoreDistribution);
	   GenericMethods.isElementDisplayed(hLoc.graphShareOfVoice);
	   GenericMethods.isElementDisplayed(hLoc.vendors);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user clicks on close button")
	public void user_clicks_on_close_button() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user clicks on close button");
		GenericMethods.clickByWebElement(hLoc.btnClose);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("user should be redirected to Home page")
	public void user_should_be_redirected_to_home_page() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user should be redirected to Home page");
		GenericMethods.isElementDisplayed(hLoc.txtAccountReach);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user sort accounts by ascending order")
	public void user_sort_accounts_by_ascending_order() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user sort accounts by ascending order");
		GenericMethods.waitForElementVisiblity(hLoc.drpdwnTopicScoreSort, 10);
	    GenericMethods.clickByWebElement(hLoc.drpdwnTopicScoreSort);
	    GenericMethods.clickByWebElement(hLoc.selectAscending);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}

	@Then("verify the accounts are sorted in ascending order")
	public void verify_the_accounts_are_sorted_in_ascending_order() throws InterruptedException, IOException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify the accounts are sorted in ascending order");
		GenericMethods.waitForElementVisiblity(hLoc.score1, 10);
	   int score1 = Integer.parseInt(GenericMethods.getText(hLoc.score1));
	   GenericMethods.clickByWebElement(hLoc.btnLastPage);
	   Thread.sleep(2000);
	   int rows = DriverManager.getDriver().findElements(By.xpath("//main/section//table/tbody/tr")).size();
	   
		int score2 = Integer.parseInt(DriverManager.getDriver().findElement(By.xpath("//main/section//table/tbody/tr["+rows+"]/td[2]//span")).getText());	  
	    
		assertion.assertTrue(score1<score2, "Topic Score sorted in ascending order");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user sort accounts by descending order")
	public void user_sort_accounts_by_descending_order() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user sort accounts by descending order");
		GenericMethods.clickByWebElement(hLoc.drpdwnTopicScoreSort);
	    GenericMethods.clickByWebElement(hLoc.selectDescending);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}

	@Then("verify the accounts are sorted in descending order")
	public void verify_the_accounts_are_sorted_in_descending_order() throws InterruptedException, IOException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify the accounts are sorted in descending order");
		GenericMethods.waitForElementVisiblity(hLoc.score1, 10);
		   int score1 = Integer.parseInt(GenericMethods.getText(hLoc.score1));
		   GenericMethods.clickByWebElement(hLoc.btnLastPage);
		   Thread.sleep(2000);
		   int rows = DriverManager.getDriver().findElements(By.xpath("//main/section//table/tbody/tr")).size();
			int score2 = Integer.parseInt(DriverManager.getDriver().findElement(By.xpath("//main/section//table/tbody/tr["+rows+"]/td[2]//span")).getText());	  
		    
			assertion.assertTrue(score1>score2, "Topic Score sorted in ascending order");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user select a topic from dropdown")
	public void user_select_a_topic_from_dropdown() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user select a topic from dropdown");
		GenericMethods.clickByWebElement(hLoc.drpdwnTopic);
	    GenericMethods.clickByWebElement(hLoc.selectTopic);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify accounts shown for the topic selected")
	public void verify_accounts_shown_for_the_topic_selected() throws IOException, InterruptedException, AssertionError {	   
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify accounts shown for the topic selected");
		assertion.assertEquals(GenericMethods.getText(hLoc.drpdwnTopic), GenericMethods.getText(hLoc.txtTopic));
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user select an account")
	public void user_select_an_account() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user select an account");
		GenericMethods.clickByWebElement(hLoc.linkAccount);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("user should be redirected to intelligence tab")
	public void user_should_be_redirected_to_intelligence_tab() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user should be redirected to intelligence tab");
		GenericMethods.waitForElementVisiblity(hLoc.tabIntelligence, 10);
	    GenericMethods.isElementDisplayed(hLoc.tabIntelligence);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user select website click")
	public void user_select_website_click() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user select website click");
		GenericMethods.waitForElementVisiblity(hLoc.btnFilters, 10);
	    GenericMethods.clickByWebElement(hLoc.btnFilters);
	    GenericMethods.clickByWebElement(hLoc.drpdwnfilterType);
	    GenericMethods.clickByWebElement(hLoc.selectWebsiteClick);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("user should see results for website")
	public void user_should_see_results_for_website() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user should see results for website");
		assertion.assertTrue(GenericMethods.getText(hLoc.firstActivity).contains(" page on your website."), "Results not found on activity widget");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
		}

	@When("user click on account")
	public void user_click_on_account() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user click on account");
		GenericMethods.clickByWebElement(hLoc.activityAccount);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("user should be redirected to account overview")
	public void user_should_be_redirected_to_account_overview() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user should be redirected to account overview");
		GenericMethods.waitForElementVisiblity(hLoc.lblTopAccountScore, 10);
		GenericMethods.clickByWebElement(hLoc.lblTopAccountScore);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user select display click")
	public void user_select_display_click() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user select display click");
		GenericMethods.waitForElementVisiblity(hLoc.btnFilters, 10);
		GenericMethods.clickByWebElement(hLoc.btnFilters);
	    GenericMethods.clickByWebElement(hLoc.drpdwnfilterType);
	    GenericMethods.clickByWebElement(hLoc.selectDisplayClick);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("user should see results for display clicks")
	public void user_should_see_results_for_display_clicks() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user should see results for display clicks");
		GenericMethods.waitForElementVisiblity(hLoc.firstActivity,10);
	    assertion.assertTrue(GenericMethods.getText(hLoc.firstActivity).contains(" campaign."), "Results not found on activity widget");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user click on a tactic")
	public void user_click_on_a_tactic() {
	    
	}

	@Then("user should be redirected to display report page")
	public void user_should_be_redirected_to_display_report_page() {
	   
	}

}
