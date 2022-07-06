package com.mrp.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mrp.utils.GetConfigProperties;

public class ReportManager {
	public static ExtentReports reports;
	public static ExtentTest test;
	public static ExtentTest scene_def =null;

	public static String reportFileName = GetConfigProperties.getPropValue("ReportName") + "_" + dateFormat();
	public static String reportSubFilePath = "MRPFD" + "_" + dateFormat();
	public static String reportFilepath = System.getProperty("user.dir") + File.separator + "GeneratedReport"
			+ File.separator + reportSubFilePath;
	private static String reportLocation = reportFilepath + File.separator + reportFileName + ".html";

	public static List<Object> scene = new ArrayList<Object>();

	public static void getInstance() {
		if (reports == null)
			createInstance();
	}

	public static ExtentReports createInstance() {
		String filePath = getReportPath(reportFilepath);
		String path = null;
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(filePath);
		path = System.getProperty("user.dir") + "\\src\\main\\resources\\Configfiles";

		if (new File(path + File.separator + "ReportConfig.xml").exists())
			extentHtmlReporter.loadXMLConfig(path + File.separator + "ReportConfig.xml");

		extentHtmlReporter.config().setReportName(GetConfigProperties.getPropValue("ReportName"));
		reports = new ExtentReports();
		reports.attachReporter(extentHtmlReporter);
		if (System.getProperty("os.name").contains("Win")) {
			reports.setSystemInfo("OS", "Windows 10");
		} else {
			reports.setSystemInfo("OS", "Mac OSX");
		}
		return reports;
	}

	private static String getReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdirs()) {
				return reportLocation;
			} else {
				return System.getProperty("user.dir");
			}
		} else {
		}
		return reportLocation;
	}

	public static void setReportInfo(String key, String value) {
		reports.setSystemInfo(key, value);
	}

	public static String dateFormat() {
		Date date1 = null;
		String strDate = null;
		try {
			date1 = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyy hh:mm:ss");
			strDate = formatter.format(date1).replaceAll(":", "-").replace(" ", "_");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strDate;
	}
	
	public static void mark_the_test_fail(String teststatus, WebDriver driver, ExtentTest extenttest,
			Throwable throwable) throws IOException, InterruptedException ,AssertionError {

		extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));
		extenttest.error(throwable.getMessage());

	}
	
	public static void mark_the_test_fail_with_custom(String teststatus, WebDriver driver, ExtentTest extenttest,
			String message) throws IOException, InterruptedException {

		extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));
		extenttest.error(message);

	}


	public static void mark_the_test_pass(String teststatus, WebDriver driver, ExtentTest extenttest) throws IOException, InterruptedException {

			extenttest.pass(MarkupHelper.createLabel("Test Case is Passed", ExtentColor.GREEN));
	}
}
