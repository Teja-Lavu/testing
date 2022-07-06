package com.mrp.stepdef;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.LoginPageActions;
import com.mrp.pageObjects.locators.LoginLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.GetConfigProperties;
import com.mrp.utils.WaitUtils;

import io.cucumber.java.en.*;
import io.cucumber.datatable.*;

public class LoginPageStep extends ReportManager{


	LoginPageActions lpa = new LoginPageActions();
	LoginLocators ll = new LoginLocators();
	ExtentTest logtoreport = null;
	
	@Given("user on the Admin Login Page")
	public void user_on_the_admin_login_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user on the Login Page");
		GenericMethods.openUrl(GetConfigProperties.getPropValue("AdminbaseURL"));
	}catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}

	@Given("user on the Login Page")
	public void user_on_the_login_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user on the Login Page");
		GenericMethods.openUrl(GetConfigProperties.getPropValue("baseURL"));
	}catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}

	@And("user enters email address")
	public void user_enters_email_address(DataTable userName) throws InterruptedException, IOException {	
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user enters email address");
		lpa.fillUserName(userName.values().get(0));
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}

	@And("user enters password")
	public void user_enters_password(DataTable password) throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user enters password");
		lpa.fillPassword(password.values().get(0));
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}

	@When("user logs in successfully")
	public void user_logs_in_successfully() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user logs in successfully");
		lpa.Login(GetConfigProperties.getPropValue("CUserName"),GetConfigProperties.getPropValue("CPassword"));
		} catch (StaleElementReferenceException ex) {

			lpa.Login(GetConfigProperties.getPropValue("CUserName"),GetConfigProperties.getPropValue("CPassword"));

		
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}

	@Then("user should login successfully and land on Home page")
	public void user_should_login_successfully_and_land_on_home_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user should login successfully and land on Home page");
			GenericMethods.waitForElementVisiblity(ll.userLogo, 5);
		Assert.assertEquals(GenericMethods.isElementDisplayed(ll.userLogo),true);	
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	
	@Then("user should login successfully and land on Customer Home page")
	public void user_should_login_successfully_and_land_on_customer_home_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user should login successfully and land on Home page");
			GenericMethods.waitForElementVisiblity(ll.userCustLogo, 5);
		Assert.assertEquals(GenericMethods.isElementDisplayed(ll.userCustLogo),true);	
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}

	@Then("error message is displayed for invalid credentials")
	public void error_message_is_displayed_for_invalid_credentials(DataTable data) throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"error message is displayed for invalid credentials");
		String errorMessage = DriverManager.getDriver().findElement(By.xpath("html/body/div[1]/div/div[2]//p[@id=\"loginErrorMessage\"]")).getText();;
		Assert.assertEquals(errorMessage,data.values().get(0));
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	
	@Then("error message is displayed for empty credentials")
	public void error_message_is_displayed_for_empty_credentials(DataTable data) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"error message is displayed for empty credentials");
		Assert.assertEquals(GenericMethods.getText(ll.invalidCredentialsErrorMessage),data.values().get(0));
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	
	@And("user clicks the sign in button")
	public void user_clicks_the_sign_in_button() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user clicks the sign in button");
		lpa.clickLoginButton();
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}

	@When("user Logout from the Application")
	public void user_log_out_from_the_application() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user Logout from the Application");
			lpa.clicklogOutbtn();
		} catch (StaleElementReferenceException ex) {
			lpa.clicklogOutbtn();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	@Then("user Logs out from the Customer Application")
	public void user_logs_out_from_the_customer_application() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user Logout from the Customer Application");
			GenericMethods.clickByWebElement(ll.userCustLogo);
			GenericMethods.waitForElementVisiblity(ll.btnLogout, 15);
		    GenericMethods.clickByWebElement(ll.btnLogout);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	@When("user clicks on forgot password")
	public void user_clicks_on_forgot_password() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user clicks on forgot password");
		GenericMethods.clickByWebElement(ll.ForgotPassword);
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	
	@Then("user should be redirected to forgot password page")
	public void user_should_be_redirected_to_forgot_password_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user should be redirected to forgot password page");
		Assert.assertEquals(GenericMethods.isElementDisplayed(ll.btnResetPassword), true, "Forgot password page is not displayed");
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	
	@And("click on reset password button")
	public void click_on_reset_password_button() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "click on reset password button");
			GenericMethods.clickByWebElement(ll.btnResetPassword);
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	
	@Then("user should be redirected to reset password page")
	public void user_should_be_redirected_to_reset_password_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"), "user should be redirected to reset password page");
		GenericMethods.isElementDisplayed(ll.btnChangePassword);
		Assert.assertEquals(GenericMethods.isElementDisplayed(ll.btnChangePassword), true, "Reset password page is not displayed");
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	
	@When("user enters email address to reset password")
	public void user_enters_email_address_to_reset_password(io.cucumber.datatable.DataTable email) throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user enters email address to reset password");
		
			lpa.fillEmail(email.values().get(0));

	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}


}
