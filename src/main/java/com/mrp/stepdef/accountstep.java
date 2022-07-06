package com.mrp.stepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.AccountActions;
import com.mrp.pageObjects.locators.AccountLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class accountstep extends ReportManager {

	AccountActions AccntActions;
	AccountLocators AccntLctrs;
	ExtentTest logtoreport = null;

	public accountstep() {
		this.AccntActions = new AccountActions();
		PageFactory.initElements(DriverManager.getDriver(), this.AccntActions);
	}

	@And("verify functionality of search bar with {string}")
	public void verify_functionality_of_search_bar_with(String search) throws InterruptedException, IOException {

		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"verify functionality of search bar with {string}");
			GenericMethods.select_search_sort_duration(1, search);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("Verify all the input fields are visible and selectable in sort by with {string}")
	public void verify_all_the_input_fields_are_visible_and_selectable_in_sort_by_with(String sortBy)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify all the input fields are visible and selectable in sort by with {string}");

			GenericMethods.select_search_sort_duration(2, sortBy);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("Verify all time periods are visible and selectable with {string}")
	public void verify_all_time_periods_are_visible_and_selectable_with(String timePeriod)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"Verify all time periods are visible and selectable with {string}");

			GenericMethods.select_search_sort_duration(3, timePeriod);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("click apply filter")
	public void click_apply_filter() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "click apply filter");
			try {
				GenericMethods.waitForElementToEnable(AccntLctrs.applyFilter, 15);
			AccntActions.clickApplyFilter();
		} catch (StaleElementReferenceException ex) {

			AccntActions.clickApplyFilter();
		}
			
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("clear filter values")
	public void clear_filter_values() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "clear filter values");

			AccntActions.clickClearAll();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("Add filter")
	public void add_filter() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "Add filter");

			AccntActions.clickAddFilter();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("delete added filter")
	public void delete_added_filter() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "delete added filter");

			AccntActions.clickDeleteFilter();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("click hide filter")
	public void click_hide_filter() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "click hide filter");

			AccntActions.clickHideFilter();

		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("click view filter")
	public void click_view_filter() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "click view filter");
			AccntActions.clickViewFilter();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}

	@Given("User is on account page")
	public void user_is_on_account_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "User is on account page");
			AccntActions.clickAccounts();
			try {
				AccntActions.clickViewFilter();
			} catch (StaleElementReferenceException e) {
				AccntActions.clickViewFilter();
			}
			 
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("User selects criteria")
	public void user_selects_criteria(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "User selects criteria");
			List<List<String>> data = dataTable.asLists(String.class);
			int criteria_size = data.size();
			int j = 2;
			for (int i = 0; i < data.size(); i++) {

				String field = data.get(i).get(0);
				String Condition = data.get(i).get(1);
				String Values = data.get(i).get(2);
				GenericMethods.select_field_conditions(logtoreport, j, "Field", field,1);
				GenericMethods.select_field_conditions(logtoreport, j, "Condition", Condition,2);
				Thread.sleep(6000);
				
				GenericMethods.select_multiselect_value(logtoreport, j, "Values", Values);

				if (criteria_size > 1) {
					System.out.println("//click on plus icon");
					DriverManager.getDriver().findElement(By.xpath("//div/div/div[" + j + "]/div[4]//button[1]"))
							.click();
					j++;
					Thread.sleep(5000);
				}
				criteria_size--;
			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("Print number of record")
	public void print_number_of_record() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "Print number of record");
			WaitUtils.waitForElementVisiblity(AccntLctrs.listResult, 60);
			String[] paginationno = null;
			String actualPageNo;
			int getpaginationnoint;
			String paginationnumber = AccntLctrs.lastpageno.getText();
			String[] getpaginationno = paginationnumber.split(" ");
			if (getpaginationno[1].contains(",")) {
			paginationno = getpaginationno[1].split(",");
			actualPageNo = paginationno[0] + paginationno[1];
			getpaginationnoint = Integer.parseInt(actualPageNo);
			}
			else {
		    getpaginationnoint = Integer.parseInt(getpaginationno[1]);
			}			
			List<WebElement> result = DriverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
			System.out.println("Number  of records displayed based on search criteria : " + result.size());
			int semitotal = (getpaginationnoint - 1) * (result.size());
			System.out.println(semitotal);
			GenericMethods.clickByWebElement(AccntLctrs.lastPage);
			List<WebElement> lresult = DriverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
			System.out.println("Number of records displayed based on search criteria on last page: " + lresult.size());
			int total = semitotal + lresult.size();
			System.out.println("Number  of total records displayed based on search criteria:" + total);
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}

	@Given("User clicks on Save Filter")
	public void user_clicks_on_save_filter() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "User clicks on Save Filter");
			
			GenericMethods.clickByWebElement(AccntLctrs.btnSaveFilter);
			
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
	
	@Given("User Should see the popup to enter Filter name")
	public void user_should_see_the_popup_to_enter_filter_name() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "User Should see the popup to enter Filter name");
			
			GenericMethods.waitForElementVisiblity(AccntLctrs.iptEnterFilter, 10);
			
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
	
	@Given("User enter Filter Name as {string}")
	public void user_enter_filter_name_as(String filterName) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "User enter Filter Name as ");
			GenericMethods.clickByWebElement(AccntLctrs.iptEnterFilter);
			String dynamic_name = filterName + "_" + System.currentTimeMillis();
			GenericMethods.FillByWebElement(AccntLctrs.iptEnterFilter, dynamic_name);
			GenericMethods.FillByWebElement_sendkeys(AccntLctrs.iptEnterFilter, "0");
			AccntLctrs.iptEnterFilter.sendKeys(Keys.BACK_SPACE);
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
	
	@Given("User Clicks Save and Apply filter Button")
	public void user_clicks_save_and_apply_filter_button() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "User Clicks Save and Apply filter Button");
			
			GenericMethods.clickByWebElement(AccntLctrs.btnSaveAndApplyFilter);
			
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
	
	@When("user select an account from list")
	public void user_select_an_account_from_list() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user select an account from list");
			
			GenericMethods.waitForElementVisiblity(AccntLctrs.btnArrow,10);
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
	
	@Given("click on arrow")
	public void click_on_arrow() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "click on arrow");
			
			GenericMethods.clickByWebElement(AccntLctrs.btnArrow);
			
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
	
	@Then("user should see a table containing")
	public void user_should_see_a_table_containing(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user should see a table containing");
			List<String> data = dataTable.values();
			
			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).equalsIgnoreCase("Location"))
					GenericMethods.waitForElementVisiblity(AccntLctrs.textLocation, 15);
				AccntLctrs.textLocation.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Score + Topics"))
					GenericMethods.waitForElementVisiblity(AccntLctrs.textScoteTopic, 15);
				AccntLctrs.textScoteTopic.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Address"))
					GenericMethods.waitForElementVisiblity(AccntLctrs.textAddress, 15);
				AccntLctrs.textAddress.isDisplayed();
			
			}
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
	
	@When("user cliks on location")
	public void user_cliks_on_location() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user cliks on location");
			
			GenericMethods.clickByWebElement(AccntLctrs.linkLocation);
			
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
	
	@Then("user should be redirected to Account Intelligence page")
	public void user_should_be_redirected_to_account_intelligence_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user should be redirected to Account Intelligence page");
			
			GenericMethods.waitForElementVisiblity(AccntLctrs.tabIntelligence, 10);
            GenericMethods.isElementDisplayed(AccntLctrs.tabIntelligence);
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
	
	@When("user click on Export button")
	public void user_click_on_export_button() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user click on Export button");
			
			GenericMethods.waitForElementVisiblity(AccntLctrs.btnExport, 10);
			GenericMethods.clickByWebElement(AccntLctrs.btnExport);
			
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
	
	@Then("a popup appears")
	public void a_popup_appears() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "a popup appears");
			
			GenericMethods.waitForElementVisiblity(AccntLctrs.textexport, 10);
			
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
	
	@When("user click on export on popup to confirm")
	public void user_click_on_export_on_popup_to_confirm() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user click on export on popup to confirm");
			GenericMethods.waitForElementVisiblity(AccntLctrs.btnPopupExport,10);
			GenericMethods.clickByWebElement(AccntLctrs.btnPopupExport);
			
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
	
	@Then("user should see a message")
	public void user_should_see_a_message(io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user should see a message");
			
		GenericMethods.waitForElementVisiblity(AccntLctrs.textExportgenerated, 10);	
		
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
	
	@And("user clicks on close window button")
	public void user_clicks_on_close_window_button() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"), "user clicks on close window button");
			
			GenericMethods.clickByWebElement(AccntLctrs.btnClose);
			
		} catch (Exception ex) {
			 
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex );
		}
	}
}
