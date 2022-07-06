package com.mrp.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.mrp.drivers.DriverManager;

public class ScrollUtils {

	public static void scrollByPageTop() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	public static void scrollByVisibleElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

}
