package com.mrp.report;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ReportManagerRunner {
	static Map<Integer, ExtentTest> reportTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extentReports = ReportManager.createInstance();

	public static synchronized void endTest() {
		extentReports.flush();
	}

	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extentReports.createTest(testName);
		reportTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}

	public static synchronized ExtentTest getTest() {
		return reportTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static void setReportCategories(String suitName) {
		getTest().assignCategory(suitName);
	}
}
