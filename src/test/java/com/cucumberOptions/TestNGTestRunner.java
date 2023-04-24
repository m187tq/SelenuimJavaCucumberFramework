package com.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/java/com/features/"},
        glue = {"com/stepDefinitions"},
		monochrome = true,
        //tags = "@RegistrationFunctionality",
		tags = "@register",
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber.json",
                "html:target/cucumber-reports/cucumber-pretty",
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
   @Override
	  @DataProvider(parallel=true)
	public Object[][] scenarios() {
		  return super.scenarios();
	  }
}
