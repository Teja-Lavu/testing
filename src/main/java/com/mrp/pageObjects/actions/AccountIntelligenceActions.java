package com.mrp.pageObjects.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.AccountIntelligenceLocators;
import com.mrp.pageObjects.locators.AccountLocators;
import com.mrp.pageObjects.locators.AccountsOverviewLocators;
import com.mrp.utils.GenericMethods;

public class AccountIntelligenceActions {
	
	AccountLocators acctLocators;
	AccountIntelligenceLocators ail;
	
	public AccountIntelligenceActions() {
		 this.ail = new AccountIntelligenceLocators();
		 this.acctLocators = new AccountLocators();
				PageFactory.initElements(DriverManager.getDriver(),this.ail);
				PageFactory.initElements(DriverManager.getDriver(),this.acctLocators);

	}
	
	public void clicksearch() {
		GenericMethods.waitForElementVisiblity(acctLocators.Search, 5);
		GenericMethods.clickByWebElement(acctLocators.Search);
	}
	
	public void searchAccount() throws InterruptedException {
		if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
		GenericMethods.FillByWebElement_sendkeys(acctLocators.Search,"LEC");
		}else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {
			GenericMethods.FillByWebElement_sendkeys(acctLocators.Search,"Stanford University");

		}
		
	}
	
	public void selectAccount() throws InterruptedException {
		GenericMethods.waitForElementVisiblity(ail.pagination, 50);
		String[] pagination = GenericMethods.getText(ail.pagination).split(" ");
		int pageNo = Integer.parseInt(pagination[1]);
		boolean found = false;
		for (int page = 1; page <= pageNo; page++) {
			GenericMethods.waitForElementVisiblity(ail.pagination, 50);

			int rows = DriverManager.getDriver().findElements(By.xpath("//table/tbody/tr")).size();

			for (int i = 1; i <= rows; i++) {
				String account = DriverManager.getDriver()
						.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]/a/span")).getText().trim();
				if(DriverManager.getDriver().getCurrentUrl().contains("px-qa.mrpfd.com")) {
				if (account.contentEquals("LEC")) {
					DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]/a")).click();
					found = true;
					break;
				}}
				else if(DriverManager.getDriver().getCurrentUrl().contains("https://app.prelytix.com/")) {
					
					if (account.contentEquals("Stanford University")) {
						DriverManager.getDriver().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]/a")).click();
						found = true;
						break;
					}
				}				
			}
			if (found == false) {
				GenericMethods.clickByWebElement(ail.btnNextPage);

			} else {
				break;
			}
		}			
	}	
}
