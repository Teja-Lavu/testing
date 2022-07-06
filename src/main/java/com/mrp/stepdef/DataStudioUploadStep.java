package com.mrp.stepdef;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.github.dockerjava.api.model.Driver;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.DataStudioUploadActions;
import com.mrp.pageObjects.locators.CompanySwitcherLocators;
import com.mrp.pageObjects.locators.CustomerHomePageLocators;
import com.mrp.pageObjects.locators.DataStudioUploadLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataStudioUploadStep extends ReportManager {

	DataStudioUploadActions dsuActions;
	DataStudioUploadLocators dsuLocators;
	CustomerHomePageLocators customerHomePageLocators;
	String dynamic_listname;
	CompanySwitcherLocators csuLoc;
	SoftAssert softassert = new SoftAssert();
	String dynamic_companyname = CreateCompanyStep.dynamic_companyname;
	ExtentTest logtoreport = null;
	Assertion assertion = new Assertion();
	String latestCompany;

	public DataStudioUploadStep() {
		this.dsuActions = new DataStudioUploadActions();
		this.customerHomePageLocators = new CustomerHomePageLocators();
		PageFactory.initElements(DriverManager.getDriver(), this.dsuActions);
		PageFactory.initElements(DriverManager.getDriver(), this.customerHomePageLocators);
	}

	@Given("User Clicks on DataStudio")
	public void user_clicks_on_data_studio() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"User Clicks on DataStudio");
        WaitUtils.waitForElementVisiblity(customerHomePageLocators.dataStudio, 5);
        GenericMethods.clickByWebElement(dsuLocators.dataStudio);
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
		}

	@And("User clicks on Create List")
	public void user_clicks_on_create_list() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"User clicks on Create List");
			
		GenericMethods.clickByWebElement(customerHomePageLocators.createlist);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
		
	}

	@And("User select Account List and continue")
	public void user_select_account_list_and_continue() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"User select Account List and continue");
		dsuActions.clickAccountList();
		WaitUtils.waitForElementToEnable(dsuLocators.Continue, 5);
		//GenericMethods.clickByWebElement(dsuLocators.Continue);
		dsuActions.clickContinue();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
		
	}

	@And("User select Upload file and continue")
	public void user_select_upload_file_and_continue() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"User select Upload file and continue");
		dsuActions.clickUploadfile();
		WaitUtils.waitForElementToEnable(dsuLocators.Continue, 5);

		dsuActions.clickContinue();
		
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("User select document to upload and continue")
	public void user_select_document_to_upload_and_continue() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"User select document to upload and continue");
		dsuLocators.file
				.sendKeys(System.getProperty("user.dir") + "/src/test/resources/Files/3m_hq_upload_test.csv");
		WaitUtils.waitForElementToEnable(dsuLocators.Continue, 5);
		dsuActions.clickContinue();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}

	@And("User Enter List name as {string} and Finish")
	public void user_enter_list_name_as_and_finish(String listName) throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"User Enter List name as {string} and Finish");
		dynamic_listname = listName + "_" + System.currentTimeMillis();
		dsuActions.fillListName(dynamic_listname);
		GenericMethods.FillByWebElement_sendkeys(dsuLocators.fileName, "0");
		String temp = dsuLocators.fileName.getText();
		WaitUtils.waitForTextVisible(dsuLocators.fileName, 2, temp);
		dsuLocators.fileName.sendKeys(Keys.BACK_SPACE);
		WaitUtils.waitForElementToEnable(dsuLocators.btnFinish, 5);
		dsuActions.clickbtnFinish();
		Thread.sleep(2000);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("User go back to all lists")
	public void user_go_back_to_all_lists() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"User go back to all lists");
		WaitUtils.waitForElementVisiblity(dsuLocators.txtFileCreated, 5);
		dsuActions.clickAllLists();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("Verify if a list is created")
	public void verify_if_a_list_is_created() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"),
					"Verify if a list is created");
		DriverManager.getDriver().navigate().refresh();
		Thread.sleep(4000);
		WebElement resultLoc = DriverManager.getDriver().findElement(By.xpath("//a[text()='" + dynamic_listname + "']"));
		String result = resultLoc.getText();

		assertEquals(dynamic_listname, result);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	@Given("user clicks on Go Back")
	public void user_clicks_on_go_back() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"user clicks on Go Back");
		dsuActions.clickbtnGoBack();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Given("check if the Discover prelytic data module is enabled")
	public void check_if_the_discover_prelytic_data_module_is_enabled() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"check if the Discover prelytic data module is enabled");
		
		GenericMethods.isClickable(dsuLocators.discoverPrelytix);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	@Given("check user able to click on finish button without giving listname")
	public void check_user_able_to_click_on_finish_button_without_giving_listname() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"check user able to click on finish button without giving listname");
		GenericMethods.isClickable(dsuLocators.btnFinish);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Given("Search for the file in searchbar")
	public void search_for_the_file_in_searchbar() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"Search for the file in searchbar");
		DriverManager.getDriver().navigate().refresh();
		WaitUtils.waitForElementVisiblity(dsuLocators.txtSearch, 5);
		GenericMethods.FillByWebElement(dsuLocators.txtSearch, dynamic_listname);
		WebElement resultLoc = DriverManager.getDriver().findElement(By.xpath("//a[text()='" + dynamic_listname + "']"));
		WaitUtils.waitForElementVisiblity(resultLoc, 5);
		String result = resultLoc.getText();
		assertEquals(dynamic_listname, result);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	@And("User select continue")
	public void user_select_continue() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"User select continue");
			GenericMethods.clickByWebElement(dsuLocators.Continue);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	@Given("User Enter List name as {string} and click Finish")
	public void user_enter_list_name_as_and_click_finish(String listName) throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"User Enter List name as {string} and click Finish");		
		dsuActions.fillListName(listName);
		dsuLocators.fileName.sendKeys(Keys.BACK_SPACE);
		dsuActions.clickbtnFinish();
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}

	@Given("User should see validation message {string}")
	public void user_should_see_validation_message(String msgName) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"User should see validation message {string}");	
		WaitUtils.waitForElementVisiblity(dsuLocators.msgListName, 5);
		softassert.assertEquals(GenericMethods.getText(dsuLocators.msgListName),msgName );	
	} catch (Exception ex) {

		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}

	@Then("user verify the file have accounts and locations")
	public void user_verify_the_file_have_accounts_and_locations() throws InterruptedException, IOException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"user verify the file have accounts and locations");	
		Thread.sleep(300000);

		DriverManager.getDriver().navigate().refresh();
		GenericMethods.waitForElementVisiblity(dsuLocators.nmbrAccounts, 20);
