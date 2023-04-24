package com.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/com/features/"},
        glue = {"com/stepDefinitions"},
		monochrome = true,
		//tags = "@LoginValid",
		//tags = "@LoginValid_Positive",
		//tags = "@NegativeLogin",
		//tags = "@LoginValid",
        //tags = "@RegistrationFunctionality",
		tags = "@e2e",
		//tags = "@addMultipleItemsToCart",
		//tags = "@register",
		//tags = "@addRemoveItemsToCart",
        //tags = "@NegativeLogin",
        //dryRun = false,
        //Strict = false,
        //name = "Login",
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber.json",
                "html:target/cucumber-reports/cucumber-pretty",
				// "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
   /* @Override
	  @DataProvider(parallel=true)
	public Object[][] scenarios() {
		  return super.scenarios();
	  }*/
}
