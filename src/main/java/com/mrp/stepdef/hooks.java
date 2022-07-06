package com.mrp.stepdef;
import java.io.IOException;
import java.net.MalformedURLException;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.mrp.drivers.DriverManager;
import com.mrp.report.ReportManager;
import com.mrp.utils.GenericMethods;
import com.mrp.utils.GetConfigProperties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class hooks extends ReportManager {

	public static Scenario scenario;
	 
	@Before
	public void setUp(Scenario scenario) throws MalformedURLException, InterruptedException {
        Thread.sleep(3000);
		System.out.println("Opening the browser");
		this.scenario = scenario;
		DriverManager.setupDriver();
		//GenericMethods.openUrl(GetConfigProperties.getPropValue("baseURL"));
		
		// Retrieving feature name to log in report
		String scenario_name = scenario.getName();
		System.out.println("Executing scenario : " + scenario_name);
		String rawFeatureName = scenario.getUri().toString();
		int begin = rawFeatureName.lastIndexOf('/') + 1;
		int end = rawFeatureName.lastIndexOf('.');
		String final_feature_name = rawFeatureName.substring(begin, end);
		// log4.info("Feature name : " + final_feature_name);
		if (scene.contains(final_feature_name)) {
		} else {
			scene.add(final_feature_name);
			test = reports.createTest(Feature.class, final_feature_name);
		}
		scene_def = test.createNode(scenario_name);
		// log4.info("Inside setup hook - End");

	}

	@After
	public void tearddown(Scenario scenario) throws MalformedURLException {
		
		System.out.println("Closing the browser");
		//WebDriver driver = DriverManager.getDriver();
		//if (driver != null) {
        //    driver.quit();
        //}

	}
	
	 
}