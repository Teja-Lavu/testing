package com.mrp.stepdef;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.actions.AdminUsermanagementActions;
import com.mrp.pageObjects.actions.CreateCompanyActions;
import com.mrp.pageObjects.locators.AdminUsermanagementLocators;
import com.mrp.pageObjects.locators.CreateCompanyLocators;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminUsermanagementStep extends ReportManager {

	ExtentTest logtoreport = null;
	CreateCompanyLocators ccl = new CreateCompanyLocators();
	CreateCompanyActions cca = new CreateCompanyActions();
	AdminUsermanagementLocators aul = new AdminUsermanagementLocators();
	AdminUsermanagementActions aua = new AdminUsermanagementActions();
	String dynamic_email;
	
	@And("user navigates to Admin Studio page")
	public void user_navigates_to_admin_studio_page() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user navigates to Admin Studio page");
		WaitUtils.waitForElementVisiblity(aul.btnAdmin, 10);
		GenericMethods.clickByWebElement(aul.btnAdmin);
	} catch (Exception ex) {
		ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
	}
	}
	
	@And("user clicks on the users")
	public void user_clicks_on_the_users() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user clicks on the users");
		WaitUtils.waitForElementVisiblity(aul.btnUsers, 10);
		GenericMethods.clickByWebElement(aul.btnUsers);
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	@And("user clicks on create user button")
	public void user_clicks_on_create_user_button() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"),
					"user clicks on create user button");
			WaitUtils.waitForElementVisiblity(aul.btnCreateUser, 10);
			aua.clickCreateUser();
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	

	@Then("verify the contents of the page")
	public void verify_the_contents_of_the_page(io.cucumber.datatable.DataTable dataTable)
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("Then"), "Verify the contents of the page");
			List<String> data = dataTable.values();
			
			WaitUtils.waitForElementVisiblity(aul.lblfirstName, 10);

			for (int i = 0; i < data.size(); i++) {
				
				if (data.get(i).equalsIgnoreCase("First Name*"))

					aul.lblfirstName.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Last Name*"))

					aul.lbllastName.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Email*"))

					aul.lblemail.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Password*"))

					aul.lblPassword.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Role*"))

					aul.lblRole.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Create"))

					aul.btnCreate.isDisplayed();

				if (data.get(i).equalsIgnoreCase("Cancel"))

					aul.btnCancel.isDisplayed();
			}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("user enters first name")
	public void user_enters_first_name(io.cucumber.datatable.DataTable firstName)
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "user enters first name");
			
			if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
			
			WaitUtils.waitForElementVisiblity(aul.lblfirstName, 10);
			aua.fillFirstName(firstName.values().get(0));
			}
			else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {
				Thread.sleep(3000);
				cca.switchCompany();
				WaitUtils.waitForElementVisiblity(aul.lblfirstName, 10);
				aua.fillFirstName(firstName.values().get(0));
				}	
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("user enters last name")
	public void user_enters_last_name(io.cucumber.datatable.DataTable lastName)
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "user enters last name");
			aua.fillLastName(lastName.values().get(0));
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("user enter email address")
	public void user_enter_email_address() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "user enter email address");
			dynamic_email = "test" + "_" + System.currentTimeMillis() + "@mrpfd.com";
			aua.fillEmail(dynamic_email);
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("user enter password")
	public void user_enter_password(io.cucumber.datatable.DataTable password) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user enter password");
			aua.fillPassword(password.values().get(0));
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("the user selects the company admin user role")
	public void the_user_selects_the_company_admin_user_role()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "the user selects the user role");
			aua.selectCompanyAdminUserRole();
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	
	@And("the user selects the member user role")
	public void the_user_selects_the_member_user_role()
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "the user selects the user role");
			aua.selectMemberUserRole();
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("click on the Create button")
	public void click_on_the_create_button() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "click on the Create button");
			Thread.sleep(2000);
			//WaitUtils.waitForElementVisiblity(aul.btnCreate, 10);
			aua.clickCreate();
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify if the user is created successfully")
	public void verify_if_the_user_is_created_successfully() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"),
					"verify if the user is created successfully");
			WaitUtils.waitForElementVisiblity(aul.usersuccessmessage, 10);
			if (aul.usersuccessmessage.isDisplayed()) {
				
				ReportManager.mark_the_test_pass("Pass", DriverManager.getDriver(), logtoreport);
			} else {
				throw new Exception("User creation pop was NOT shown");
			}

		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}

	}
	
	@Then("user enters EMAIL address")
	public void user_enters_email_address(io.cucumber.datatable.DataTable email) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "click on the Create button");
			aua.fillEmail(email.values().get(0));

		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
	@Then("user enters PASSWORD")
	public void user_enters_password(io.cucumber.datatable.DataTable password) throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "click on the Create button");
			aua.fillPassword(password.values().get(0));
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}


	@And("user validates the error message for Email")
	public void user_validates_the_error_message_for_email(io.cucumber.datatable.DataTable alert)
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user validates the error message for Email");
			String errorMessage = aul.alertEmail.getText();
			Assert.assertEquals(errorMessage, alert.values().get(0));
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@And("user validates the error message for Temporary Password")
	public void user_validates_the_error_message_for_temporary_password(io.cucumber.datatable.DataTable alert)
			throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "user validates the error message for Temporary Password");
			String errorMessage = aul.alertPassword.getText();
			Assert.assertEquals(errorMessage, alert.values().get(0));
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

	@Then("verify Create button is disabled")
	public void verify_create_button_is_disabled() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("And"), "verify Create button is disabled");
		if(!GenericMethods.isClickable(aul.btnCreate)) {
			Boolean disabled = true;
		}
		} catch (Exception ex) {

			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	 
	}


}
