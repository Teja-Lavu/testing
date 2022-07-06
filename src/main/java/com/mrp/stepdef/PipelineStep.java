package com.mrp.stepdef;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.mrp.drivers.DriverManager;
import com.mrp.report.ReportManager;

import io.cucumber.java.en.When;

public class PipelineStep extends ReportManager {

        ExtentTest logtoreport = null;

        @When("User is on google.com")
	public void visit_google() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "User is on google.com");
                        DriverManager.getDriver().get("https://google.com");
                        DriverManager.getDriver().getTitle();
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}

        @When("User is on selenium.dev")
        public void visit_selenium() throws IOException, InterruptedException {
		try {
			logtoreport = scene_def.createNode(new GherkinKeyword("When"), "User is on selenium.dev");
                        DriverManager.getDriver().get("https://selenium.dev");
                        DriverManager.getDriver().getTitle();
		} catch (Exception ex) {
			ReportManager.mark_the_test_fail("Failed", DriverManager.getDriver(), logtoreport, ex);
		}
	}
}