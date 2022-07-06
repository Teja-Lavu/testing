package com.mrp.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mrp.drivers.DriverManager;

public class WaitUtils {

	public static void waitForElementVisiblity(WebElement ele, int timeOut) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOut);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void waitForNestedEle(By parentLocator, By by) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentLocator, by));
	}

	public static void waitForElementOnDom(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void waitForElementInvisible(WebElement ele, int timeOut) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOut);
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public static void waitForElementToEnable(WebElement ele, int timeOut) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void waitForTextVisible(WebElement ele, int timeOut, String expectedString) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOut);
		wait.until(ExpectedConditions.textToBePresentInElement(ele, expectedString));
	}
	public static void waitForFrameVisibleAndSwitch(String frame, int timeOut) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	}
	
	public static void waitForStaleElement(WebElement ele, int timeOut) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOut);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(ele)));
	}
}
