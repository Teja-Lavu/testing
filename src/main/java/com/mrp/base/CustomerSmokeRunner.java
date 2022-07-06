package com.mrp.base;

import org.junit.runner.RunWith;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
	    features = { "src/main/java/com/mrp/config/customerfeatures" },
	    glue = "com/mrp/stepdef",
	    tags = "@Login"
	    )

 
public class CustomerSmokeRunner extends AbstractTestNGCucumberTests {

}