//		assertion.assertNotEquals(GenericMethods.getText(dsuLocators.nmbrAccounts), "Pending");
		Assert.assertFalse((GenericMethods.getText(dsuLocators.nmbrAccounts)!= "Pending"), "List does not build");
//	    assertion.assertNotEquals(GenericMethods.getText(dsuLocators.nmbrLocations), "Pending");
		} catch (Exception|AssertionError ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user click on list")
	public void user_click_on_list() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"user click on list");	
	    DriverManager.getDriver().findElement(By.xpath("//a[text()='"+dynamic_listname+"']")).click();
		} catch (Exception|AssertionError ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("user should be navigated to Accounts page")
	public void user_should_be_navigated_to_accounts_page() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"user should be navigated to Accounts page");	
	
	    GenericMethods.waitForElementVisiblity(dsuLocators.txtAccounts, 10);
	    GenericMethods.isElementDisplayed(dsuLocators.txtAccounts);
		} catch (Exception|AssertionError ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("user should see accounts")
	public void user_should_see_accounts() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"user should see accounts");	
	
		GenericMethods.waitForElementVisiblity(dsuLocators.tblAccounts, 60);
	    GenericMethods.isElementDisplayed(dsuLocators.tblAccounts);
		} catch (Exception|AssertionError ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}	
	
	@When("select the company to switch")
	public void select_the_company_to_switch() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"select the company to switch");	
	
	   GenericMethods.clickByWebElement(dsuLocators.selectCompamy);
		} catch (Exception|AssertionError ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	@Then("user should be redirected to company selected for DataStudio")
	public void user_should_be_redirected_to_company_selected_for_data_studio() throws IOException, InterruptedException, AssertionError{
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"user should be redirected to company selected for DataStudio");	
	
	    GenericMethods.clickByWebElement(csuLoc.btnUserLogo);
	    Thread.sleep(2000);
	    DriverManager.getDriver().findElement(By.xpath("//span[text()='RajyaTest_1652207810151' or text()='QA Company']]"));
		} catch (Exception|AssertionError ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

}
