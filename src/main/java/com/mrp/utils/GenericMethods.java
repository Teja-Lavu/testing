package com.mrp.utils;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.lang.model.util.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentTest;
import com.mrp.drivers.DriverManager;
import com.mrp.report.ReportManager;

import io.cucumber.java.it.Date;

import java.util.Random;

public class GenericMethods extends WaitUtils {
	private static Logger logger;

	public static void logInfo(String s){
		Class<?> className = null;
		try {
			className = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		logger = LoggerFactory.getLogger(className);

		logger.info(s);
	}

	public static boolean isElementPresent(By by) {
		try {
			DriverManager.getDriver().findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String getText(WebElement web) {

		String getinsertedvalue = web.getText();

		return getinsertedvalue;
	}

	public static void clickByLocator(By tragetLocator) {
		getElement(tragetLocator).click();
	}

	public static void clickByWebElement(WebElement targetElement) {
		 WaitUtils.waitForElementVisiblity(targetElement, 5);
		targetElement.click();

	}

	public static void fillByLocator(By targetlocator, String text) {
		getElement(targetlocator).sendKeys(text);
	}

	public static void clearAndFillByWebElement(WebElement targetElement, String text) {
		clearInput(targetElement);
		targetElement.sendKeys(text);
	}

	public static void FillByWebElement(WebElement targetElement, String value) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
		String js = "arguments[0].value='" + value + "';";
		jse.executeScript(js, targetElement);

	}

	public static void FillByWebElement_sendkeys(WebElement targetElement, String value) throws InterruptedException {
        WaitUtils.waitForElementVisiblity(targetElement, 2);
		targetElement.sendKeys(value);

	}

	public static void select_date(String date) throws InterruptedException {
		WebElement startdate = DriverManager.getDriver().findElement(By.xpath("//input[@placeholder='Select Date']"));
		startdate.click();
		startdate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		startdate.sendKeys(Keys.BACK_SPACE);
		startdate.sendKeys(date);
		startdate.sendKeys(Keys.TAB);
	}

	public static boolean check_visibility(String xpaths) {
		boolean flag;
		try {
			flag = DriverManager.getDriver().findElement(By.xpath(xpaths)).isDisplayed();
			return flag;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public static void select_from_calender(String year, String month, String date, int whichcalender)
			throws InterruptedException {

		DriverManager.getDriver()
				.findElement(By.xpath(
						"//div[@class=\"ant-picker-panels\"]/div[" + whichcalender + "]/div/div[1]/div/button[2]"))
				.click();
		Thread.sleep(2000);


		for (int p = 0; p < 10; p++) {
			if (check_visibility("//div[@class=\"ant-picker-year-panel\"]/div[2]/table/tbody/tr/td[contains(@title,'"
					+ year + "')]")) {

				DriverManager.getDriver()
						.findElement(By.xpath(
								"//div[@class='ant-picker-year-panel']/div[2]/table/tbody/tr/td[contains(@title,'"
										+ year + "')]"))
						.click();
				break;
			} else {
				DriverManager.getDriver()
						.findElement(By.xpath("//div[@class=\"ant-picker-year-panel\"]/div[1]/button[2]")).click();
			}
		}

		if (check_visibility("//div[@class=\"ant-picker-month-panel\"]")) {

			DriverManager.getDriver()
					.findElement(By.xpath(
							"//div[@class=\"ant-picker-month-panel\"]/div[2]/table/tbody/tr/td/div[contains(text(),'"
									+ month + "')]"))
					.click();
		}


		DriverManager.getDriver()
				.findElement(By.xpath("//div[@class=\"ant-picker-panels\"]/div[1]/div/div[1]/div/button[1]")).click();
		DriverManager.getDriver()
				.findElement(By
						.xpath("//div[@class=\"ant-picker-month-panel\"]/div[2]/table/tbody/tr/td/div[contains(text(),'"
								+ month + "')]"))
				.click();

		Thread.sleep(2000);
		DriverManager.getDriver()
				.findElement(By.xpath(
						"//div[@class='ant-picker-panels']/div[1]//table/tbody/tr/td/div[text()='" + date + "']"))
				.click();

	}

	public static void select_dynamic_date(String date) throws InterruptedException {

		String[] date_split = date.split("-", -1);
		String[] Startdate_split = date_split[0].split(" ", -1);
		String singledate = Startdate_split[0];
		String month = Startdate_split[1];
		String year = Startdate_split[2];

		DriverManager.getDriver().findElement(By.xpath("//input[@placeholder=\"Start date\"]")).click();
		select_from_calender(year, month, singledate, 1);

		String[] Enddate_split = date_split[1].split(" ", -1);
		String end_singledate = Enddate_split[0];
		String end_month = Enddate_split[1];
		String end_year = Enddate_split[2];
		
		select_from_calender(end_year, end_month, end_singledate, 2);
	}
	
	public static void select_to_and_fro_date(String date) throws InterruptedException {

		String[] date_split = date.split("-", -1);
		WebElement startdate = DriverManager.getDriver().findElement(By.xpath("//input[@placeholder='Start date']"));
		startdate.click();
		startdate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		startdate.sendKeys(Keys.BACK_SPACE);
		startdate.sendKeys(date_split[0]);
		startdate.sendKeys(Keys.TAB);
		WebElement enddate = DriverManager.getDriver().findElement(By.xpath("//input[@placeholder='End date']"));
		enddate.click();
		enddate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		enddate.sendKeys(Keys.BACK_SPACE);
		enddate.sendKeys(date_split[1]);
		enddate.sendKeys(Keys.TAB);

		}

	public static void clearInput(WebElement targetElement) {

		String value = targetElement.getAttribute("value");
		for (int i = 0; i < value.length(); i++)
			targetElement.sendKeys(Keys.BACK_SPACE);
	}

	public static void cleardate() throws InterruptedException {

		DriverManager.getDriver().findElement(By.xpath("//div[@class='ant-picker-input']")).click();
		DriverManager.getDriver().findElement(By.xpath("//div[@class=\"ant-picker-input\"]/span[2]/span")).click();
	}

	public static boolean isClickable(WebElement web) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 5);
			wait.until(ExpectedConditions.elementToBeClickable(web));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void openUrl(String url) {
		DriverManager.getDriver().get(url);

	}

	public static void waitPageLoad() {
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	public static String getAttributeValue(WebElement ele, String attribute) {
		return ele.getAttribute(attribute);
	}

	public static void clickByJavaScript(WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", ele);
	}
	
	public static void insertByJavaScript(WebElement ele, String value) {
		 JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		 executor.executeScript("arguments[0].setAttribute('value','"+value+"')", ele);
	}

	private static CharSequence charAt(int i) {
		return null;
	}

	public static String getByJavaScript(WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		String value = (String) executor.executeScript("return $('#id_name').text()");
		return value;
	}

	public static void browserRefresh() {
		DriverManager.getDriver().navigate().refresh();
	}

	public static void browerNavitageBack() {
		DriverManager.getDriver().navigate().back();
	}

	public static void threadWait(int timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static WebElement getElement(By targetLocator) {
		return DriverManager.getDriver().findElement(targetLocator);
	}

	public static List<WebElement> getElements(By targetLocator) {
		return DriverManager.getDriver().findElements(targetLocator);
	}

	public static void switchWindow() {
		Set<String> windows = DriverManager.getDriver().getWindowHandles();
		String mainWindow = DriverManager.getDriver().getWindowHandle();
		for (String window : windows) {
			if (window.equals(mainWindow))
				continue;
			DriverManager.getDriver().switchTo().window(window);
			break;
		}
	}

	public static void closeDriver() {
		try {
			if (DriverManager.getDriver() != null) {
				DriverManager.getDriver().close();
				DriverManager.getDriver().quit();
			}
		} catch (Exception e) {

		}
	}

	public static By getLocator(WebElement element) {
		String locator = element.toString().split(":")[2];
		if (locator.contains("]"))
			locator = locator.substring(0, locator.lastIndexOf("]"));
		else
			locator = locator.substring(0, locator.lastIndexOf("'"));
		if (locator.contains("//")) {
			return By.xpath(locator);
		} else {
			return By.cssSelector(locator);
		}

	}

	public static String getLocator(List<WebElement> element) {
		String locator = element.toString().split(":")[2];
		locator = locator.substring(0, locator.lastIndexOf("]]"));
		return locator;
	}

	public static String getCurrentUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}

	public static void selectDropDownValue(WebElement locator, String value) {
		Select select = new Select(locator);
		select.selectByValue(value);

	}

	public static void selectDropDownByIndex(WebElement locator, int index) {
		Select select = new Select(locator);
		select.selectByIndex(index);
		locator.sendKeys(Keys.TAB);

	}

	public static void selectDropDownByVisibleText(WebElement locator, String text) {
		Select select = new Select(locator);
		select.selectByVisibleText(text);

	}

	public static void setDropDownByVisibleText(WebElement dropDownLocator, String value) throws InterruptedException {

		Select select = new Select((WebElement) dropDownLocator);
		select.selectByVisibleText(value);

	}

	public static String getDropDownByVisibleText(WebElement dropDownLocator) throws InterruptedException {
		Select select = new Select((WebElement) dropDownLocator);
		String value = select.getFirstSelectedOption().getText();
		return value;

	}

	public static void selecte_dropdown(WebElement template, String valuetoselect,List<WebElement> locDropdownList) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);

		wait.until(ExpectedConditions.visibilityOf(template));
		template.click();
		int element_to_search = locDropdownList.size();
			for(int i=0;i<element_to_search;i++) {
             String expText = locDropdownList.get(i).getText();
			if (expText.equals(valuetoselect)) {
				locDropdownList.get(i).click();
                 break;
			}
		}
	}

	public static List<String> gettemplateselected(String which_dropdown) {

		List<String> templates = new ArrayList<String>();
		if (which_dropdown.equals("available_template")) {
			List<WebElement> getelements = DriverManager.getDriver()
					.findElements(By.xpath("//*[@id=\"fitem_id_templates\"]/div[2]/div/span[@role]/span"));
			for (int i = 1; i <= getelements.size(); i++) {
				String value_selected = DriverManager.getDriver()
						.findElement(By.xpath(
								"//*[@id=\"fitem_id_templates\"]/div[2]/div//span[@role=\"listitem\"][" + i + "]"))
						.getText();
				Pattern p = Pattern.compile("� ");
				String arr2[] = p.split(value_selected);
				templates.add(arr2[1]);
			}
		}

		if (which_dropdown.equals("available_email_template")) {
			List<WebElement> getemailelements = DriverManager.getDriver()
					.findElements(By.xpath("//*[@id=\"fitem_id_emailtemplatesets\"]/div[2]/div/span[@role]/span"));
			for (int i = 1; i <= getemailelements.size(); i++) {
				String value_selected = DriverManager.getDriver().findElement(By.xpath(
						"//*[@id=\"fitem_id_emailtemplatesets\"]/div[2]/div//span[@role=\"listitem\"][" + i + "]"))
						.getText();
				Pattern p = Pattern.compile("� ");
				String arr2[] = p.split(value_selected);
				templates.add(arr2[1]);
			}
		}

		return templates;

	}

	public static void settemplatesets(WebElement template, List<String> templatenames) throws InterruptedException {
		int size = templatenames.size();
		template.click();
		String find_templatesetsvalues = "//div[@id=\\\"fitem_id_emailtemplatesets\\\"]//*[contains(@id,\\\"form_autocomplete_suggestions\\\")]/li";
		List<WebElement> setselements = DriverManager.getDriver().findElements(By.xpath(find_templatesetsvalues));
	}
	
	public static void select_field_conditions(ExtentTest logtoreport, int criteria_no, String whichdropdownn,
			String value, int colNo) throws InterruptedException, IOException {
		try {
			String xpath = "//div/div[" + criteria_no + "]/div[" + colNo + "]/label/span/../div/button";

			DriverManager.getDriver().findElement(By.xpath(xpath)).click();
			Thread.sleep(2000);
			String find_values = "//div//div//ul/li/span";
			List<WebElement> storevalues = DriverManager.getDriver().findElements(By.xpath(find_values));
			for (int i = 0; i < storevalues.size(); i++) {
				String listvalue = storevalues.get(i).getText();
			}

			for (int i = 0; i < storevalues.size(); i++) {
				String listvalue = storevalues.get(i).getText();
				if (listvalue.contains(value)) {
					try {
						storevalues.get(i).click();
					} catch (Exception e) {
						storevalues.get(i).click();
					}
					break;

				}

			}
		} catch (Exception e) {
			ReportManager.mark_the_test_fail_with_custom("Failed", DriverManager.getDriver(), logtoreport,
					"Dropdown did not opened");
		}

	}
	
	public static void select_search_sort_duration(int fieldno, String value) throws InterruptedException {

		if (fieldno == 1) {
			DriverManager.getDriver().findElement(By.xpath("//div/div[1]/div/main/section[1]/div/div[" + fieldno + "]//input"))
					.sendKeys(value);

		} else {
			String xpath = "//div/div[1]/div/main/section[1]/div/div[" + fieldno + "]";
			DriverManager.getDriver().findElement(By.xpath(xpath)).click();
			Thread.sleep(2000);
			String find_values = "//div//div//ul/li/span";
			List<WebElement> storevalues = DriverManager.getDriver().findElements(By.xpath(find_values));
			for (int i = 0; i < storevalues.size(); i++) {
				String listvalue = storevalues.get(i).getText();
				System.out.println("Global dropdown["+fieldno+"] : > " + "value["+i+"]" +storevalues.get(i).getText());
			}
			
			for (int i = 0; i < storevalues.size(); i++) {
				String listvalue = storevalues.get(i).getText();
				if (listvalue.contains(value)) {
					storevalues.get(i).click();
					break;

				}

			}
		}
	}

	public static void select_multiselect_value(ExtentTest logtoreport, int criteria_no, String whichdropdownn, String value)
			throws InterruptedException, IOException {
try
{
		String[] valueslist = value.split("%", -1);
		for (int p = 0; p < valueslist.length; p++) {

			List<WebElement> inputbox = DriverManager.getDriver().findElements(
					By.xpath("//div/div[" + criteria_no + "]/div[3]/label/input"));
			if (inputbox.size() != 0) {
				inputbox.get(0).sendKeys(value);
			} else {
				
				String xtr = "//div/div[" + criteria_no	+ "]/div[3]/label/div/div/div[2] | "
						 + "//div/div[" + criteria_no	+ "]/div[3]/label/div/div/div[2]/div[2]";				
				WebElement ele = DriverManager.getDriver().findElement(By.xpath(xtr));				
				WaitUtils.waitForElementVisiblity(ele, 10);
				ele.click();
				String find_values = "//div/div[" + criteria_no	+ "]/div[3]/label/div/div[2]/div/div";
				List<WebElement> storevalues = DriverManager.getDriver().findElements(By.xpath(find_values));
				for (int i = 0; i < storevalues.size(); i++) {

					String listvalue = null;

					listvalue = storevalues.get(i).getAttribute("innerHTML");
					if (listvalue.contains(valueslist[p])) {
						storevalues.get(i).click();
						break;
					}

				}
			}
		}
}catch(Exception e)
{
	ReportManager.mark_the_test_fail_with_custom("Failed", DriverManager.getDriver(), logtoreport, "Dropdown did not opened");
}
	}

	public static void generateRandomNumbers() {
		Random objGenerator = new Random();
		for (int iCount = 0; iCount < 10; iCount++) {
			int randomNumber = objGenerator.nextInt(100);
			System.out.println("Random No : " + randomNumber);
		}
	}

	public static String generateRandomString(int n) {
		String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz" + "0123456789";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (randomString.length() * Math.random());
			sb.append(randomString.charAt(index));
		}
		return sb.toString();
	}

	public static int generateRandomNumber(int length) {
		int max = (int) (Math.pow(10, length) - 1);
		int min = (int) Math.pow(10, length - 1);
		int range = max - min + 1;
		int randomNumber = (int) (Math.random() * range) + min;
		return randomNumber;
	}

	@DataProvider(name = "dp")
	public static Object[][] getData(Class<?> className) {
		ExcelRead er = new ExcelRead(className.getSimpleName());
		int row = er.getRowCount();
		int col = er.getColCount();

		Object[][] data = new Object[row - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= row; rowNum++) {
			table = new Hashtable<>();
			for (int colNum = 0; colNum < col; colNum++) {
				try {
					table.put(er.getCellData(0, colNum), er.getCellData(rowNum - 1, colNum));
					data[rowNum - 2][0] = table;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public static boolean isElementDisplayed(WebElement targetElement) {
		return targetElement.isDisplayed();
	}
	
	public static boolean isElementDisabled(WebElement targetElement) {
		Boolean flag = false;
		if(!targetElement.isEnabled() !=true) {
		flag= false;
		}
		else {
		flag=true;
		}
		return flag;
		
	}

}
