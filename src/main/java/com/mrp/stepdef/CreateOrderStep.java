package com.mrp.stepdef;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.CreateOrderActions;
import com.mrp.pageObjects.actions.LoginPageActions;
import com.mrp.pageObjects.locators.AdminUsermanagementLocators;
import com.mrp.pageObjects.locators.CreateCompanyLocators;
import com.mrp.pageObjects.locators.CreateOrderLocators;
import com.mrp.pageObjects.locators.LoginLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateOrderStep extends ReportManager {

	CreateOrderActions coa = new CreateOrderActions();
	CreateOrderLocators col = new CreateOrderLocators();
	LoginPageActions lpa = new LoginPageActions();
	LoginLocators ll = new LoginLocators();
	AdminUsermanagementLocators aul = new AdminUsermanagementLocators();
	SoftAssert softassert = new SoftAssert();
	String orderName;
	ExtentTest loginfo = null;
	ExtentTest logtoreport = null;
	
	
	public CreateOrderStep() {
		 this.coa = new CreateOrderActions();
		 this.col= new CreateOrderLocators();
		 this.aul=new AdminUsermanagementLocators();
				PageFactory.initElements(DriverManager.getDriver(),this.coa);
				PageFactory.initElements(DriverManager.getDriver(),this.col);
				PageFactory.initElements(DriverManager.getDriver(),this.aul);
	}


	  @Given("User is on dashboard page") 
	  public void user_is_on_dashboard_page() throws IOException, InterruptedException {
	  try {
		  loginfo = scene_def.createNode(new GherkinKeyword("And"),
	  "User is on dashboard logged");
		  GenericMethods.waitForElementVisiblity(col.admin, 30);	
		  coa.clickAdminMenu(); } 
	  catch  (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
			}
	  }
	  
	  @When("User will click Admin")
	  public void user_will_click_admin() throws InterruptedException, IOException {
		  try {
		  Thread.sleep(5000);
		  loginfo = scene_def.createNode(new GherkinKeyword("And"),
				  "User will click Admin"); 
		    WaitUtils.waitForElementVisiblity(col.admin, 10);
			GenericMethods.clickByWebElement(col.admin);
		  } 
		  catch  (Exception ex) {

				ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
				}
	  }


	@And("User will click Budgeting")
	public void user_will_click_budgeting() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					  "User will click Budgeting"); 
		WaitUtils.waitForElementVisiblity(col.budgeting, 10);		
		coa.clickBudgeting();
		} 
		  catch  (Exception ex) {

				ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
				}
	}

	@And("User will Click Create New Order Button")
	public void user_will_click_create_new_order_button() throws IOException, InterruptedException {	
		try {
			  loginfo = scene_def.createNode(new GherkinKeyword("And"),
					  "User will Click Create New Order Button"); 
			WaitUtils.waitForElementVisiblity(col.createNew, 10);
		coa.clickCreateNew();
		} 
		  catch  (Exception ex) {

				ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
				}
	}

	@Then("User should see New Purchase Order page")
	public void user_should_see_new_purchase_order_page() throws IOException, InterruptedException {
		try {
		WaitUtils.waitForElementVisiblity(col.NewPurchareOrderTitle,10);
	
		  loginfo = scene_def.createNode(new GherkinKeyword("And"),
				  "User should see New Purchase Order page"); 
		coa.newPurchaseOrderTitle();
	} 
	  catch  (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
			Reporter.log(ex.toString());
			}
	}

	@And("User will enter Name with {string}")
	public void user_will_enter_name_with(String name) throws InterruptedException, IOException {
		try {
			  loginfo = scene_def.createNode(new GherkinKeyword("And"),
					  "User will enter Name with name"); 
		orderName = name + "_" + System.currentTimeMillis();
		WaitUtils.waitForElementVisiblity(col.name,10);
		GenericMethods.FillByWebElement_sendkeys(col.name, orderName);		 
		col.name.sendKeys(Keys.TAB);
		} 
		  catch  (Exception ex) {

				ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
				}
	}

	@And("User will enter Cost with {string}")
	public void user_will_enter_cost_with(String cost) throws InterruptedException, IOException {
		try {
			  loginfo = scene_def.createNode(new GherkinKeyword("And"),
					  "User will enter Cost with cost"); 
		WaitUtils.waitForElementVisiblity(col.cost,10);
		coa.fillCost(cost);
		col.cost.sendKeys(Keys.TAB);
		} 
		  catch  (Exception ex) {

				ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
				}
	}

	@When("User Clears the entered values")
	public void user_clears_the_entered_values() throws IOException, InterruptedException {
		try {
			  loginfo = scene_def.createNode(new GherkinKeyword("And"),
					  "User Clears the entered values"); 
		GenericMethods.clearInput(col.name);
		GenericMethods.clearInput(col.cost);
		} 
		  catch  (Exception ex) {

				ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
				}
	}

	@Then("User get the validation messages")
	public void user_get_the_validation_messages() throws IOException, InterruptedException {
		try {
			  loginfo = scene_def.createNode(new GherkinKeyword("And"),
					  "User get the validation messages"); 
		softassert.assertEquals(GenericMethods.getText(CreateOrderLocators.Name_validation_error_message), "Name is required.");
		softassert.assertEquals(GenericMethods.getText(CreateOrderLocators.cost_validation_error_message), "Cost is required.");
		} 
		  catch  (Exception ex) {

				ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
				}
		}

	@Given("User is on new Purchase Order page")
	public void user_is_on_new_purchase_order_page() throws IOException, InterruptedException {
		try {
			  loginfo = scene_def.createNode(new GherkinKeyword("And"),
					  "User is on dashboard logged"); 
		coa.newPurchaseOrderTitle();
		} 
		  catch  (Exception ex) {

				ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
				}
	}

	@And("User will enter External Source ID {string}")
	public void user_will_enter_external_source_id(String externalSourceId) throws InterruptedException, IOException {
		try {
			  loginfo = scene_def.createNode(new GherkinKeyword("And"),
					  "User will enter External Source ID"); 
		WaitUtils.waitForElementVisiblity(col.externalSourceID,10);
		coa.fillExternalSourceId(externalSourceId);
		} 
		  catch  (Exception ex) {

				ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
				}
	}

	@And("user will enter Date Ranges {string}")
	public void user_will_enter_date_ranges(String dateRangeStart) throws InterruptedException, IOException {
		try {
			  loginfo = scene_def.createNode(new GherkinKeyword("And"),
					  "user will enter Date Ranges"); 
		WaitUtils.waitForElementVisiblity(col.dateRangeStart,10);
		GenericMethods.select_to_and_fro_date(dateRangeStart);
		col.dateRangeStart.sendKeys(Keys.TAB);
		} 
		  catch  (Exception ex) {

				ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
				}
	}

	@And("User will enter Margin {string}")
	public void user_will_enter_margin(String margin) throws InterruptedException, IOException {
		try {
			  loginfo = scene_def.createNode(new GherkinKeyword("And"),
					  "User will enter Margin"); 
		WaitUtils.waitForElementVisiblity(col.margin,10);
		coa.fillMargin(margin);
		} 
		  catch  (Exception ex) {

				ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
				}
	}

	@When("User will Click Save Button")
	public void user_will_click_save_button() throws InterruptedException, IOException {
		try {
			  loginfo = scene_def.createNode(new GherkinKeyword("And"),
					  "User will Click Save Button"); 
		WaitUtils.waitForElementVisiblity(col.save,10);
		coa.clickSave();
		} 
		  catch  (Exception ex) {

				ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
				}
	}

	@Then("New Purchase Order should be created")
	public void new_purchase_order_should_be_created() throws InterruptedException, IOException {
		try {
			  loginfo = scene_def.createNode(new GherkinKeyword("And"),
					  "New Purchase Order should be created"); 
		WaitUtils.waitForElementVisiblity(col.searchbar, 5);
		GenericMethods.FillByWebElement_sendkeys(col.searchbar, orderName);	
		Thread.sleep(5000);
		GenericMethods.FillByWebElement_sendkeys(col.searchbar, "0");
	 	String temp = col.searchbar.getText();
	 	WaitUtils.waitForTextVisible(col.searchbar, 2, temp);
	 	col.searchbar.sendKeys(Keys.BACK_SPACE);
	 	WaitUtils.waitForTextVisible(col.searchResult, 10,orderName);
	 	String actual = col.searchResult.getText();
		System.out.println("Dynamic comapany name retireved : " + actual);
		assertEquals(actual,orderName); 
		} 
		  catch  (Exception ex) {

				ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
				}
	}
}
