package com.mrp.base;

import org.junit.runner.RunWith;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
features = {"src/test/java/customerfeatures"},
glue="stepdef"
,tags="@Regression"
)
public class CustomerRegressionRunner extends AbstractTestNGCucumberTests {

}




