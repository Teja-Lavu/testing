package com.mrp.base;

import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = { "src/test/java/pipelinefeatures" },
    glue = "stepdef",
    tags = "@Pipeline"
    )

public class PipelineRunner extends AbstractTestNGCucumberTests {

}
