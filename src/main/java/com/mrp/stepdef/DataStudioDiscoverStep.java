package com.mrp.stepdef;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.CustomerHomePageActions;
import com.mrp.pageObjects.actions.DataStudioDiscoverActions;
import com.mrp.pageObjects.actions.DataStudioUploadActions;
import com.mrp.pageObjects.locators.DataStudioDiscoverLocators;
import com.mrp.pageObjects.locators.DataStudioUploadLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataStudioDiscoverStep extends ReportManager {

	CustomerHomePageActions chpa = new CustomerHomePageActions();
	DataStudioDiscoverActions dsda = new DataStudioDiscoverActions();
	DataStudioUploadActions ddua = new DataStudioUploadActions();
	DataStudioUploadLocators ddsl = new DataStudioUploadLocators();
	DataStudioDiscoverLocators dsdl = new DataStudioDiscoverLocators();
	CreateCompanyStep company = new CreateCompanyStep();
	ExtentTest logtoreport = null;
	String dynamic_listname;

	@When("The user navigates to the select a method page")
	public void the_user_navigates_to_the_select_a_method_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"The user navigates to the select a method page");
			chpa.clickdatasourceicon();
			chpa.click_create_newList_button();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("They select the {string} Option on the List Method page")
	public void they_select_the_option_on_the_list_method_page(String string) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"They select the Option on the List Method page");
			ddua.clickAccountList();
			ddua.clickContinue();
			ddua.clickDiscover();
			ddua.clickContinue();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("Verify the contents of the page")
	public void verify_the_contents_of_the_page(DataTable dataTable) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "Verify the contents of the page");
			List<String> data = dataTable.values();

			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).equalsIgnoreCase("Status Bar"))

					dsdl.statusBar.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Geography"))

					dsdl.geography.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Limit Results"))

					dsdl.limitResults.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Industry"))

					dsdl.industry.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Annual Revenue"))

					dsdl.annualRevenue.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Employee count "))

					dsdl.employeeCount.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Go back"))

					dsdl.btnGoBack.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Continue"))

					dsdl.Continue.isDisplayed();

			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}

	@When("the user first sees the revenue")
	public void the_user_first_sees_the_revenue() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "the user first sees the revenue");
			GenericMethods.isElementDisplayed(dsdl.annualRevenue);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("the inputs will display placeholder text")
	public void the_inputs_will_display_placeholder_text(DataTable dataTable) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "the inputs will display placeholder text");
			List<String> data = dataTable.values();

			String annualrev_text1 = null;
			String annualrev_text2 = null;
			String Geo_text = null;
			String AccountHQ_text = null;
			String LimitRslt_text = null;
			String employee_text1 = null;
			String employee_text2 = null;

			for (int i = 0; i < data.size(); i++) {

				if (data.get(i).equalsIgnoreCase("Enter minimum value in millions (USD)")) {
					WaitUtils.waitForElementVisiblity(dsdl.txtRevenueMin, 10);
					annualrev_text1 = GenericMethods.getText(dsdl.txtRevenueMin);

				}
				if (data.get(i).equalsIgnoreCase("Enter maximum value in millions (USD)")) {
					WaitUtils.waitForElementVisiblity(dsdl.txtRevenueMax, 10);
					annualrev_text2 = GenericMethods.getText(dsdl.txtRevenueMax);

				}
				if (data.get(i).equalsIgnoreCase("Begin typing to select a geography")) {
					WaitUtils.waitForElementVisiblity(dsdl.txtGeography, 10);
					Geo_text = GenericMethods.getText(dsdl.txtGeography);

				}
				if (data.get(i).equalsIgnoreCase("Select Yes or No")) {
					WaitUtils.waitForElementVisiblity(dsdl.selectLimit, 10);
					AccountHQ_text = GenericMethods.getText(dsdl.selectLimit);

				}

				if (data.get(i).equalsIgnoreCase("Select an option")) {
					WaitUtils.waitForElementVisiblity(dsdl.plcHldrLimit, 10);
					LimitRslt_text = GenericMethods.getText(dsdl.plcHldrLimit);

				}
				if (data.get(i).equalsIgnoreCase("Enter a minimum value")) {
					WaitUtils.waitForElementVisiblity(dsdl.txtEmployeeMin, 10);
					employee_text1 = GenericMethods.getText(dsdl.txtEmployeeMin);

				}
				if (data.get(i).equalsIgnoreCase("Enter a maximum value")) {
					WaitUtils.waitForElementVisiblity(dsdl.txtEmployeeMax, 10);
					employee_text2 = GenericMethods.getText(dsdl.txtEmployeeMax);

				}

			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("a down arrow will signify the values present in the drop down")
	public void a_down_arrow_will_signify_the_values_present_in_the_drop_down()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"a down arrow will signify the values present in the drop down");
			GenericMethods.isElementDisplayed(dsdl.drpRevenueMin);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the values present in the revenue minimum dropdown")
	public void verify_the_values_present_in_the_revenue_minimum_dropdown(DataTable dataTable)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify the values present in the revenue minimum dropdown");
			List<String> data = dataTable.values();

			ArrayList<String> feature_list = new ArrayList<String>();
			ArrayList<String> actual_dropdown_list = new ArrayList<String>();

			for (int i = 0; i < data.size(); i++) {

				feature_list.add(data.get(i));
			}

			GenericMethods.clickByWebElement(dsdl.drpRevenueMin);
			List<WebElement> values = dsdl.tblRevenueMin;
			for (int i = 0; i < values.size(); i++) {

				actual_dropdown_list.add(values.get(i).getText());
			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the values present in the revenue maximum dropdown")
	public void verify_the_values_present_in_the_revenue_maximum_dropdown(DataTable dataTable)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify the values present in the revenue maximum dropdown");
			List<String> data = dataTable.values();

			ArrayList<String> feature_list = new ArrayList<String>();
			ArrayList<String> actual_dropdown_list = new ArrayList<String>();

			for (int i = 0; i < data.size(); i++) {

				feature_list.add(data.get(i));
			}
			GenericMethods.clickByWebElement(dsdl.drpRevenueMax);
			List<WebElement> values = dsdl.tblRevenueMax;
			for (int i = 0; i < values.size(); i++) {

				actual_dropdown_list.add(values.get(i).getText());
			}

		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user enter minimum values {string}  and maximum value {string}")
	public void user_enter_minimum_values_and_maximum_value(String min, String max)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"user enter minimum values  and maximum value");
			GenericMethods.clickByWebElement(dsdl.drpRevenueMin);
			DriverManager.getDriver().findElement(By.xpath(
					"//div[contains(text(),'Enter a minimum value in millions (USD)')]/../../../../div[2]/div/div[text()='"
							+ min + "']"))
					.click();

			GenericMethods.clickByWebElement(dsdl.drpRevenueMax);
			DriverManager.getDriver().findElement(By.xpath(
					"//div[contains(text(),'Enter a maximum value in millions (USD)')]/../../../../div[2]/div/div[text()='"
							+ max + "']"))
					.click();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the error message {string}")
	public void verify_the_error_message(String string) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "verify the error message");
			WaitUtils.waitForElementVisiblity(dsdl.msgRevenue, 10);
			String errortext = dsdl.msgRevenue.getText();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("the continue button changes into an inactive state until the error is addressed")
	public void the_continue_button_changes_into_an_inactive_state_until_the_error_is_addressed()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"the continue button changes into an inactive state until the error is addressed");
			if (!dsdl.Continue.isEnabled())
				;

		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("a user exceeds an allowed limit for a min\\/max field")
	public void a_user_exceeds_an_allowed_limit_for_a_min_max_field() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"a user exceeds an allowed limit for a min\\\\/max field");
			GenericMethods.clickByWebElement(dsdl.txtRevenueMin);
			GenericMethods.FillByWebElement_sendkeys(dsdl.iptRevenueMin, "900000000");
			Thread.sleep(2000);
			GenericMethods.waitForElementVisiblity(dsdl.selectRevenueMin, 15);
			GenericMethods.clickByWebElement(dsdl.selectRevenueMin);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("an error message pops up {string}")
	public void an_error_message_pops_up(String string) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "an error message pops up ");
			WaitUtils.waitForElementVisiblity(dsdl.msgMaxEmployee, 10);
			String errortext = GenericMethods.getText(dsdl.msgMaxEmployee);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user clicks on the X icon after selecting minimum revenue value")
	public void user_clicks_on_the_x_icon_after_selecting_minimum_revenue_value()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"user clicks on the X icon after selecting minimum revenue value");
			GenericMethods.clickByWebElement(dsdl.RevenueMinCrs);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("the selected value should be deleted and the min input should display place holder")
	public void the_selected_value_should_be_deleted_and_the_min_input_should_display_place_holder()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"the selected value should be deleted and the min input should display place holder");
			WaitUtils.waitForElementVisiblity(dsdl.txtRevenueMin, 10);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user clicks on the X icon after selecting maximum revenue value")
	public void user_clicks_on_the_x_icon_after_selecting_maximum_revenue_value()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"user clicks on the X icon after selecting maximum revenue value");
			GenericMethods.clickByWebElement(dsdl.RevenueMaxCrs);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("the selected value should be deleted and the max input should display place holder")
	public void the_selected_value_should_be_deleted_and_the_max_input_should_display_place_holder()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "User will click Admin");
			WaitUtils.waitForElementVisiblity(dsdl.txtRevenueMax, 10);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("the user first sees the yes\\/no inputs for headquarters")
	public void the_user_first_sees_the_yes_no_inputs_for_headquarters() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"the user first sees the yes/no inputs for headquarters");
			String headquarter_placeholder_text = dsdl.selectLimit.getText();

		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify if the Geography is a searchable drop down")
	public void verify_if_the_geography_is_a_searchable_drop_down() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify if the Geography is a searchable drop down");
			GenericMethods.clickByWebElement(dsdl.txtGeography);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify if the values are visible based on user selection")
	public void verify_if_the_values_are_visible_based_on_user_selection() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify if the values are visible based on user selection");
			GenericMethods.FillByWebElement_sendkeys(dsdl.iptGeography, "India");
			GenericMethods.waitForElementVisiblity(dsdl.searchGeography, 15);
			GenericMethods.waitForElementVisiblity(dsdl.selectRegion, 15);
			GenericMethods.clickByWebElement(dsdl.selectRegion);		
			GenericMethods.waitForElementVisiblity(dsdl.selectRegion, 15);
			if(!GenericMethods.isElementPresent(By.xpath("//p[text()='India']"))) {
				GenericMethods.FillByWebElement_sendkeys(dsdl.iptGeography, "India");
				GenericMethods.waitForElementVisiblity(dsdl.searchGeography, 15);
				GenericMethods.clickByWebElement(dsdl.searchGeography);
			}			
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("the Continue button should be enabled")
	public void the_continue_button_should_be_enabled() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "the Continue button should be enabled");
			GenericMethods.isClickable(dsdl.Continue);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("the user first sees the Industry")
	public void the_user_first_sees_the_industry() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "the user first sees the Industry");
			GenericMethods.isElementDisplayed(dsdl.industry);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("the inputs will display Industry placeholder text")
	public void the_inputs_will_display_industry_placeholder_text(DataTable dataTable)
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"the inputs will display Industry placeholder text");
			List<String> data = dataTable.values();
			int i = 0;
			String IndTxt;
			if (data.get(i).equalsIgnoreCase("Select an option")) {
				WaitUtils.waitForElementVisiblity(dsdl.txtIndustry, 10);
				IndTxt = GenericMethods.getText(dsdl.txtIndustry);
			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the values present in the Industry dropdown")
	public void verify_the_values_present_in_the_industry_dropdown(DataTable dataTable)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify the values present in the Industry dropdown");
			List<String> data = dataTable.values();
			ArrayList<String> feature_list = new ArrayList<String>();
			ArrayList<String> actual_dropdown_list = new ArrayList<String>();

			for (int i = 0; i < data.size(); i++) {

				feature_list.add(data.get(i));
			}
			GenericMethods.clickByWebElement(dsdl.drpIndustry);
			List<WebElement> values = dsdl.tblIndustry;
			for (int i = 0; i < values.size(); i++) {

				actual_dropdown_list.add(values.get(i).getText());
				GenericMethods.clickByWebElement(dsdl.drpIndustry);
			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user inputs more than {int} value into the Industry drop down")
	public void user_inputs_more_than_value_into_the_industry_drop_down(Integer int1)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"user inputs more than 1 value into the Industry drop down");
			GenericMethods.clickByWebElement(dsdl.iptIndustry);
			Thread.sleep(1000);
			GenericMethods.clickByWebElement(dsdl.selectConstruction);
			GenericMethods.clickByWebElement(dsdl.iptIndustry);
			Thread.sleep(1000);
			GenericMethods.clickByWebElement(dsdl.selectEducation);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify if more than {int} value is used as criteria")
	public void verify_if_more_than_value_is_used_as_criteria(Integer int1) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify if more than 1 value is used as criteria");
			dsdl.iptIndustry.getSize();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the values present in the headquarter dropdown")
	public void verify_the_values_present_in_the_headquarter_dropdown(DataTable dataTable)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify the values present in the headquarter dropdown");
			List<String> data = dataTable.values();
			ArrayList<String> feature_list = new ArrayList<String>();
			ArrayList<String> actual_dropdown_list = new ArrayList<String>();

			for (int i = 0; i < data.size(); i++) {

				feature_list.add(data.get(i));
			}
			GenericMethods.clickByWebElement(dsdl.drpHeadQuarter);
			List<WebElement> values = dsdl.tblHeadQuarter;
			for (int i = 0; i < values.size(); i++) {
				actual_dropdown_list.add(values.get(i).getText());
			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user selects No from the drop down")
	public void user_selects_no_from_the_drop_down() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "user selects No from the drop down");
			GenericMethods.clickByWebElement(dsdl.drpHeadQuarter);
			Thread.sleep(2000);
			GenericMethods.clickByWebElement(dsdl.drpHeadQuarter);
			GenericMethods.clickByWebElement(dsdl.drpHeadQuarterNo);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("Limit Results drop down should not be displayed")
	public void limit_results_drop_down_should_not_be_displayed() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Limit Results drop down should not be displayed");
			if (!dsdl.limitResults.isDisplayed())
				System.out.println("LIMIT RESULTS TO ALL KNOWN LOCATIONS OR JUST HEADQUARTERS?  is not displayed ");
			else
				System.out.println(
						"LIMIT RESULTS TO ALL KNOWN LOCATIONS OR JUST HEADQUARTERS?  is displayed and is incorrect");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user selects Yes from the drop down")
	public void user_selects_yes_from_the_drop_down() throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "user selects Yes from the drop down");
			GenericMethods.clickByWebElement(dsdl.drpHeadQuarter);
			WaitUtils.waitForElementVisiblity(dsdl.drpHeadQuarterYes, 10);
			GenericMethods.clickByWebElement(dsdl.drpHeadQuarterYes);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("Limit Results drop down should be displayed")
	public void limit_results_drop_down_should_be_displayed() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"Limit Results drop down should be displayed");
			Thread.sleep(1000);
			if (!dsdl.limitResults.isDisplayed())
				System.out.println("LIMIT RESULTS TO ALL KNOWN LOCATIONS OR JUST HEADQUARTERS?  is not displayed ");
			else
				System.out.println(
						"LIMIT RESULTS TO ALL KNOWN LOCATIONS OR JUST HEADQUARTERS?  is displayed and is correct");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the values present in the headquarter dropdown again")
	public void verify_the_values_present_in_the_headquarter_dropdown_again(DataTable dataTable)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify the values present in the headquarter dropdown again");
			List<String> data = dataTable.values();
			ArrayList<String> feature_list = new ArrayList<String>();
			ArrayList<String> actual_dropdown_list = new ArrayList<String>();

			for (int i = 0; i < data.size(); i++) {

				feature_list.add(data.get(i));
			}
			GenericMethods.clickByWebElement(dsdl.drpLimit);
			List<WebElement> values = dsdl.tblLimit;
			for (int i = 0; i < values.size(); i++) {

				actual_dropdown_list.add(values.get(i).getText());
			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the values present in the employees minimum dropdown")
	public void verify_the_values_present_in_the_employees_minimum_dropdown(DataTable dataTable)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify the values present in the employees minimum dropdown");
			List<String> data = dataTable.values();
			ArrayList<String> feature_list = new ArrayList<String>();
			ArrayList<String> actual_dropdown_list = new ArrayList<String>();

			for (int i = 0; i < data.size(); i++) {

				feature_list.add(data.get(i));
			}

			GenericMethods.clickByWebElement(dsdl.drpEmployeeMin);
			List<WebElement> values = dsdl.tblEmployeeMin;
			for (int i = 0; i < values.size(); i++) {

				actual_dropdown_list.add(values.get(i).getText());
			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the values present in the employees maximum dropdown")
	public void verify_the_values_present_in_the_employees_maximum_dropdown(DataTable dataTable)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify the values present in the employees maximum dropdown");
			List<String> data = dataTable.values();
			ArrayList<String> feature_list = new ArrayList<String>();
			ArrayList<String> actual_dropdown_list = new ArrayList<String>();

			for (int i = 0; i < data.size(); i++) {

				feature_list.add(data.get(i));
			}

			GenericMethods.clickByWebElement(dsdl.drpEmployeeMax);
			List<WebElement> values = dsdl.tblEmployeeMax;
			for (int i = 0; i < values.size(); i++) {
				actual_dropdown_list.add(values.get(i).getText());
			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user enter minimum value {string} exceeds the maximum value {string}")
	public void user_enter_minimum_value_exceeds_the_maximum_value(String min, String max)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"user enter minimum value exceeds the maximum value");
			GenericMethods.clickByWebElement(dsdl.drpEmployeeMin);
			Thread.sleep(1000);
			DriverManager.getDriver()
					.findElement(By.xpath(
							"//span[contains(text(),'employee count')]/../div/div/div/div[text()='" + min + "']"))
					.click();

			GenericMethods.clickByWebElement(dsdl.drpEmployeeMax);
			DriverManager.getDriver()
					.findElement(By.xpath(
							"//span[contains(text(),'employee count')]/../../div/div[2]/div/div[text()='" + max + "']"))
					.click();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("an employee error message pops up {string}")
	public void an_employee_error_message_pops_up(String string) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "an employee error message pops up");
			WaitUtils.waitForElementVisiblity(dsdl.msgMaxEmployee, 10);
			String errortext = dsdl.msgMaxEmployee.getText();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user clicks on the X icon after selecting minimum employee count {string}")
	public void user_clicks_on_the_x_icon_after_selecting_minimum_employee_count(String min)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"user clicks on the X icon after selecting minimum employee count");
			GenericMethods.clickByWebElement(dsdl.crsEmployeeMin);
			GenericMethods.clickByWebElement(dsdl.drpEmployeeMin);
			DriverManager.getDriver()
					.findElement(By.xpath(
							"//span[contains(text(),'employee count')]/../div/div/div/div[text()='" + min + "']"))
					.click();
			GenericMethods.clickByWebElement(dsdl.crsEmployeeMin);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("the selected value should be deleted and the employee min input should display place holder")
	public void the_selected_value_should_be_deleted_and_the_employee_min_input_should_display_place_holder()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"the selected value should be deleted and the employee min input should display place holder");
			WaitUtils.waitForElementVisiblity(dsdl.txtEmployeeMin, 10);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user clicks on the X icon after selecting maximum employee count {string}")
	public void user_clicks_on_the_x_icon_after_selecting_maximum_employee_count(String max)
			throws InterruptedException, IOException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"user clicks on the X icon after selecting maximum employee count ");
			GenericMethods.clickByWebElement(dsdl.crsEmployeeMax);
			GenericMethods.clickByWebElement(dsdl.drpEmployeeMax);
			Thread.sleep(2000);
			DriverManager.getDriver()
					.findElement(By.xpath(
							"//span[contains(text(),'employee count')]/../../div/div[2]/div/div[text()='" + max + "']"))
					.click();
			WaitUtils.waitForElementVisiblity(dsdl.crsEmployeeMax, 10);
			// Thread.sleep(1000);
			GenericMethods.clickByWebElement(dsdl.crsEmployeeMax);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("the selected value should be deleted and the employee max input should display place holder")
	public void the_selected_value_should_be_deleted_and_the_employee_max_input_should_display_place_holder()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"the selected value should be deleted and the employee max input should display place holder");
			WaitUtils.waitForElementVisiblity(dsdl.txtEmployeeMax, 10);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("a user exceeds an allowed limit for a employee min\\/max field")
	public void a_user_exceeds_an_allowed_limit_for_a_employee_min_max_field()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"a user exceeds an allowed limit for a employee min\\\\/max field");

			GenericMethods.clickByWebElement(dsdl.crsEmployeeMin);
			GenericMethods.clickByWebElement(dsdl.txtEmployeeMin);
			GenericMethods.FillByWebElement_sendkeys(dsdl.iptEmployeeMin60m, "60000000");
			GenericMethods.waitForElementVisiblity(dsdl.ipt90k, 5);
			GenericMethods.clickByWebElement(dsdl.ipt90k);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("the error message {string} should be displayed")
	public void the_error_message_should_be_displayed(String string) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "the error message should be displayed");
			WaitUtils.waitForElementVisiblity(dsdl.msgEmployee, 10);
			String errortext = dsdl.msgEmployee.getText();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}

	@When("User click Continue")
	public void user_click_continue() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "User click Continue");

			WaitUtils.waitForElementToEnable(ddsl.Continue, 15);
			ddua.clickContinue();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("User Enter list Name as {string} and click Finish")
	public void user_enter_list_name_as_and_click_finish(String listName) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"User Enter List name as {string} and Finish");
			dynamic_listname = listName + "_" + System.currentTimeMillis();
			ddua.fillListName(dynamic_listname);
			GenericMethods.FillByWebElement_sendkeys(ddsl.fileName, "0");
			String temp = ddsl.fileName.getText();
			WaitUtils.waitForTextVisible(ddsl.fileName, 2, temp);
			ddsl.fileName.sendKeys(Keys.BACK_SPACE);
			WaitUtils.waitForElementToEnable(ddsl.btnFinish, 5);
			ddua.clickbtnFinish();
			Thread.sleep(2000);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("Click all Lists to go back to list page")
	public void click_all_lists_to_go_back_to_list_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "User go back to all lists");
			WaitUtils.waitForElementVisiblity(ddsl.txtFileCreated, 5);
			ddua.clickAllLists();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("Verify if a discover list is created")
	public void verify_if_a_discover_list_is_created() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"), "Verify if a list is created");
			DriverManager.getDriver().navigate().refresh();
			Thread.sleep(4000);
			WebElement resultLoc = DriverManager.getDriver()
					.findElement(By.xpath("//a[text()='" + dynamic_listname + "']"));
			String result = resultLoc.getText();

			assertEquals(dynamic_listname, result);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user click on discover list")
	public void user_click_on_discover_list() throws InterruptedException, IOException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"user selects a company from the Switch drop down");
			DriverManager.getDriver().findElement(By.xpath("//a[text()='" + dynamic_listname + "']")).click();
		} catch (Exception | AssertionError ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user selects a company from the Switch drop down for Data Studio")
	public void user_selects_a_company_from_the_switch_drop_down_for_data_studio()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"user selects a company from the Switch drop down");
			GenericMethods.clickByWebElement(dsdl.company);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}
}
