package com.mrp.drivers;

import com.mrp.utils.GetConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

	protected static Class<? extends WebDriver> driverMethod = null;
	protected static WebDriver driver = null;
	protected static ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();

	static String browser = GetConfigProperties.getPropValue("browser");
	static String browserType = GetConfigProperties.getPropValue("browserType");
	static String browserDeploy = GetConfigProperties.getPropValue("browserDeploy");

	/**
	 * Set the respective driver given in configuration.properties * @return
	 * 
	 */

	public static WebDriverManager getDriverMethod() {
		if (browser.equalsIgnoreCase("chrome")) driverMethod = ChromeDriver.class;
		if (browser.equalsIgnoreCase("firefox")) driverMethod = FirefoxDriver.class;
		if (browser.equalsIgnoreCase("edge")) driverMethod = EdgeDriver.class;
		if (browser.equalsIgnoreCase("opera")) driverMethod = OperaDriver.class;
		if (browser.equalsIgnoreCase("safari")) driverMethod = SafariDriver.class;
		return WebDriverManager.getInstance(driverMethod);
	}

	public static void initDriver() {
		if (browserDeploy.equalsIgnoreCase("local")) driver = getDriverMethod().create();
		if (browserDeploy.equalsIgnoreCase("selDocker")) driver = getDriverMethod().remoteAddress("http://localhost:4444/wd/hub").avoidFallback().create();
		if (browserDeploy.equalsIgnoreCase("wdmDocker")) driver = getDriverMethod().browserInDocker().enableVnc().create();
		// for wdmDocker we need to add to /etc/hosts with
		// .dockerExtraHosts("px-qa.mrpfd.com:10.211.15.160")
		thread.set(driver);
		thread.get().manage().window().maximize();
		// return driver;
	}

	public static WebDriver getDriver() {
		return thread.get();
	}

	public static void setupDriver() {
			initDriver();
		System.out.println("Start up browser!");
	}

	public static void teardown() {
		if (thread != null) {
			thread.get().close();
		}
		driver = null;
		System.out.println("Tear down browser!");
	}
}