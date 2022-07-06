package com.mrp.stepdef;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.AccountActions;
import com.mrp.pageObjects.actions.FilterActions;
import com.mrp.pageObjects.locators.AccountIntelligenceLocators;
import com.mrp.pageObjects.locators.FilterLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterStep extends ReportManager{

	FilterLocators floc;
	FilterActions fActions;
	AccountIntelligenceLocators ailLocators;
	Assertion assertion = new Assertion();
	ExtentTest logtoreport = null;

	public FilterStep() {
		this.fActions = new FilterActions();
		this.floc = new FilterLocators();
		this.ailLocators = new AccountIntelligenceLocators();
		PageFactory.initElements(DriverManager.getDriver(), this.fActions);
		PageFactory.initElements(DriverManager.getDriver(), this.floc);
		PageFactory.initElements(DriverManager.getDriver(), this.ailLocators);

	}

	@Then("verify the result Country Excludes Albania")
	public void verify_the_result_country_excludes_albania() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Country Excludes Albania");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		fActions.navigateToLocations();
		Thread.sleep(4000);
		fActions.verifyLocationNotPresent("Albania");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Country Includes Albania")
	public void verify_the_result_country_includes_albania() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Country Includes Albania");
	
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		fActions.navigateToLocations();
		Thread.sleep(4000);
		fActions.verifyLocationPresent("Albania");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Region Excludes Abia Nigeria")
	public void verify_the_result_region_excludes_abia_nigeria() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Region Excludes Abia Nigeria");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		fActions.navigateToLocations();
		Thread.sleep(4000);
		fActions.verifyLocationNotPresent("Abia, Nigeria");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Region Includes Abia Nigeria")
	public void verify_the_result_region_includes_abia_nigeria() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Region Includes Abia Nigeria");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		fActions.navigateToLocations();
		Thread.sleep(2000);
		fActions.verifyLocationPresent("Abia, Nigeria");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result City Excludes Abia")
	public void verify_the_result_city_excludes_abia() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result City Excludes Abia");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		fActions.navigateToLocations();
		fActions.verifyLocationNotPresent("Aba, Abia");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result City Includes Abia")
	public void verify_the_result_city_includes_abia() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result City Includes Abia");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		fActions.navigateToLocations();
		fActions.verifyLocationPresent("Aba, Abia");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Employees Greater Than {int} filtered")
	public void verify_the_result_employees_greater_than_filtered(Integer int1) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Employees Greater Than {int} filtered");
			int countEmp;
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		GenericMethods.waitForElementVisiblity(floc.employeeCount, 30);
		String count = GenericMethods.getText(floc.employeeCount);
		String[] empCount = count.split(" ");
		
		if(empCount[0].contains(",")) {
		String[] emp = empCount[0].split(",");
		String emplcnt = emp[0] + emp[1];
		countEmp = Integer.parseInt(emplcnt);
		if (countEmp > 0) {
			boolean flag = true;
		} else {
			assertion.fail("Employees not greater than 0");
		}
		}		
		else {
			countEmp = Integer.parseInt(empCount[0]);
			if (countEmp > 0) {
		
			boolean flag = true;
		} else {
			assertion.fail("Employees not greater than 0");
		}
		
		} 
		}catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Employees Less Than {int} filtered")
	public void verify_the_result_employees_less_than_filtered(Integer int1) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Employees Less Than {int} filtered");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		GenericMethods.waitForElementVisiblity(floc.employeeCount, 30);
		String count = GenericMethods.getText(floc.employeeCount).trim();
		assertion.assertEquals(count, "Less than 100", "Employee count not less than 100");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Revenue Greater Than {int} filtered")
	public void verify_the_result_revenue_greater_than_filtered(Integer int1) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Revenue Greater Than {int} filtered");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		GenericMethods.waitForElementVisiblity(floc.revenueCount, 30);
		String count = GenericMethods.getText(floc.revenueCount);
		String[] empCount = count.split(" ");
		String emp = empCount[0].trim();
		int countEmp = Integer.parseInt(emp);
		assertion.assertTrue(countEmp> int1);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Revenue Less Than {int} filtered")
	public void verify_the_result_revenue_less_than_filtered(Integer int1) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Revenue Less Than {int} filtered");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		GenericMethods.waitForElementVisiblity(floc.revenueCount, 30);
		String count = GenericMethods.getText(floc.revenueCount);
		assertion.assertEquals(count, "Less than 100k", "Revenue not less than 1000");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result List includes Top Three Accounts filtered")
	public void verify_the_result_list_includes_top_three_accounts_filtered() throws InterruptedException, IOException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result List includes Top Three Accounts filtered");
		fActions.verifyList();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Topic Includes ABM filtered")
	public void verify_the_result_topic_includes_abm_filtered() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Topic Includes ABM filtered");
		GenericMethods.waitForElementVisiblity(floc.resultTopic, 30);
		GenericMethods.isElementDisplayed(floc.resultTopic);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Topic Score Greater Than {int} filtered")
	public void verify_the_result_topic_score_greater_than_filtered(Integer int1) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Topic Score Greater Than {int} filtered");
		GenericMethods.waitForElementVisiblity(floc.resultTopScore, 30);
		int score = Integer.parseInt(GenericMethods.getText(floc.resultTopScore));
		assertion.assertTrue(score > int1, "Topic Score not Less Than 50");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}

	@Then("verify the result Topic Score Less Than {int} filtered")
	public void verify_the_result_topic_score_less_than_filtered(Integer int1) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Topic Score Less Than {int} filtered");
		GenericMethods.waitForElementVisiblity(floc.resultTopScore, 30);
		int score = Integer.parseInt(GenericMethods.getText(floc.resultTopScore));

		assertion.assertTrue(score < int1, "Topic Score not Less Than 50");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Site Visits Greater Than {int} filtered")
	public void verify_the_result_site_visits_greater_than_filtered(Integer int1) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Site Visits Greater Than {int} filtered");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		GenericMethods.waitForElementVisiblity(ailLocators.tabIntelligence, 30);
		GenericMethods.clickByWebElement(ailLocators.tabIntelligence);
		GenericMethods.waitForElementVisiblity(floc.countVisits, 30);

		int visits = Integer.parseInt(GenericMethods.getText(floc.countVisits));
		assertion.assertTrue(visits > int1, "Site visits not greater than 0");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Site Visits Less Than {int} filtered")
	public void verify_the_result_site_visits_less_than_filtered(Integer int1) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Site Visits Less Than {int} filtered");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		GenericMethods.waitForElementVisiblity(ailLocators.tabIntelligence, 50);
		GenericMethods.clickByWebElement(ailLocators.tabIntelligence);
		GenericMethods.waitForElementVisiblity(floc.countVisits, 30);
		int visits = Integer.parseInt(GenericMethods.getText(floc.countVisits));
		assertion.assertTrue(visits < int1, "Site visits not less than 50");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Impressions Greater Than {int} filtered")
	public void verify_the_result_impressions_greater_than_filtered(Integer int1) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Impressions Greater Than {int} filtered");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		GenericMethods.waitForElementVisiblity(ailLocators.tabIntelligence, 30);
		GenericMethods.clickByWebElement(ailLocators.tabIntelligence);
		GenericMethods.waitForElementVisiblity(floc.countImpressions, 30);
		int impressions = Integer.parseInt(GenericMethods.getText(floc.countImpressions));
		assertion.assertTrue(impressions > int1, "Impressions not less than 50");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Impressions Less Than {int} filtered")
	public void verify_the_result_impressions_less_than_filtered(Integer int1) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Impressions Less Than {int} filtered");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 50);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		GenericMethods.waitForElementVisiblity(ailLocators.tabIntelligence, 30);
		GenericMethods.clickByWebElement(ailLocators.tabIntelligence);
		GenericMethods.waitForElementVisiblity(floc.countImpressions, 30);
		if (Integer.parseInt(GenericMethods.getText(floc.countImpressions)) < int1) {
			int clicks = Integer.parseInt(GenericMethods.getText(floc.countImpressions));
			assertion.assertTrue(clicks < int1, "clicks not less than 50");
		} else {
			assertion.fail();
		}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Clicks Greater Than {int} filtered")
	public void verify_the_result_clicks_greater_than_filtered(Integer int1) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Clicks Greater Than {int} filtered");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		GenericMethods.waitForElementVisiblity(ailLocators.tabIntelligence, 30);
		GenericMethods.clickByWebElement(ailLocators.tabIntelligence);
		GenericMethods.waitForElementVisiblity(floc.countClicks, 30);
		int clicks = Integer.parseInt(GenericMethods.getText(floc.countClicks));
		assertion.assertTrue(clicks > int1, "Impressions not less than 50");
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Clicks Less Than {int} filtered")
	public void verify_the_result_clicks_less_than_filtered(Integer int1) throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Clicks Less Than {int} filtered");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		GenericMethods.waitForElementVisiblity(ailLocators.tabIntelligence, 30);
		GenericMethods.clickByWebElement(ailLocators.tabIntelligence);
		GenericMethods.waitForElementVisiblity(floc.countClicks, 30);
		if (Integer.parseInt(GenericMethods.getText(floc.countClicks)) < int1) {
			int clicks = Integer.parseInt(GenericMethods.getText(floc.countClicks));
			assertion.assertTrue(clicks < int1, "clicks not less than 50");
		} else {
			assertion.fail();
		}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Industry Excludes Media and Entertainment filtered")
	public void verify_the_result_industry_excludes_media_and_entertainment_filtered() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Industry Excludes Media and Entertainment filtered");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		GenericMethods.waitForElementVisiblity(floc.txtIndustry, 30);
		String industry = GenericMethods.getText(floc.txtIndustry);
		if (!industry.contains("Media and Entertainment")) {
			boolean flag = true;
		} else {
			assertion.fail("Industry does not Excludes Media and Entertainment");
		}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify the result Industry includes Media and Entertainment filtered")
	public void verify_the_result_industry_includes_media_and_entertainment_filtered() throws IOException, InterruptedException, AssertionError {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Given"),
					"verify the result Industry includes Media and Entertainment filtered");
		GenericMethods.waitForElementVisiblity(floc.lnkAccount, 30);
		GenericMethods.clickByWebElement(floc.lnkAccount);
		GenericMethods.waitForElementVisiblity(floc.txtIndustry, 30);
		String industry = GenericMethods.getText(floc.txtIndustry);
		if (industry.contains("Media and Entertainment")) {
			boolean flag = true;
		} else {
			assertion.fail("Industry does not include Media and Entertainment");
		}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

}
