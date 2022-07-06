package com.mrp.stepdef;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.AccountIntelligenceActions;
import com.mrp.pageObjects.locators.AccountIntelligenceLocators;
import com.mrp.pageObjects.locators.AdminUsermanagementLocators;
import com.mrp.pageObjects.locators.TopicsLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TopicsStep extends ReportManager{
	
	ExtentTest logtoreport = null;
	AdminUsermanagementLocators aul = new AdminUsermanagementLocators();
	TopicsLocators tLoc = new TopicsLocators();
	
	public TopicsStep() {
		
			  PageFactory.initElements(DriverManager.getDriver(),this.aul);
			  PageFactory.initElements(DriverManager.getDriver(),this.tLoc);
			  
			  }
	@When("user clicks on admin studio icon")
	public void user_clicks_on_admin_studio_icon() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user clicks on admin studio icon");
			WaitUtils.waitForElementVisiblity(aul.btnAdmin, 20);
			GenericMethods.clickByWebElement(aul.btnAdmin);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@When("user clicks topics from admin studio")
	public void user_clicks_topics_from_admin_studio() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user clicks topics from admin studio");
		GenericMethods.clickByWebElement(TopicsLocators.btnTopics);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("verify create subscription button is displayed")
	public void verify_create_subscription_button_is_displayed() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify create subscription button is displayed");
			GenericMethods.waitForElementVisiblity(tLoc.btnCreateSubsciption, 10);
			Assert.assertTrue(GenericMethods.isElementDisplayed(tLoc.btnCreateSubsciption));
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@When("user clicks on the create subscription button")
	public void user_clicks_on_the_create_subscription_button() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user clicks on the create subscription button");
			GenericMethods.clickByWebElement(tLoc.btnCreateSubsciption);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("verify {string} pop up page is displayed")
	public void verify_pop_up_page_is_displayed(String string) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify subscribe to new topics pop up page is displayed");
		    Assert.assertEquals(GenericMethods.getText(tLoc.lblSubsciptionPopup),string);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("verify {string} button is disabled in the pop up page")
	public void verify_button_is_disabled_in_the_pop_up_page(String string) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify subscribe button is disabled in the pop up page");
			Assert.assertTrue(GenericMethods.isElementDisabled(tLoc.btnSubscribe));
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("verify cancel button is displayed")
	public void verify_cancel_button_is_displayed() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify cancel button is displayed");
			Assert.assertTrue(GenericMethods.isElementDisplayed(tLoc.btnCancel));
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("verify topics list is displayed by using drop down button")
	public void verify_topics_list_is_displayed_by_using_drop_down_button() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify topics list is displayed by using drop down button");
		GenericMethods.clickByWebElement(tLoc.drpDownTopic);
		Assert.assertTrue(GenericMethods.isElementDisplayed(tLoc.listdrpDownTopic));
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	
	@When("user selects {string} from the topics list from topics drop down")
	public void user_selects_from_the_topics_list_from_topics_drop_down(String string) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user selects 'Account management' from the topics list from topics drop down");
			GenericMethods.clickByWebElement(tLoc.drpDownTopic);
			GenericMethods.selecte_dropdown(tLoc.drpDownTopic, string,tLoc.listTopic);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}	
	@When("click on subscribe button")
	public void click_on_subscribe_button() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"click on subscribe button");
		GenericMethods.clickByWebElement(tLoc.btnSubscribe);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}	}
	
	@Then("verify {string} pop up window is displayed")
	public void verify_pop_up_window_is_displayed(String string) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify ' A new topic subscription has been created' pop up window is displayed");
			GenericMethods.waitForElementVisiblity(tLoc.mdlCreatedSubs, 10);
	        Assert.assertEquals(GenericMethods.getText(tLoc.mdlCreatedSubs),string);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("then verify {string} button is displayed on the pop up window")
	public void then_verify_button_is_displayed_on_the_pop_up_window(String string) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"then verify 'Close window' button is displayed on the pop up window");
			GenericMethods.waitForElementVisiblity(tLoc.btnCloseWindow, 10);
			Assert.assertEquals(GenericMethods.getText(tLoc.btnCloseWindow),string);	
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@When("click on close window button")
	public void click_on_close_window_button() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"click on close window button");
			GenericMethods.waitForElementVisiblity(tLoc.btnCloseWindow, 10);
		    GenericMethods.clickByWebElement(tLoc.btnCloseWindow);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("verify {string} topic is displayed on the topic subscription page")
	public void verify_topic_is_displayed_on_the_topic_subscription_page(String string) throws IOException, InterruptedException, AssertionError  {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify 'Accounts management' topic is displayed on the topic subscription page");
			GenericMethods.waitForElementVisiblity(tLoc.lblAccountManagement, 10);
			Assert.assertEquals(GenericMethods.getText(tLoc.lblAccountManagement),string);	
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@When("select {string} and {string} and {string} from the topics list drop down")
	public void select_and_and_from_the_topics_list_drop_down(String string, String string2, String string3) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"select 'Accounts payable' and 'Accounts Receivable' and 'Anti Virus' from the topics list drop down");
			GenericMethods.selecte_dropdown(tLoc.drpDownTopic, string,tLoc.listTopic);
			GenericMethods.selecte_dropdown(tLoc.drpDownTopic, string2,tLoc.listTopic);				
			GenericMethods.selecte_dropdown(tLoc.drpDownTopic, string3,tLoc.listTopic);
			
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	
	@Then("verify {string} and {string} and {string}  topics are added on the topic subscription page")
	public void verify_and_and_topics_are_added_on_the_topic_subscription_page(String string, String string2, String string3) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify 'Accounts payable' and 'Accounts Receivable' and 'Anti Virus' topics are added on the topic subscription page");
			GenericMethods.waitForElementVisiblity(tLoc.lblAccountsPayable, 10);
			Assert.assertEquals(GenericMethods.getText(tLoc.lblAccountsPayable),string);	
			Assert.assertEquals(GenericMethods.getText(tLoc.lblAccountsReceivable),string2);	
			Assert.assertEquals(GenericMethods.getText(tLoc.lblAntiVirus),string3);	
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	
	@When("select {string} from the topics list drop down")
	public void select_from_the_topics_list_drop_down(String string) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"select 'App Dev' from the topics list drop down");
			GenericMethods.selecte_dropdown(tLoc.drpDownTopic, string,tLoc.listTopic);

	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@When("click on cancel button")
	public void click_on_cancel_button() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"click on cancel button");
			GenericMethods.clickByWebElement(tLoc.btnCancel);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("verify if {string} topic is added to the list")
	public void verify_if_topic_is_added_to_the_list(String string) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify if 'App Dev' topic is added to the list");
		Assert.assertFalse(GenericMethods.isElementPresent(By.xpath("//h1[text()='"+string+"']")));		
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	
	@When("select {string}  from the topics list by using drop down button")
	public void select_from_the_topics_list_by_using_drop_down_button(String string) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"select 'ABM'  from the topics list by using drop down button");
		GenericMethods.selecte_dropdown(tLoc.drpDownTopic, string,tLoc.listTopic);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	
	@Then("verify {string} topic is displayed on topic subscription page")
	public void verify_topic_is_displayed_on_topic_subscription_page(String string) throws IOException, InterruptedException, AssertionError  {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify 'ABM' topic is displayed on topic subscription page");
			GenericMethods.waitForElementVisiblity(tLoc.lblABM, 10);
			Assert.assertEquals(GenericMethods.getText(tLoc.lblABM),string);	
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("verify {string} topic is displayed on topic subscription page AppDev")
	public void verify_topic_is_displayed_on_topic_subscription_page_appdev(String string) throws IOException, InterruptedException, AssertionError  {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify 'App Dev' topic is displayed on topic subscription page AppDev");
			GenericMethods.waitForElementVisiblity(tLoc.lblAppDev, 10);
			Assert.assertEquals(GenericMethods.getText(tLoc.lblAppDev),string);	
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("click on three dots icon")
	public void click_on_three_dots_icon() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"click on three dots icon");
		GenericMethods.clickByWebElement(tLoc.btnThreeDots);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("click on three dots icon AppDev")
	public void click_on_three_dots_icon_appdev() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"click on three dots icon");
		GenericMethods.clickByWebElement(tLoc.btnThreeDotsAD);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("verify {string} button is displayed")
	public void verify_button_is_displayed(String string) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify 'Unsubscribe' button is displayed");
		Assert.assertEquals(GenericMethods.getText(tLoc.btnUnsubscribe),string);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@When("user clicks on unsubscribe button")
	public void user_clicks_on_unsubscribe_button() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user clicks on unsubscribe button");
		GenericMethods.clickByWebElement(tLoc.btnUnsubscribe);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("Verify {string} pop up is displayed AppDev")
	public void verify_pop_up_is_displayed_appdev(String string) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify 'Are you sure you want to unsubscribe from App Dev' pop up is displayed AppDev");
			Assert.assertEquals(GenericMethods.getText(tLoc.mdlUnsubscribeAppDev),string);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("Verify {string} pop up is displayed")
	public void verify_pop_up_is_displayed(String string) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify 'Are you sure you want to unsubscribe from ABM' pop up is displayed");
			Assert.assertEquals(GenericMethods.getText(tLoc.mdlUnsubscribeABM),string);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("Verify {string}  {string} button is displayed on the pop up window")
	public void verify_button_is_displayed_on_the_pop_up_window(String string, String string2) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify 'Cancel'  'Unsubscribe' button is displayed on the pop up window");
			Assert.assertEquals(GenericMethods.getText(tLoc.btnmdlUnsubscribe),string2);
			Assert.assertEquals(GenericMethods.getText(tLoc.btnCancel),string);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@When("we click on cancel button")
	public void we_click_on_cancel_button() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"we click on cancel button");
		GenericMethods.clickByWebElement(tLoc.btnCancel);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("user should be navigated to topics subscription page")
	public void user_should_be_navigated_to_topics_subscription_page() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user should be navigated to topics subscription page");
	GenericMethods.isElementDisplayed(tLoc.lblTopicSubscription);	
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	@Then("{string} topic should be displayed on the subscription page")
	public void topic_should_be_displayed_on_the_subscription_page(String string) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"' ABM' topic should be displayed on the subscription page");
		Assert.assertEquals(GenericMethods.getText(tLoc.lblABM),string);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}

	@When("we click on {string} button")
	public void we_click_on_button(String string) throws IOException, InterruptedException, AssertionError {
	try {
		logtoreport = scene_def.createNode(new GherkinKeyword("And"),
				"we click on 'Unsubscribe' button");
	GenericMethods.clickByWebElement(tLoc.btnmdlUnsubscribe);
} catch (Exception ex) {
	ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
}
}
	@Then("verify pop up window should be displayed as {string}")
	public void verify_pop_up_window_should_be_displayed_as(String string) throws IOException, InterruptedException, AssertionError {
	try {
		logtoreport = scene_def.createNode(new GherkinKeyword("And"),
				"verify pop up window should be displayed as 'You have successfully unsubscribed'");
		GenericMethods.waitForElementVisiblity(tLoc.mdlUnSubscriptionSuccess, 10);
	Assert.assertTrue(GenericMethods.isElementDisplayed(tLoc.mdlUnSubscriptionSuccess));
} catch (Exception ex) {
	ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
}
}
	@When("verify {string} link is displayed on the pop up window")
	public void verify_link_is_displayed_on_the_pop_up_window(String string) throws IOException, InterruptedException, AssertionError {
	try {
		logtoreport = scene_def.createNode(new GherkinKeyword("And"),
				"verify 'Click here' link is displayed on the pop up window");
		GenericMethods.waitForElementVisiblity(tLoc.linkClickHere, 10);
		Assert.assertTrue(GenericMethods.isElementDisplayed(tLoc.linkClickHere));
} catch (Exception ex) {
	ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
}
}
	@When("we click on {string} link a pop up page should be displayed")
	public void we_click_on_link_a_pop_up_page_should_be_displayed(String string) throws IOException, InterruptedException, AssertionError {
	try {
		logtoreport = scene_def.createNode(new GherkinKeyword("And"),
				"we click on 'click here ' link a pop up page should be displayed");
	GenericMethods.clickByWebElement(tLoc.linkClickHere);
} catch (Exception ex) {
	ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
}
}
	@Then("verify pop page as {string} page is displayed")
	public void verify_pop_page_as_page_is_displayed(String string) throws IOException, InterruptedException, AssertionError {
	try {
		logtoreport = scene_def.createNode(new GherkinKeyword("And"),
				"verify pop page as 'Subscribe to new topics' page is displayed");
	Assert.assertEquals(GenericMethods.getText(tLoc.lblSubsciptionPopup),string);
} catch (Exception ex) {
	ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
}
}
	@Then("we Unsubscribe from all Subscribed topics")
	public void we_unsubscribe_from_all_subscribed_topics(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"we Unsubscribe from all Subscribed topics");
			GenericMethods.clickByWebElement(tLoc.btnCancel);
			
			List<String> data = dataTable.values();
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).equalsIgnoreCase("Account management"))
					if(GenericMethods.isElementPresent(By.xpath("//h1[text()='Account Management']"))) {					
				    GenericMethods.clickByWebElement(tLoc.btnThreeDotsAM);
				    GenericMethods.clickByWebElement(tLoc.btnUnsubscribe);
				    GenericMethods.clickByWebElement(tLoc.btnmdlUnsubscribe);
				    GenericMethods.clickByWebElement(tLoc.btnCloseWindow);
					}	
				if (data.get(i).equalsIgnoreCase("Accounts payable"))
					if(GenericMethods.isElementPresent(By.xpath("//h1[text()='Accounts Payable']"))) {					
				    GenericMethods.clickByWebElement(tLoc.btnThreeDotsAP);
				    GenericMethods.clickByWebElement(tLoc.btnUnsubscribe);
				    GenericMethods.clickByWebElement(tLoc.btnmdlUnsubscribe);
				    GenericMethods.clickByWebElement(tLoc.btnCloseWindow);
					}	
				if (data.get(i).equalsIgnoreCase("Accounts Receivable"))
					if(GenericMethods.isElementPresent(By.xpath("//h1[text()='Accounts Receivable']"))) {					
				    GenericMethods.clickByWebElement(tLoc.btnThreeDotsAR);
				    GenericMethods.clickByWebElement(tLoc.btnUnsubscribe);
				    GenericMethods.clickByWebElement(tLoc.btnmdlUnsubscribe);
				    GenericMethods.clickByWebElement(tLoc.btnCloseWindow);
					}	
				if (data.get(i).equalsIgnoreCase("Anti Virus"))
					if(GenericMethods.isElementPresent(By.xpath("//h1[text()='Anti-Virus']"))) {					
				    GenericMethods.clickByWebElement(tLoc.btnThreeDotsAV);
				    GenericMethods.clickByWebElement(tLoc.btnUnsubscribe);
				    GenericMethods.clickByWebElement(tLoc.btnmdlUnsubscribe);
				    GenericMethods.clickByWebElement(tLoc.btnCloseWindow);
					}	
				if (data.get(i).equalsIgnoreCase("ABM"))
					if(GenericMethods.isElementPresent(By.xpath("//h1[text()='ABM']"))) {					
				    GenericMethods.clickByWebElement(tLoc.btnThreeDots);
				    GenericMethods.clickByWebElement(tLoc.btnUnsubscribe);
				    GenericMethods.clickByWebElement(tLoc.btnmdlUnsubscribe);
				    GenericMethods.clickByWebElement(tLoc.btnCloseWindow);
					}	
					
			}
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}	

}
