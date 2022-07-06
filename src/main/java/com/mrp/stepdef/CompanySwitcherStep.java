package com.mrp.stepdef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mrp.pageObjects.locators.CompanySwitcherLocators;
import com.mrp.pageObjects.locators.CustomerHomePageLocators;
import com.mrp.report.ReportManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.CompanySwitcherActions;
import com.mrp.pageObjects.actions.DataStudioUploadActions;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompanySwitcherStep extends ReportManager {

	CompanySwitcherLocators csl;
	CompanySwitcherActions csa;
	ExtentTest logtoreport =null;
	
	public CompanySwitcherStep() {
		this.csa = new CompanySwitcherActions();
		this.csl = new CompanySwitcherLocators();
		PageFactory.initElements(DriverManager.getDriver(), this.csl);
		PageFactory.initElements(DriverManager.getDriver(), this.csa);
	}

	@When("user Clicks on user logo button")
	public void user_clicks_on_user_logo_button() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "user Clicks on user logo button");
			GenericMethods.clickByWebElement(csl.btnUserLogo);
		} catch (Exception ex) {
			
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);

		}
	}

	@Then("Switch company drop down should be displayed")
	public void switch_company_drop_down_should_be_displayed() throws InterruptedException, IOException {
       try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"),
					"Switch company drop down should be displayed");
			WaitUtils.waitForElementVisiblity(csl.lblCompany, 15);
			csl.lblCompany.isDisplayed();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the default company which is displayed")
    public void verify_the_default_company_which_is_displayed()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"),
					"verify the default company which is displayed");
			if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
			WaitUtils.waitForElementVisiblity(csl.txtCompanyMRP, 5);
			Assert.assertEquals(GenericMethods.getText(csl.txtCompanyMRP), "Vandelar");
			}else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {				
			WaitUtils.waitForElementVisiblity(csl.txtCompanyMRP, 5);
			Assert.assertEquals(GenericMethods.getText(csl.txtCompanyMRP), "MRP");
			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}

	@When("user clicks on switch company drop down")
	public void user_clicks_on_switch_company_drop_down() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"user clicks on switch company drop down");
			GenericMethods.clickByWebElement(csl.drpCompany);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}	

	@When("user selects a company from the Switch drop down")
	public void user_selects_a_company_from_the_switch_drop_down(io.cucumber.datatable.DataTable company)
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"user selects a company from the Switch drop down");			
			csa.selectCompany();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}

	@Then("a pop up message should be displayed")
	public void a_pop_up_message_should_be_displayed() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"),
					"a pop up message should be displayed");	
			csl.popupcompany.isDisplayed();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the text on the modal window")
	public void verify_the_text_on_the_modal_window(io.cucumber.datatable.DataTable message)
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"),
					"verify the text on the modal window");
			String popupmessage = csl.msgpopupcompany.getText();
			Assert.assertEquals(popupmessage, message.values().get(0));
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user clicks on yes button")
	public void user_clicks_on_yes_button() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"user clicks on yes button");
			csa.clickYes();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("Page should be redirected to selected account page")
	public void page_should_be_redirected_to_selected_account_page(io.cucumber.datatable.DataTable company)
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"),
					"Page should be redirected to selected account page");
			if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
			Assert.assertEquals(csl.txtCompanyQTC.getText(), company.values().get(0));}
			else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {	
				Assert.assertEquals(csl.txtCompanyQTC.getText(), company.values().get(1));}			
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("user clicks on no button")
	public void user_clicks_on_no_button() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"),
					"user clicks on no button");
			GenericMethods.clickByWebElement(csl.drpCompany);
			WaitUtils.waitForElementVisiblity(csl.company123, 5);
			GenericMethods.clickByWebElement(csl.company123);
			WaitUtils.waitForElementVisiblity(csl.popupcompany, 5);
			GenericMethods.isElementDisplayed(csl.popupcompany);
			WaitUtils.waitForElementVisiblity(csl.btnNo, 5);
			Thread.sleep(2000);
			GenericMethods.clickByWebElement(csl.btnNo);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("page should not be redirected and should stay on previous account")
	public void page_should_not_be_redirected_and_should_stay_on_previous_account(
			io.cucumber.datatable.DataTable company) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"),
					"page should not be redirected and should stay on previous account");
			if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
			Assert.assertEquals(csl.txtCompanyQTC.getText(), company.values().get(0));}
		else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {	
			Assert.assertEquals(csl.txtCompanyQTC.getText(), company.values().get(1));}		
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}
}
