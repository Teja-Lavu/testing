package com.mrp.pageObjects.actions;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import com.mrp.drivers.DriverManager;
import com.mrp.pageObjects.locators.ContentSyndicationLocators;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.WaitUtils;

public class ContentSyndicationActions {
	ContentSyndicationLocators csLocators;
	Assertion assertion = new Assertion();

	public ContentSyndicationActions(){
		this.csLocators  = new ContentSyndicationLocators();
		PageFactory.initElements(DriverManager.getDriver(),this.csLocators);
	}
	
	public void clickContentSyndication() {
        WaitUtils.waitForElementVisiblity(csLocators.selectContentSyndication, 5);

		GenericMethods.waitForElementVisiblity(csLocators.selectContentSyndication, 5);
		GenericMethods.clickByWebElement(csLocators.selectContentSyndication);
	}
	
	public void verifyDocumentDownload() throws InterruptedException {
		Thread.sleep(3000);
		String driverPath = System.getProperty("user.home") + File.separator;

		String downloadPath = driverPath + "Downloads";
		   File getLatestFile = getLatestFilefromDir(downloadPath);
		   String fileName = getLatestFile.getName();
		   String[] fname = fileName.split(" ");
		   String fname1 = fname[0];
		   assertion.assertEquals(fname[0],"Sheet","Sheet is not dowloaded");
	}
	
	private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	    } 
	
}
