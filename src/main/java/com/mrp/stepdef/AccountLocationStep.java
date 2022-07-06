package com.mrp.stepdef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.AccountLocationActions;
import com.mrp.pageObjects.locators.AccountLocationLocators;
import com.mrp.pageObjects.locators.AccountLocators;
import com.mrp.pageObjects.locators.CreateCompanyLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountLocationStep extends ReportManager {
	
	
	AccountLocationActions accntActions = new AccountLocationActions();
	AccountLocationLocators accntalct = new AccountLocationLocators();	
	AccountLocators accntlct = new AccountLocators();
	ExtentTest logtoreport = null;
	SoftAssert softassert = new SoftAssert();

	
	@When("User click accounts")
	public void user_click_accounts() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "User click accounts");

			GenericMethods.clickByWebElement(accntalct.Accounts);

		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("User select an account from list")
	public void user_select_an_account_from_list() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "User select an account from list");
			
			if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
				GenericMethods.waitForElementVisiblity(accntlct.Search, 15);
				GenericMethods.clickByWebElement(accntlct.Search);
				GenericMethods.FillByWebElement_sendkeys(accntlct.Search,"Nacro");
			GenericMethods.waitForElementVisiblity(accntalct.selectAccount, 15);
			accntActions.clickAccountNacro();
			}
			else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {
				GenericMethods.waitForElementVisiblity(accntlct.Search, 15);
				GenericMethods.clickByWebElement(accntlct.Search);
				GenericMethods.FillByWebElement_sendkeys(accntlct.Search,"Stanford University");
				GenericMethods.waitForElementVisiblity(accntalct.selectAccountProd, 15);
				GenericMethods.clickByWebElement(accntalct.selectAccountProd);
			}

		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("User navigates to the Locations tab")
	public void user_navigates_to_the_locations_tab() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "click view filter");
			GenericMethods.waitForElementVisiblity(accntalct.tabLocations, 15);
			accntActions.clickLocation();

		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("Verify the contents of the Location page")
	public void verify_the_contents_of_the_location_page(io.cucumber.datatable.DataTable dataTable)
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "Verify the contents of the Location page");
			List<String> data = dataTable.values();
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).equalsIgnoreCase("Location"))
					GenericMethods.waitForElementVisiblity(accntalct.lblLocation, 15);
					accntalct.lblLocation.isDisplayed();
                    Thread.sleep(2000);
				if (data.get(i).equalsIgnoreCase("Topic"))
					GenericMethods.waitForElementVisiblity(accntalct.lblTopic, 15);
					accntalct.lblTopic.isDisplayed();
				if (data.get(i).equalsIgnoreCase("SCORE + TOPIC"))
					accntalct.lblScoreTopic.isDisplayed();
				if (data.get(i).equalsIgnoreCase("ADDRESS"))
					accntalct.lblAddress.isDisplayed();
				if (data.get(i).equalsIgnoreCase("ACTION"))
					accntalct.lblAction.isDisplayed();
				}		
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("Verify the items of Location dropdown  has all the addresses of all topics on page")
	public void verify_the_items_of_location_dropdown_has_all_the_addresses_of_all_topics_on_page()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "Verify the items of Location dropdown  has all the addresses of all topics on page");
			
			GenericMethods.waitForElementVisiblity(accntalct.drpdwnLocation, 5);
			GenericMethods.clickByWebElement(accntalct.drpdwnLocation);
			GenericMethods.waitForElementVisiblity(accntalct.selectLocation, 5);
			List<WebElement> values = accntalct.tblLocation;
			ArrayList<String> actual_dropdown_list = new ArrayList<String>();
			String expected_dropdown_list = null;

			for (int i = 1; i < values.size(); i++) {

				actual_dropdown_list.add(values.get(i).getText());

			}
				for (int j = 1; j < values.size(); j++) {

					expected_dropdown_list = DriverManager.getDriver()
							.findElement(By.xpath("//tbody/tr[" + j + "]/td[2]")).getText();
					if (actual_dropdown_list.contains(expected_dropdown_list)) {

					}
				}
			
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("Verify the items of Topics dropdown")
	public void verify_the_items_of_topics_dropdown(io.cucumber.datatable.DataTable dataTable)
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "Verify the items of Topics dropdown");

			List<String> data = dataTable.values();
			System.out.println("Size : " + data.size());
			System.out.println("List : " + data.toString());
			ArrayList<String> feature_list = new ArrayList<String>();
			ArrayList<String> actual_dropdown_list = new ArrayList<String>();

			for (int i = 0; i < data.size(); i++) {

				feature_list.add(data.get(i));
			}

			accntalct.drpdwnTopic.click();
			List<WebElement> values = accntalct.tblTopic;
			for (int i = 0; i < values.size(); i++) {

				actual_dropdown_list.add(values.get(i).getText());
			}

			System.out.println("Topic Featurefile dropdownvalues - " + feature_list.toString());
			System.out.println("Topic Actual dropdownvalues - " + actual_dropdown_list.toString());

		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user selects an address from location drop down")
	public void user_selects_an_address_from_location_drop_down() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user selects an address from location drop down");
			
			GenericMethods.waitForElementVisiblity(accntalct.selectLocation, 10);
			GenericMethods.clickByWebElement(accntalct.selectLocation);

		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify if the selected address is show in the results")
	public void verify_if_the_selected_address_is_show_in_the_results() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "verify if the selected address is show in the results");
            Thread.sleep(2000);
            if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
			GenericMethods.waitForElementVisiblity(accntalct.resultLocation, 10);
			softassert.assertEquals(GenericMethods.getText(accntalct.resultLocation), "10-12 Park Place, Lawn Lane, London, England, United Kingdom");
            }
            else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {
            	GenericMethods.waitForElementVisiblity(accntalct.resultLocationprod, 10);
    			softassert.assertEquals(GenericMethods.getText(accntalct.resultLocationprod), "4426 Chippendale Ct, Union City, California, United States");
                 }
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user click on view location link for a given location")
	public void user_click_on_view_location_link_for_a_given_location() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user click on view location link for a given location");

			GenericMethods.clickByWebElement(accntalct.linkLocation);

		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("User navigates to Intelligence Tab")
	public void user_navigates_to_intelligence_tab() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "User navigates to Intelligence Tab");

			GenericMethods.waitForElementVisiblity(accntalct.lblAccountScore, 5);

		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@When("user selects topic from dropdown")
	public void user_selects_topic_from_dropdown() throws IOException, InterruptedException {
		try {
		logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user selects topic from dropdown");
		GenericMethods.clickByWebElement(accntalct.selectTopic);

	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}

	@Then("verify if related locations are displayed")
	public void verify_if_related_locations_are_displayed() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "verify if related locations are displayed");

			GenericMethods.waitForElementVisiblity(accntalct.resultLocation, 10);
			
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
}
