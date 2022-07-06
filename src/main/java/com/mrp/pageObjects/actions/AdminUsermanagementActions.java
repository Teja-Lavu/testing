package com.mrp.pageObjects.actions;

import org.openqa.selenium.support.PageFactory;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.AdminUsermanagementLocators;
import com.mrp.utils.GenericMethods;

public class AdminUsermanagementActions {

	AdminUsermanagementLocators aul;
	
	public AdminUsermanagementActions() {
		this.aul = new AdminUsermanagementLocators();
		PageFactory.initElements(DriverManager.getDriver(), this.aul);
	}	
	
	public void clickCreateUser(){
		GenericMethods.clickByWebElement(aul.btnCreateUser);
	}
	
	public void fillFirstName(String firstName) throws InterruptedException{
		GenericMethods.clickByWebElement(aul.iptfirstName);
		GenericMethods.FillByWebElement_sendkeys(aul.iptfirstName, firstName);
	}
	
	public void fillLastName(String lastName) throws InterruptedException{
		GenericMethods.FillByWebElement_sendkeys(aul.iptlastName, lastName);
	}
	
	public void fillEmail(String email) throws InterruptedException{
		GenericMethods.FillByWebElement_sendkeys(aul.iptemail,email );
	}
	
	public void fillPassword(String password) throws InterruptedException{
		GenericMethods.FillByWebElement_sendkeys(aul.iptPassword, password);
	}	
	
	public void selectCompanyAdminUserRole() throws InterruptedException{
		GenericMethods.clickByWebElement(aul.dropdownRole);
		GenericMethods.clickByWebElement(aul.selectCompanyAdmin);
	}
	
	public void selectMemberUserRole() throws InterruptedException{
		GenericMethods.clickByWebElement(aul.dropdownRole);
		GenericMethods.clickByWebElement(aul.selectMember);
	}
	
	public void clickCreate(){
		GenericMethods.clickByWebElement(aul.btnCreate);
	}
}
