package com.mrp.listeners;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mrp.report.ReportManager;
import com.mrp.report.ReportManagerRunner;
import com.mrp.utils.EmailManager;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.GetConfigProperties;

public class TestListner implements ITestListener {
	String testName = "";
	private static ExtentReports extent;

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext iTestContext) {

		extent = ReportManager.createInstance();

	}

	public void onFinish(ITestContext iTestContext) {

		extent.flush();

		//check if email report is on
		String pipeline = GetConfigProperties.getPropValue("email");
		if (pipeline.equalsIgnoreCase("false")) {
			return;
		}
		
		try {
			EmailManager.sendEmail();
		} catch (MessagingException e) {

			System.out.println("Got issue sending email : > ");
			e.printStackTrace();
		}

	}
}
