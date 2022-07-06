package com.mrp.listeners;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mrp.drivers.DriverManager;
import com.mrp.report.ReportManager;

public class TestUtil {

	public static String ScreenshotPath = "./GeneratedReport/" + ReportManager.reportSubFilePath + "/screenshots/";
	public static String screenShotName;

	/**
	 * Method to take screenshot
	 */
	public static void captureScreenShot() {
		try {
			File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			Date d = new Date();
			screenShotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
			FileUtils.copyFile(src, new File(ScreenshotPath + screenShotName));
		} catch (Exception e) {
			// GenericMethods.logInfo(e.getLocalizedMessage());
		}
	}

}
